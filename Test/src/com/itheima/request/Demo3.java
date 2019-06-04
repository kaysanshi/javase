package com.itheima.request;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Demo3
 */
/*
 * 请求转发
 */
@WebServlet("/Demo3")
public class Demo3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Demo3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//请求转发时响应的类型也是在当前页面设置的
		response.setContentType("text/html;charset=utf-8");
		////
		response.getWriter().write("demo3...");
		//用flush时就会把转发的内容显示出来
		//response.getWriter().flush();
		//请求转发
		request.getRequestDispatcher("/Demo4").forward(request, response);
		//请求转发时不能同时设置多个转发
		//request.getRequestDispatcher("/index.jsp").forward(request, response);
		//
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
