package com.itheima.request;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CustInfoServlet
 */
/*
 * ��ȡ�ͻ��˵���Ϣ
 */
@WebServlet("/CustInfoServlet")
public class CustInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1.��ȡ�ͻ��������������url
		String url=request.getRequestURL().toString();
		System.out.println(url);
		//2.��ȡ�ͻ����������Դ�Ĳ������� 
		String uri=request.getRequestURI();
		System.out.println(uri);
		//3.��ȡ�������еĲ�������
		String pram=request.getQueryString();
		System.out.println(pram);
		//4.���ؿͻ��˵�ip��ַ(*)
		String ip=request.getRemoteAddr();
		System.out.println(ip);
		//5.��ȡ�ͻ���������ʽ
		String method=request.getMethod();
		System.out.println(method);
		//6.��ȡ��ǰweb��Ӧ�õ�����
		String name=request.getContextPath();
		System.out.println(name);
		
		//����ת��ʱ�Ժ����������
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
