package com.zcib.web;

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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import com.zcib.domain.Video;
import com.zcib.domain.User;
import com.zcib.factory.BasicFactory;
import com.zcib.service.UserService;
import com.zcib.service.VideoService;
import com.zcib.utils.DaoUtils;
import com.zcib.utils.IOUtils;
/**
 * 上传文件的
 */

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet(urlPatterns = { "/UploadVideoServlet","/addmin/AddVideoServlet"})
public class UploadVideoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadVideoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		VideoService service=BasicFactory.getFactory().GetInstance(VideoService.class);
		//获得项目名
				String requestPath1=request.getContextPath();
				int star=requestPath1.length();
				System.out.println(star);
				//获取请求的路径
				String requestpath=request.getRequestURI();
				System.out.println(requestpath);
				int i=requestpath.lastIndexOf("/");
				System.out.println(i);
				//获取请求的是哪一个
				String path=requestpath.substring(star,i);
				System.out.println(path);
		
		//1.
				String upload=this.getServletContext().getRealPath("upload/video");
				String temp=this.getServletContext().getRealPath("WEB-INF/temp");
				//
				DiskFileItemFactory factory=new DiskFileItemFactory();
				factory.setSizeThreshold(1024*100);
				factory.setRepository(new File(temp));
				//2.
				ServletFileUpload fileUpload=new ServletFileUpload(factory);
				//
				fileUpload.setHeaderEncoding("UTF-8");
				//
				fileUpload.setFileSizeMax(1024*1024*100);
				fileUpload.setSizeMax(1024*1024*100);
				try {
					List<FileItem> list=fileUpload.parseRequest(request);
					Map<String,String> map=new HashMap<>();
					//
					for(FileItem item :list){
						if (item.isFormField()) {
							//
							String name=item.getFieldName();
							String value=item.getString("utf-8");
							map.put(name, value);
							System.out.println(name+":"+value);
						}else{
							//获取名称
							String filename=item.getName();//
							//uuid
							String uuidfilename=UUID.randomUUID().toString()+"_"+filename;
							map.put("realname", filename);
							map.put("uuidname",uuidfilename);
							map.put("ip", request.getRemoteAddr());
							String savepath="/upload";
							//ֵ
							//int hash=uuidfilename.hashCode();
							//
							//String hashstr=Integer.toHexString(hash);
							//char[] hss=hashstr.toCharArray();
							
							//for(char c:hss){
								//upload+="/"+c;
								//savepath+="/"+c;
							//}
							new File(upload).mkdirs();
							map.put("savepath", savepath);
							request.setAttribute("filename", map.get(filename));
							request.setAttribute("savepath", savepath);
							System.out.println(savepath);
							InputStream inputStream=item.getInputStream();
							
							OutputStream outputStream=new FileOutputStream(new File(upload,uuidfilename)); 
							IOUtils.In2Out(inputStream, outputStream);
							IOUtils.close(inputStream, outputStream);
							//
							item.delete();
						}
					}
					//
					Video  video=new Video();
					BeanUtils.populate(video, map);
					//2.
					Boolean bool=service.addVideo(video);
					
					//3.
					if ("/addmin".equals(path)) {
						if (bool=true) {
							response.getWriter().write("1");
						}else{
							response.getWriter().write("0");
						}
						
					}else{
						request.getRequestDispatcher("/DownVideoListServlet").forward(request, response);
					}	
				} catch (FileUploadException | IllegalAccessException | InvocationTargetException  e) {
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
