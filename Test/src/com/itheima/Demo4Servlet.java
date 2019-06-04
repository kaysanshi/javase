package com.itheima;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Demo4Servlet
 * Servletcontext的域的应用
 */
//下面的这句话代表着在xml里面写了映射mapping
@WebServlet(asyncSupported = true, urlPatterns = { "/Demo4Servlet" })
public class Demo4Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Demo4Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	public  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		ServletContext context=this.getServletContext();
		Enumeration enumeration=context.getInitParameterNames();
		while(enumeration.hasMoreElements()){
			String name=(String)enumeration.nextElement();
			String value=context.getInitParameter(name);
			System.out.println(name+":"+value);
		}
	}

	
	public  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
