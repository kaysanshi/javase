package com.itheima.response;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RefreshServlet
 */
/*
 * ��ʱˢ�¹���:refresh
 */
@WebServlet("/RefreshServlet")
public class RefreshServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RefreshServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//������ˢ��ҳ��
		//response.getWriter().write(new Date().toString());
		//response.setHeader("Refresh", "1");
		//������ᵽ��ҳ
		//response.setCharacterEncoding("utf-8");
		//response.setHeader("Content-Type", "text/html;charset=utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("��ϲ��ע��ɹ� 3�����תҳ��....");
		response.setHeader("refresh", "3;url=/Test/index.jsp");
		//����һ�㲻������д���д���Ļ��ŵ�htmlҳ����
		//��newFilehtml�������в���������html����<meta http-equiv="" content="">��ģ����Ӧͷ��Ϣ
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
