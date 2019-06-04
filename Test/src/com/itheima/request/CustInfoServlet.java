package com.itheima.request;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CustInfoServlet
 */
/*
 * 获取客户端的信息
 */
@WebServlet("/CustInfoServlet")
public class CustInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1.获取客户端请求的完整的url
		String url=request.getRequestURL().toString();
		System.out.println(url);
		//2.获取客户端请求的资源的部分名称 
		String uri=request.getRequestURI();
		System.out.println(uri);
		//3.获取请求行中的参数部分
		String pram=request.getQueryString();
		System.out.println(pram);
		//4.返回客户端的ip地址(*)
		String ip=request.getRemoteAddr();
		System.out.println(ip);
		//5.获取客户机的请求方式
		String method=request.getMethod();
		System.out.println(method);
		//6.获取当前web的应用的名称
		String name=request.getContextPath();
		System.out.println(name);
		
		//请求转发时以后有这个方法
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
