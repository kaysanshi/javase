package com.zcib.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zcib.domain.Exchangearea;
import com.zcib.service.ExchangeService;
import com.zcib.service.FileService;
import com.zcib.utils.PageBean;

/**
 * Servlet implementation class MessageSeachServlet
 */
@WebServlet(description = "学生消息搜索", urlPatterns = { "/student/MessageSeachServlet" })
public class MessageSeachServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageSeachServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String messagename=request.getParameter("messagename");
		System.out.println("标题："+messagename);
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
		ExchangeService service=new ExchangeService();
		///
		System.out.println(curPage);
       PageBean pageBean=service.SearchMessagePageBean(curPage,messagename);
      // System.out.println("......."+pageBean);
       request.setAttribute("pageBean",pageBean);
       response.getWriter().write("1");
       request.getRequestDispatcher("/student/listMessage.jsp").forward(request, response);
	
	
	
	
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
