package com.itheima.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class MuHSessionListener
 *
 */
@WebListener
public class MuHSessionListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public MuHSessionListener() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * 监听session创建
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    	System.out.println("sesion被穿件了"+se.getSession());
    
    }

	/**
	 * 监听session对象销毁
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    	System.out.println("sesion被销毁了"+se.getSession());

    }
	
}
