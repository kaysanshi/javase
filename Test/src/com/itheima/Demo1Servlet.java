package com.itheima;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 解决servlet线程安全问题:
 * 继承SingleThreadModel时当有请求来的时候回创建一个对象
 * 其采用的方式是产生多个Servlet实例对象，并发的每个线程分别调用一个独立的Servlet实例对象
 * 但是并没有解决线程安全问题;
 * 
 * 最终的解决的问题是:尽量少用类变量,或静态变量,如果有的话就用:
 * 所以一般情况下都是用加锁的方式,效率低
 */
//下面的这句话代表着在xml里面写了映射mapping
@WebServlet("/Demo1Servlet")
public class Demo1Servlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
       int i=0;
    public Demo1Servlet() {
        super();
        
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		synchronized (this) {
			i++;
				try {
					Thread.sleep(4*1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			response.getWriter().write(i+"");
		}
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		doGet(request, response);
	}

}
