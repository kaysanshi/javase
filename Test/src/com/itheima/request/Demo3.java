package com.itheima.request;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Demo3
 */
/*
 * ����ת��
 */
@WebServlet("/Demo3")
public class Demo3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Demo3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//����ת��ʱ��Ӧ������Ҳ���ڵ�ǰҳ�����õ�
		response.setContentType("text/html;charset=utf-8");
		////
		response.getWriter().write("demo3...");
		//��flushʱ�ͻ��ת����������ʾ����
		//response.getWriter().flush();
		//����ת��
		request.getRequestDispatcher("/Demo4").forward(request, response);
		//����ת��ʱ����ͬʱ���ö��ת��
		//request.getRequestDispatcher("/index.jsp").forward(request, response);
		//
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
