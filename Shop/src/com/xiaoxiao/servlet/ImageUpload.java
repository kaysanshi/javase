package com.xiaoxiao.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xiaoxiao.utils.Upload;

public class ImageUpload extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");//获取文件名时防止中文乱码
		response.setContentType("text/html;charset=utf-8");
		String action = request.getParameter("action");
		if("fileBrowse".equals(action)){
			fileBrowse(request,response);
		}else if("fileUpload".equals(action)){
			fileUpload(request,response);
		}
	}
	     
     public void fileUpload(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{  
    	 	
    	 	String dir = "/uploadimages/";//文件保存根目录，保存到uploadimages目录下
			String type = "";
			if(request.getParameter("type") != null)//获取文件分类
    	 		type = request.getParameter("type").toLowerCase() + "/";
			dir +=type;
  	         //获取回调JS的函数Num
    	 	String callback = request.getParameter("CKEditorFuncNum");
    	 	String filepath = Upload.upload(dir,request,response);
    	 	String script ="<script type='text/javascript'>window.parent.CKEDITOR.tools.callFunction("+callback+",'"+request.getContextPath() +filepath+"')</script>";
    	 	response.getWriter().print(script);
     }  
     
     public void fileBrowse(HttpServletRequest request, HttpServletResponse response)
 			throws ServletException, IOException {
    	 	String path = request.getContextPath() + "/";
    		String type = "";
    		if(request.getParameter("type") != null)//获取文件分类
    			type = request.getParameter("type").toLowerCase() + "/";
    		String clientPath = "uploadimages/" + type;
    		File root = new File(request.getSession().getServletContext().getRealPath(clientPath));
    		if(!root.exists()){
    			root.mkdirs();
    		}
    		String callback = request.getParameter("CKEditorFuncNum");
    		File[] files = root.listFiles();
    		if(files.length > 0){

    			for(File file:files ) {
    				String src = path + clientPath + file.getName();
    				response.getWriter().print("<img width='110px' height='70px' src='" +src + "' alt='" + file.getName() + "' onclick=\"funCallback("+callback+",'"+ src +"')\">");
    			}
    		}else{
    			response.getWriter().print("<h3>未检测到资源。</h3>");
    		}
    		String script ="<script type='text/javascript'>"+
    				"function funCallback(funcNum,fileUrl){"+
    			"var parentWindow = ( window.parent == window ) ? window.opener : window.parent;"+
    			"parentWindow.CKEDITOR.tools.callFunction(funcNum, fileUrl);"+
    			"window.close();}"+"</script>";
    		response.getWriter().print(script);
     }
     
     
     
	
}
