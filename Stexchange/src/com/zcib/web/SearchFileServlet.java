package com.zcib.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Field;
import com.zcib.service.FileService;
import com.zcib.utils.PageBean;

/**
 * Servlet implementation class SearchFileServlet
 */
@WebServlet(description = "文件的搜索", urlPatterns = { "/student/SearchFileServlet","/addmin/SearchFileServlet" })
public class SearchFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchFileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		////
		String filename=request.getParameter("filename");
		System.out.println("文件名："+filename);
		String page = request.getParameter("page");
		System.out.println(page);
		// 当前的页数
		int curPage = 0; 
		//没有获得page值的处理
		if (page == null || page.length() < 1) { 
			curPage = 1;
		} else {
			curPage = Integer.parseInt(page);
		}
		 FileService service=new FileService();
		///
		System.out.println(curPage);
       PageBean pageBean=service.SearchPageBean(curPage,filename);
      // System.out.println("......."+pageBean);
       request.setAttribute("pageBean",pageBean);
       if (path.equals("/student")) {
    	   response.getWriter().write("1");
           request.getRequestDispatcher("/student/listfile.jsp").forward(request, response);
	}else if (path.equals("/addmin")) {
		response.getWriter().write("1");
		request.getRequestDispatcher("/addmin/listfiles.jsp").forward(request, response);
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
