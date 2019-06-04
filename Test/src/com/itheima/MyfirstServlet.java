package com.itheima;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * 创建servlet可以分为以下三个步骤:
 * 1.继承httpServlet实现其中的方法;
 * 2.在web.xml进行配置其中的映射关系;(serlvet (serlvet-class,serlvet-name))(serlvet-mapping(serlvet-name,url-pattern))
 * 3.运行即可;
 * 其中出现localHost本地连接出问题时:去看下Servers中的配置;
 *	在web.xml配置多个相应的<serlvet-mapping>
 *	<url-pattern>/servlet/My/*</url-pattern>
 *	这些优先级是*.xx的最低
 *	<!-- 如果在<servlet>元素中配置了一个<load-on-startup>元素，
	  那么WEB应用程序在启动时，就会装载并创建Servlet的实例对象、
	  以及调用Servlet实例对象的init()方法。
	   -->
 */


public class MyfirstServlet extends HttpServlet {
	//多态的运用这里
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().write("now time:"+new Date().toLocaleString());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
