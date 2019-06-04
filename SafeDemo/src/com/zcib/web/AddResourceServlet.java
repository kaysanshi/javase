package com.zcib.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.mysql.jdbc.Field;
import com.zcib.domain.Resource;
import com.zcib.domain.Video;
import com.zcib.factory.BasicFactory;
import com.zcib.service.ResourceService;
import com.zcib.utils.IOUtils;

/**
 * Servlet implementation class AddResourceServlet
 */
@WebServlet(description = "资源的添加", urlPatterns = { "/AddResourceServlet","/addmin/AddResourceServlet" })
public class AddResourceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddResourceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取实例
		ResourceService service=BasicFactory.getFactory().GetInstance(ResourceService.class);
		String user=(String)request.getSession().getAttribute("user");
		if (user==null) {
			response.sendRedirect("/addmin/login.jsp");
		}else{
			String upload=this.getServletContext().getRealPath("upload/resource");
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
						System.out.println("minfz "+filename);
						String picturename=null;
						String resourcename=null;
						if(filename.endsWith("png")||filename.endsWith("jpg")||filename.endsWith("jpeg")){
							picturename=filename;
							System.out.println("p:"+picturename);
						}else{
							resourcename=filename;
							System.out.println("文件名；"+resourcename);
						}
						System.out.println("文件；"+resourcename);
							//获得资源的UUID但是未能够获取；
							String uuidfilename=UUID.randomUUID().toString()+"_"+resourcename;
							map.put("realname", resourcename);
							System.out.println(map.get(resourcename));
							map.put("uuidname",uuidfilename);
							map.put("ip", request.getRemoteAddr());
							map.put("picture",picturename);
							String savepath="/upload/resource";
							new File(upload).mkdirs();
							map.put("savepath", savepath);
							request.setAttribute("filename", map.get(filename));
							request.setAttribute("savepath", savepath);
							request.setAttribute("picture", map.get(picturename));
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
				Resource resource=new Resource();
				BeanUtils.populate(resource, map);
				Boolean status=service.addResource(resource);
				//3.
				if (status==true) {
					response.getWriter().write("1");
				}else{
					response.getWriter().write("0");
				}

			} catch (FileUploadException | IllegalAccessException | InvocationTargetException  e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
