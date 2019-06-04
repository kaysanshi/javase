package com.zcib.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.ws.api.ServiceSharedFeatureMarker;
import com.zcib.service.FileService;
import com.zcib.utils.PageBean;

/**
 * Servlet implementation class FileSeachServlet
 */
@WebServlet(description = "教师端查询", urlPatterns = { "/teacher/FileSeachServlet" })
public class FileSeachServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileSeachServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//接受参数
		String teacherid=(String)request.getSession().getAttribute("id");
		String filename=request.getParameter("filename");
		FileService service=new FileService();
		// 获得要显示的页数
		String page = request.getParameter("page");
		// 当前的页数
		int curPage = 0; 
		//没有获得page值的处理
		if (page == null || page.length() < 1) { 
			curPage = 1;
		} else {
			curPage = Integer.parseInt(page);
		}
		PageBean bean =service.search(filename,curPage,teacherid);
		request.setAttribute("pageBean", bean);	
		request.getRequestDispatcher("/teacher/listfile.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
