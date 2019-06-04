package com.itheima;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Demo5serlvet
 */
//servletContext实现请求转发
//转发到demo6在demo6中对于回应一个response;
@WebServlet("/Demo5serlvet")
public class Demo5servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Demo5servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher=this.getServletContext().getRequestDispatcher("/Demo6Servlet");
		dispatcher.forward(request, response);
		}

	
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
