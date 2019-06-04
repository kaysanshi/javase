package com.itheima.upload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FilePermission;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.itheima.util.IOUtils;

import sun.nio.ch.IOUtil;



/**
 * Servlet implementation class UploadServlet
 */
@WebServlet(description = "�ļ��ϴ�", urlPatterns = { "/UploadServlet" })
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpSep=rvlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//ͨ����������ʵ��
		DiskFileItemFactory factory=new DiskFileItemFactory();
		//���û�������С
		factory.setSizeThreshold(100*1024);
		//������ʱ�ļ���
		factory.setRepository(new File(this.getServletContext().getRealPath("WEB-INF/temp")));
		//2.�����ļ��ϴ�������
		ServletFileUpload fileUpload=new ServletFileUpload(factory);
		try {
		//�ж��Ƿ�Ϊ�����ı��ϴ��ļ�
		//if (fileUpload.isMultipartContent(request)) {
			//throw new RuntimeException("������ȷ�ı��ϴ�");
		//}
		//�����ļ���С���ϴ�����
		fileUpload.setFileSizeMax(1024*1024*10);
		fileUpload.setSizeMax(1024*1024*100);
		//���ñ���
		fileUpload.setHeaderEncoding("UTF-8");
		//�����ϴ�������������
		fileUpload.setProgressListener(new ProgressListener() {
			//
			Long beginTime = System.currentTimeMillis();
			//�Ѿ����ˣ��ܹ����� �������ڼ�����
			@Override
			public void update(long pBytesRead, long pContentLength, int pItems) {
				// TODO Auto-generated method stub
				//ת��Ϊkb
				//double br=pBytesRead*1.0/1024;
				//double cl=pContentLength*1.0/1024;
				//Ϊ�˱����ֽ������·���
				BigDecimal br = new BigDecimal(pBytesRead).divide(new BigDecimal(1024),2,BigDecimal.ROUND_HALF_UP);
				BigDecimal cl = new BigDecimal(pContentLength).divide(new BigDecimal(1024),2,BigDecimal.ROUND_HALF_UP);
				System.out.print("��ǰ��ȡ���ǵ�"+pItems+"���ϴ���,�ܴ�С"+cl+"KB,�Ѿ���ȡ"+br+"KB");
				//ʣ���ֽ���
				BigDecimal ll = cl.subtract(br);
				System.out.print("ʣ��"+ll+"KB");
				//�ϴ��ٷֱ�
				BigDecimal per = br.multiply(new BigDecimal(100)).divide(cl,2,BigDecimal.ROUND_HALF_UP);
				System.out.print("�Ѿ����"+per+"%");
				//�ϴ���ʱ
				Long nowTime = System.currentTimeMillis();
				Long useTime = (nowTime - beginTime)/1000;
				System.out.print("�Ѿ���ʱ"+useTime+"��");
				//�ϴ��ٶ�
				BigDecimal speed = new BigDecimal(0);
				if(useTime!=0){
					//��������ģʽ������ھӡ�ת�䣬���������ھӶ��ǵȾ�ģ��������������Բ�����ġ�
					speed = br.divide(new BigDecimal(useTime),2,BigDecimal.ROUND_HALF_UP);
				}
				System.out.print("�ϴ��ٶ�Ϊ"+speed+"KB/S");
				//����ʣ��ʱ��
				BigDecimal ltime = new BigDecimal(0);
				if(!speed.equals(new BigDecimal(0))){
					//����һ�� BigDecimal ����ֵΪ (this / divisor) �������Ϊָ����
					ltime = ll.divide(speed,0,BigDecimal.ROUND_HALF_UP);
				}
				System.out.print("����ʣ��ʱ��Ϊ"+ltime+"��");
				
				System.out.println();
				}
		});
		
		//3.�����ļ��ϴ�������������request
			List<FileItem> list=fileUpload.parseRequest(request);
			//ѭ������
			for(FileItem item :list){
				if (item.isFormField()) {
					//��ͨ���ֶλ�õ���һ��������
					String name=item.getFieldName();
					String value=item.getString("utf-8");
					System.out.println(name+":"+value);
				}else{
					//��ǰһ���ļ��ϴ���
					String filename=item.getName();//�ļ���
					//����һ����һ�޶����ļ���
					String uuidfilename=UUID.randomUUID().toString()+"_"+filename;
					//ת��Ϊhashֵ
					int hash=uuidfilename.hashCode();
					//ת��Ϊhash�ַ���
					String hashstr=Integer.toHexString(hash);
					char[] hss=hashstr.toCharArray();
					String path=this.getServletContext().getRealPath("upload");
					for(char c:hss){
						path+="/"+c;
					}
					new File(path).mkdirs();
					InputStream inputStream=item.getInputStream();
					
					OutputStream outputStream=new FileOutputStream(new File(path,uuidfilename)); 
					IOUtils.In2Out(inputStream, outputStream);
					IOUtils.close(inputStream, outputStream);
					//ɾ����ʱ�ļ�
					item.delete();
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
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
