package com.itheima.request;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Demo1
 */
/*
 * request作用域
 * servlet一般不会输出数据一般会把数据转移到jsp页面中然后显示出来
 */
@WebServlet("/Demo1")
public class Demo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Demo1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//request作用域 全局域    getRequestDispater() 返回一个作为位于给定路径的资源资源的封装器的 RequestDispatcher 对象。
		request.setAttribute("banana", "color:yellow");
		this.getServletContext().getRequestDispatcher("/Demo2").forward(request, response);
	
		//转发到xxxjsp中
	//先要获取其中的数据ru
		String result="xxxx";
		request.setAttribute("xxx", result);
		request.getRequestDispatcher("xxx.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
