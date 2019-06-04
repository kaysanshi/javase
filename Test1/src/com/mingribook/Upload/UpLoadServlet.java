package com.mingribook.Upload;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;

//采用jspSmartUpload组件上传文件
/**  
 * Servlet implementation class UpLoadServlet
 */

@WebServlet("/upload")

public class UpLoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpLoadServlet() {
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
		out.println("<H3>jspSmartUpload:Servlet Sample</H3>");
		out.println("<hr>");
		//用smartupload类处理
		SmartUpload mSmartUpload=new SmartUpload();
		//上传文件的数量
		int count=0;
		
		try {
			mSmartUpload.initialize(this.getServletConfig(), request, response);
			//限制每个文件的最大长度
			mSmartUpload.setMaxFileSize(50*1024*1024);
			//设定允许上传的文件，仅允许doc,text,文件
			mSmartUpload.setAllowedFilesList("doc,txt");
			mSmartUpload.upload();
			//获得上传文件
			File file=mSmartUpload.getFiles().getFile(0);
			//获得上传文件的名字
			String fname=file.getFileName();
			//文件的保存目录
			
			count =mSmartUpload.save("/WEB-INF/upload");
			//获得文件的描述信息
			Request re=mSmartUpload.getRequest();
			String desc=re.getParameter("desc");
			out.println(count+"file uploaded.<br>");
			out.println("file description :"+desc);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.println("Unable to upload the File<br>");
			out.println("Error:"+e.toString());
		}
		out.println("</BODY>");
		out.println("</HTML>");
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
