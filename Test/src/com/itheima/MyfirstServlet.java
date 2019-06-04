package com.itheima;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * ����servlet���Է�Ϊ������������:
 * 1.�̳�httpServletʵ�����еķ���;
 * 2.��web.xml�����������е�ӳ���ϵ;(serlvet (serlvet-class,serlvet-name))(serlvet-mapping(serlvet-name,url-pattern))
 * 3.���м���;
 * ���г���localHost�������ӳ�����ʱ:ȥ����Servers�е�����;
 *	��web.xml���ö����Ӧ��<serlvet-mapping>
 *	<url-pattern>/servlet/My/*</url-pattern>
 *	��Щ���ȼ���*.xx�����
 *	<!-- �����<servlet>Ԫ����������һ��<load-on-startup>Ԫ�أ�
	  ��ôWEBӦ�ó���������ʱ���ͻ�װ�ز�����Servlet��ʵ������
	  �Լ�����Servletʵ�������init()������
	   -->
 */


public class MyfirstServlet extends HttpServlet {
	//��̬����������
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().write("now time:"+new Date().toLocaleString());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
