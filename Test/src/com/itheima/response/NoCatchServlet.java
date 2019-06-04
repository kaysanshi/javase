package com.itheima.response;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NoCatchServlet
 */
/*
 * ʵ��������Ƿ񻺴���Դ1.�����л���
 */
@WebServlet("/NoCatchServlet")
public class NoCatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoCatchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//������Ӧͷ��Ϣ��������в����л���
		response.setIntHeader("Expires", -1);
		response.setHeader("Cache-control","no-cache");
		response.setHeader("Pragma","no-cache");
		//ͬʱ���÷�������������ı��뷽ʽ
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("��ǰʱ����:"+new Date().toLocaleString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
