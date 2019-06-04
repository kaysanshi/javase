package com.itheima.request;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ParamServlet
 */
/*
 * ��������ı�������
 */
@WebServlet("/ParamServlet")
public class ParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ParamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		 * post�ύ������
		 */
		//�˴�ҲҪ���жԷ����������������(֪ͨ��������ʲô�������http�����е�ʵ������)
		request.setCharacterEncoding("utf-8");
		//��ȡ���������ֵ���Ǵ������ַ��ǻ�ת�嵽������
		String name=request.getParameter("username");
		//System.out.println(name);
		/*
		 * get�ύ��������ʽ(ͬ��Ҳ�ʺ�post�ύ��ʽ)
		 * �ֶ��ύ�Ĳ�������iso8859-1���б���,Ȼ���ڽ��뵽�������ת��
		 * 
		 */
			String username=new String(name.getBytes("iso8859-1"),"utf-8");
		/////
		//��ȡ����һ��ö�ٱ��������ͣ�
		Enumeration<String> enumeration=request.getParameterNames();
		while(enumeration.hasMoreElements()){
			String names=enumeration.nextElement();
			String values=request.getParameter(names);
			System.out.println(names+":"+values);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
