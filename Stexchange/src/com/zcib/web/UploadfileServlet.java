package com.zcib.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zcib.domain.Files;
import com.zcib.service.FileService;
import com.zcib.utils.FileUtils;
import com.zcib.utils.SimpleDate;

import sun.swing.StringUIClientPropertyKey;

/**
 * Servlet implementation class UploadfileServlet
 */
@WebServlet(description = "文件上传", urlPatterns = { "/teacher/UploadfileServlet" })
public class UploadfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//参数
		String temp=this.getServletContext().getRealPath("WEB-INF/temp");
		//获取ip
		String ip=request.getRemoteAddr();
		String uploadPath="/upload/files";
		FileUtils fileupload=new FileUtils();
			fileupload.upload(request, uploadPath, temp);
		Map<String, Object> file=fileupload.getFile();
		System.out.println(file.get("filePath"));
		System.out.println("后："+file.get("uuidname"));
		System.out.println("描述信息："+(String)file.get("desc"));
		String teacherid=(String)request.getSession().getAttribute("id");
		FileService  service=new FileService();
		Files files=new Files();
			files.setUuidname((String)file.get("uuidname"));
			files.setFiletitle((String)file.get("filetitle"));
			files.setRealname((String)file.get("filename"));
			files.setDescription((String)file.get("desc"));
			files.setSavepath(uploadPath);
			files.setUploadip(ip);
			//后续处理
			files.setUploadteacherid(Integer.parseInt(teacherid));
			files.setUploadtime(new SimpleDate().getdate());
			boolean status=service.addFile(files);
			if(status==true){
				response.getWriter().write("1");
			}else{
				response.getWriter().write("0");
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
