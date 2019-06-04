package com.itheima.response;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RefreshServlet
 */
/*
 * 定时刷新功能:refresh
 */
@WebServlet("/RefreshServlet")
public class RefreshServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RefreshServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//隔几秒刷新页面
		//response.getWriter().write(new Date().toString());
		//response.setHeader("Refresh", "1");
		//隔几秒会到主页
		//response.setCharacterEncoding("utf-8");
		//response.setHeader("Content-Type", "text/html;charset=utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("恭喜你注册成功 3秒后跳转页面....");
		response.setHeader("refresh", "3;url=/Test/index.jsp");
		//但是一般不会这样写会把写出的话放到html页面中
		//向newFilehtml那样进行操作可以在html中用<meta http-equiv="" content="">来模拟响应头信息
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
