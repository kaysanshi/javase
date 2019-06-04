package com.zcib.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zcib.domain.Exchangearea;
import com.zcib.service.ExchangeService;
import com.zcib.utils.PageBean;

/**
 * Servlet implementation class ListMessageServlet
 */
@WebServlet(description = "消息列表", urlPatterns = { "/teacher/ListMessageServlet"})
public class ListMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListMessageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获得项目名
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
				String id=(String)request.getSession().getAttribute("id");
				System.out.println("teacher"+id);
		//
		ExchangeService exchange=new ExchangeService();
		List<Map<String,Object>> list= exchange.getMessageList(id);
		if(list.size()<0){
			response.getWriter().write("0");
			System.out.println("列表为null");
		}else{
			String page = request.getParameter("page");
			// 当前的页数
			int curPage = 0; 
			//没有获得page值的处理
			if (page == null || page.length() < 1) { 
				curPage = 1;
			} else {
				curPage = Integer.parseInt(page);
			}
			request.setAttribute("list", list);
			PageBean pageBean=exchange.getListPage(curPage,id);  
			request.setAttribute("pageBean", pageBean);
		//request.setAttribute("list", list);
			if(path.equals("/teacher")){
				request.getRequestDispatcher("/teacher/listMessage.jsp").forward(request, response);	
			}
		
		
		
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