package com.itheima.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class MySReAttrListener
 *
 */
@WebListener
public class MySReAttrListener implements ServletRequestAttributeListener {

    /**
     * Default constructor. 
     */
    public MySReAttrListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletRequestAttributeListener#attributeRemoved(ServletRequestAttributeEvent)
     */
    public void attributeRemoved(ServletRequestAttributeEvent srae)  { 
         // TODO Auto-generated method stub
		System.out.println("���Ա��Ƴ�����SR����"+srae.getName()+":"+srae.getValue());

    }

	/**
     * @see ServletRequestAttributeListener#attributeAdded(ServletRequestAttributeEvent)
     */
    public void attributeAdded(ServletRequestAttributeEvent srae)  { 
         // TODO Auto-generated method stub
		System.out.println("���Ա����뵽��SR����"+srae.getName()+":"+srae.getValue());

    }

	/**
     * @see ServletRequestAttributeListener#attributeReplaced(ServletRequestAttributeEvent)
     */
    public void attributeReplaced(ServletRequestAttributeEvent srae)  { 
         // TODO Auto-generated method stub
		System.out.println("���Ա��滻����SR����"+srae.getName()+":"+srae.getValue());

    }
	
}
