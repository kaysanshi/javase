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
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import com.zcib.domain.News;
import com.zcib.factory.BasicFactory;
import com.zcib.service.NewsService;
import com.zcib.utils.IOUtils;

/**
 * Servlet implementation class AddNewsServlet
 */
@WebServlet(description = "新闻添加", urlPatterns = { "/addmin/AddNewsServlet" })
public class AddNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		NewsService service=BasicFactory.getFactory().GetInstance(NewsService.class);
		//1.
		String upload=this.getServletContext().getRealPath("upload/news");
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
					map.put("picturename", uuidfilename);	
					String savepath="/upload/news";
					new File(upload).mkdirs();
					map.put("picturepath", savepath);
					request.setAttribute("picturename", map.get(filename));
					request.setAttribute("picturepath", savepath);
					System.out.println(savepath);
					InputStream inputStream=item.getInputStream();
					
					OutputStream outputStream=new FileOutputStream(new File(upload,uuidfilename)); 
					IOUtils.In2Out(inputStream, outputStream);
					IOUtils.close(inputStream, outputStream);
					//
					item.delete();
				}
			}
		///
		News news=new News();
		int upid=(int)request.getSession().getAttribute("id");
		news.setUpid(upid);
		BeanUtils.populate(news, map);
		Boolean boolean1=service.addNews(news);
			if (boolean1==true) {
				response.getWriter().write("1");
			}else{
				//
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
