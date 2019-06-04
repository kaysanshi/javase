package com.itheima.request;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ParamServlet
 */
/*
 * 请求参数的编码问题
 */
@WebServlet("/ParamServlet")
public class ParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ParamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		 * post提交乱码解决
		 */
		//此处也要进行对服务器编码进行设置(通知服务器以什么编码解码http请求中的实体内容)
		request.setCharacterEncoding("utf-8");
		//获取请求参数的值但是传中文字符是会转义到其他的
		String name=request.getParameter("username");
		//System.out.println(name);
		/*
		 * get提交乱码解决方式(同样也适合post提交方式)
		 * 现对提交的参数按照iso8859-1进行编码,然后在解码到其他码表转回
		 * 
		 */
			String username=new String(name.getBytes("iso8859-1"),"utf-8");
		/////
		//获取到用一个枚举变量的类型；
		Enumeration<String> enumeration=request.getParameterNames();
		while(enumeration.hasMoreElements()){
			String names=enumeration.nextElement();
			String values=request.getParameter(names);
			System.out.println(names+":"+values);
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
