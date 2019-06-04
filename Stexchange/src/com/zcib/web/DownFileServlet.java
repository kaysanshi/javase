package com.zcib.web;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.zcib.service.FileService;
import com.zcib.utils.FileUtils;

/**
 * Servlet implementation class DownFileServlet
 */
@WebServlet(description = "文件下载", urlPatterns = { "/student/DownFileServlet" ,"/addmin/DownFileServlet"})
public class DownFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownFileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("filesid");
		FileService service=new FileService();
		List<Map<String, Object>> file=service.getFileById(id);
		//
//		for (Map<String, Object> map : file) {
//			for (Map.Entry<String, Object> entry : map.entrySet()) {
//				System.out.println(entry.getKey() + ":" + entry.getValue());
//			}
//		}
		Map<String, Object> map=null;
		for(int i=0;i<file.size();i++){
			map=file.get(i);
		}
		System.out.println(map);
		FileUtils utils=new FileUtils();
		ServletContext servletContext=request.getServletContext();
		int i=utils.download(servletContext, response,map,request);
		if(i==1){
			response.getOutputStream().write(1);
		}else{
			response.getOutputStream().write(0);
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
