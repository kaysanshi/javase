package com.mingribook.Upload;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;




/**
 * Servlet implementation class PartuploadServlet
 */
@WebServlet("/partupload")
@MultipartConfig
public class PartuploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PartuploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out=response.getWriter();
		out.println("<HTML>");
		out.println("<BODY>");
		out.println("<H3>jspSmartUpload:Servlet Sample</H3>");
		out.println("<hr>");
		String desc=request.getParameter("desc");
		Part file=request.getPart("file");
		//从part对象中的头信息获得上传的名字
		String header=file.getHeader("content-disposition");
		//从上传的对象中分离出文件的扩展名
		String filename=((header.split(";")[2]).split("=")[1]).replaceAll("\"", "");
		String extname=filename.substring(filename. lastIndexOf('.')+1);
		//构造新的文件名
		String newfilename=System.currentTimeMillis()+extname;
		//设置上传的地址
		String uploadpath=getServletContext().getRealPath("/WEB-INF/upload");
		//完成上传
		try{
			file.write(uploadpath+File.separator+newfilename);
			out.println("1 file upload.<br>");
			out.println("file description:"+desc);
			
		}catch(Exception e){
		out.println("Unable to upload thefile.<br>");
		out.println("Error:"+e.toString());
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
