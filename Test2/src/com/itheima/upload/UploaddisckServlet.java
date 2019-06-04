package com.itheima.upload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.itheima.domain.Resource;
import com.itheima.util.DaoUtils;
import com.itheima.util.IOUtils;

/**
 * Servlet implementation class UploaddisckServlet
 */
@WebServlet("/UploaddisckServlet")
@MultipartConfig
public class UploaddisckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploaddisckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1.�ϴ��ļ�
		String upload=this.getServletContext().getRealPath("WEB-INF/upload");
		String temp=this.getServletContext().getRealPath("WEB_INF/temp");
		//�����������û����С�ʹ��ͻ�����·��
		DiskFileItemFactory factory=new DiskFileItemFactory();
		factory.setSizeThreshold(1024*100);
		factory.setRepository(new File(temp));
		//2.�����ļ��ϴ�������
		ServletFileUpload fileUpload=new ServletFileUpload(factory);
		//���ñ���
		fileUpload.setHeaderEncoding("UTF-8");
		//�����ļ���С���ϴ�����
		fileUpload.setFileSizeMax(1024*1024*10);
		fileUpload.setSizeMax(1024*1024*100);
		//��鵱ǰ����Ŀ�Ƿ�Ϊ�ϴ��ļ�
		//if (fileUpload.isMultipartContent(request)) {
			//throw new RuntimeException("������ȷ�ı��ϴ�");
		//}
		//����request
		//3.�����ļ��ϴ�������������request
		try {
			List<FileItem> list=fileUpload.parseRequest(request);
			Map<String,String> map=new HashMap<>();
			//ѭ������
			for(FileItem item :list){
				if (item.isFormField()) {
					//��ͨ���ֶλ�õ���һ����
					String name=item.getFieldName();
					String value=item.getString("utf-8");
					map.put(name, value);
					System.out.println(name+":"+value);
				}else{
					//��ǰһ���ļ��ϴ���
					String filename=item.getName();//�ļ���
					//����һ����һ�޶����ļ���
					String uuidfilename=UUID.randomUUID().toString()+"_"+filename;
					map.put("realname", filename);
					map.put("uuidname",uuidfilename);
					map.put("ip", request.getRemoteAddr());
					String savepath="/WEB-INF/upload";
					//ת��Ϊhashֵ
					int hash=uuidfilename.hashCode();
					//ת��Ϊhash�ַ���
					String hashstr=Integer.toHexString(hash);
					char[] hss=hashstr.toCharArray();
					
					for(char c:hss){
						upload+="/"+c;
						savepath+="/"+c;
					}
					new File(upload).mkdirs();
					map.put("savepath", savepath);
					InputStream inputStream=item.getInputStream();
					
					OutputStream outputStream=new FileOutputStream(new File(upload,uuidfilename)); 
					IOUtils.In2Out(inputStream, outputStream);
					IOUtils.close(inputStream, outputStream);
					//ɾ����ʱ�ļ�
					item.delete();
				}
			}
			//�����ݿ��в���
			Resource resource=new Resource();
			BeanUtils.populate(resource, map);
			String sql="insert into netdisk values(null,?,?,?,?,null,?)";
			QueryRunner runner=new QueryRunner(DaoUtils.getSource());
			runner.update(sql,resource.getUuidname(),resource.getRealname(),resource.getSavepath(),resource.getIp(),resource.getDescription() );
			//3.�ض������ҳ
			response.sendRedirect(request.getContextPath()+"/disk/index.jsp");
		} catch (FileUploadException | IllegalAccessException | InvocationTargetException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
