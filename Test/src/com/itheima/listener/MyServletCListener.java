package com.itheima.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
//用来监听的
public class MyServletCListener implements ServletContextListener {
	//
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("ServletContext对象被创建了"+sce.getServletContext());
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("ServletContext对象被销毁了"+sce.getServletContext());

	}

}
