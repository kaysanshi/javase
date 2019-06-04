package com.itheima.listener;

import java.util.LinkedHashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;

import com.itheima.domain.User;

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
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
		ServletContext context = sce.getServletContext();
		context.setAttribute("usermap", new LinkedHashMap<User, HttpSession>());
	
    }
	
}
