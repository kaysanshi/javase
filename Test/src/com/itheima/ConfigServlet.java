package com.itheima;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//�õĲ����ر��;
public class ConfigServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//��ȡservlet��web.xml������Ϣ������
		ServletConfig  config=this.getServletConfig();
//		String name=config.getServletName();
//		System.out.println(name);
		//�����������ÿ����ǵı��뷽ʽ��web.xml
		//��ȡ��ǰserlvet�е����õĳ�ʼ������;
//		String values=config.getInitParameter("name2");
//		System.out.println(values);
//		Enumeration enumeration=config.getInitParameterNames();
//		while(enumeration.hasMoreElements()){
//			String name=(String)enumeration.nextElement();
//			String value=config.getInitParameter(name);
//			System.out.println(name+":"+value);
//		}
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		//��ȡserlvetContext�������ǰwebӦ��
		/*
		 * ʹ��servletContext
		 */
		ServletContext sContext=config.getServletContext();
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
