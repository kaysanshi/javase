package com.itheima;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//用的不是特别多;
public class ConfigServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取servlet在web.xml配置信息的名称
		ServletConfig  config=this.getServletConfig();
//		String name=config.getServletName();
//		System.out.println(name);
		//这样可以设置开发是的编码方式在web.xml
		//获取当前serlvet中的配置的初始化参数;
//		String values=config.getInitParameter("name2");
//		System.out.println(values);
//		Enumeration enumeration=config.getInitParameterNames();
//		while(enumeration.hasMoreElements()){
//			String name=(String)enumeration.nextElement();
//			String value=config.getInitParameter(name);
//			System.out.println(name+":"+value);
//		}
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		//获取serlvetContext对象代表当前web应用
		/*
		 * 使用servletContext
		 */
		ServletContext sContext=config.getServletContext();
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
