package com.itheima.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
//����������
public class MyServletCListener implements ServletContextListener {
	//
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("ServletContext���󱻴�����"+sce.getServletContext());
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("ServletContext����������"+sce.getServletContext());

	}

}
