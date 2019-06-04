package com.itheima.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class MySRequestListener
 *监听request对象创建和销毁
 */
@WebListener
public class MySRequestListener implements ServletRequestListener {

    /**
     * Default constructor. 
     */
    public MySRequestListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    public void requestDestroyed(ServletRequestEvent sre)  { 
         // TODO Auto-generated method stub
		System.out.println("request对象被销毁了. ..."+sre.getServletRequest());

    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent sre)  { 
         // TODO Auto-generated method stub
		System.out.println("request对象创建了. ..."+sre.getServletRequest());

    }
	
}
