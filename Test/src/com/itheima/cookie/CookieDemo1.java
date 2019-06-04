package com.itheima.cookie;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * cookie是Cookie是客户端技术，程序把每个用户的数据以cookie的形式
 * 写给用户各自的浏览器。当用户使用浏览器再去访问服务器中的web资源时，
去。这样，web资源处理的就是用户各自的数据了。

 */
/**
 * Servlet implementation class CookieDemo1
 */
@WebServlet("/CookieDemo1")
public class CookieDemo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieDemo1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		
		//创建cookie数组
		Cookie[] cookies=request.getCookies();
		Cookie findC=null;
		if(cookies!=null){
		for(Cookie c :cookies){
			if("lasttime".equals(c.getName())){
				findC=c;
			}
		}
		}
		if(findC==null){
			response.getWriter().write("你是第一次访问这个网站");
		}else{
			//cookies是返回一个long行的值
			Long lastTime=Long.parseLong(findC.getValue());
			response.getWriter().write("你上次访问的时间是："+new Date(lastTime).toLocaleString());
		}
		
		Date date=new Date();
		Cookie cookie=new Cookie("lasttime", date.getTime()+"");
		//设置cookies保存的最多时间
		//相当于response中添加了一个Set-cookie的响应头
		cookie.setMaxAge(36000);
		//设置整个web应用的cookie信息都可以带过去；
		cookie.setPath(request.getContextPath());
		response.addCookie(cookie);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
