package com.zcib.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zcib.service.ExchangeService;
import com.zcib.service.FileService;
import com.zcib.utils.PageBean;

/**
 * Servlet implementation class SeachMessageServlet
 */
@WebServlet(description = "教师端消息的搜索", urlPatterns = { "/teacher/SeachMessageServlet" })
public class SeachMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeachMessageServlet() {
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
				String messagetitle=request.getParameter("messagetitle");
				ExchangeService service=new ExchangeService();
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
				PageBean bean =service.searchMessByTid(messagetitle,curPage,teacherid);
				request.setAttribute("pageBean", bean);	
				request.getRequestDispatcher("/teacher/listMessage.jsp").forward(request, response);
	
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
