package com.itheima.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class MySRequestListener
 *����request���󴴽�������
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
		System.out.println("request����������. ..."+sre.getServletRequest());

    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent sre)  { 
         // TODO Auto-generated method stub
		System.out.println("request���󴴽���. ..."+sre.getServletRequest());

    }
	
}
