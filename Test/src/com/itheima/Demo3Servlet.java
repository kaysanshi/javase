package com.itheima;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//��ʾservletcontentText���������
//�������仰��������xml����д��ӳ��mapping
@WebServlet("/Demo3Servlet")
public class Demo3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Demo3Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		ServletContext context=this.getServletContext();
		String vString=(String)context.getAttribute("apple");
		System.out.println(vString);
	}

	
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
