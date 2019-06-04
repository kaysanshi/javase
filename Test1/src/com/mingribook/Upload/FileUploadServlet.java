package com.mingribook.Upload;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
//文件上传
/**
 * Servlet implementation class FileUploadServlet
 */
@WebServlet("/fileupload")

public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.println("<HTML>");
		out.println("<BODY>");
		out.println("<H3>FileUpload:Servlet Sample</H3>");
		out.println("<hr>");
		try{
			//实例一个硬盘文件工厂用来配置上传组件servletFileUpload
			DiskFileItemFactory factory=new DiskFileItemFactory();
			//设置缓冲区的大小4kb
			factory.setSizeThreshold(4096);
			//实例化上传组件
			ServletFileUpload upload=new ServletFileUpload(factory);
			//设置上传的文件的尺寸
			upload.setSizeMax(4194304);
			//设置上传地址
			String uploadPath=this.getServletContext().getRealPath("/WEB-INF/upload");
			//解析request请求
			FileItemIterator fii= upload.getItemIterator(request);
			//处理数据
			while(fii.hasNext()){
				//得到当前的文件流
				FileItemStream fis=fii.next();
				//检查当前项目是普通表单还是文件上传
				if (fis.isFormField()) {
					//显示表单
					if("desc".equals(fis.getFieldName())){
						out.println("file description:"+fis.getFieldName()+"<br/>");
					}
					
				}else{
					//处理文件
					//得到文件的路径
					String  path=fis.getName();
					//得到出除文件路径的名字
					String  filename=path.substring(path.lastIndexOf("\\")+1);
					//将文件保存到web目录下的upload文件夹中
					BufferedInputStream bis=new BufferedInputStream(fis.openStream());
					BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(new File(uploadPath+"\\"+filename)));
					//把文件写到指定的文件上传
					Streams.copy(bis, bos, true);
					out.println(filename+"file upload.<br/>");
				}
			}
		}catch(FileUploadException e){}
		out.println("</BODY>");
		out.println("</HTML>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
