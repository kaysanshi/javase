package com.itheima.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class MySCListener
 *
 */
@WebListener
public class MySCListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public MySCListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
		System.out.println("ServletContext对象被销毁了"+sce.getServletContext());

    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
		System.out.println("ServletContext对象被创建了"+sce.getServletContext());

    }
	
}
