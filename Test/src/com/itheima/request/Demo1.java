package com.itheima.request;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Demo1
 */
/*
 * request������
 * servletһ�㲻���������һ��������ת�Ƶ�jspҳ����Ȼ����ʾ����
 */
@WebServlet("/Demo1")
public class Demo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Demo1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//request������ ȫ����    getRequestDispater() ����һ����Ϊλ�ڸ���·������Դ��Դ�ķ�װ���� RequestDispatcher ����
		request.setAttribute("banana", "color:yellow");
		this.getServletContext().getRequestDispatcher("/Demo2").forward(request, response);
	
		//ת����xxxjsp��
	//��Ҫ��ȡ���е�����ru
		String result="xxxx";
		request.setAttribute("xxx", result);
		request.getRequestDispatcher("xxx.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
