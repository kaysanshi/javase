package com.itheima.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class MySCAttrListener
 *
 */
@WebListener
public class MySCAttrListener implements ServletContextAttributeListener {

    /**
     * Default constructor. 
     */
    public MySCAttrListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextAttributeListener#attributeAdded(ServletContextAttributeEvent)
     */
    public void attributeAdded(ServletContextAttributeEvent scab)  { 
         // TODO Auto-generated method stub
		System.out.println("���Ա����뵽��SC����"+scab.getName()+":"+scab.getValue());

    }

	/**
     * @see ServletContextAttributeListener#attributeRemoved(ServletContextAttributeEvent)
     */
    public void attributeRemoved(ServletContextAttributeEvent scab)  { 
         // TODO Auto-generated method stub
		System.out.println("���Ա��Ƴ�SC����"+scab.getName()+":"+scab.getValue());

    }

	/**
     * @see ServletContextAttributeListener#attributeReplaced(ServletContextAttributeEvent)
     */
    public void attributeReplaced(ServletContextAttributeEvent scab)  { 
         // TODO Auto-generated method stub
		System.out.println("���Ա��滻SC����"+scab.getName()+":"+scab.getValue());

    }
	
}
