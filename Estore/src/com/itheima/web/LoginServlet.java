package com.itheima.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1.У����֤��
		String valistr1=request.getParameter("valistr");
		String valistr2=(String) request.getSession().getAttribute("valistr");
		if (valistr1==null||valistr2==null||!valistr1.equals(valistr2)) {
			request.setAttribute("msg","<font color='red'>��֤�벻��ȷ!</font>");
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		//2.��װ����У������
		
		//3.����serviceע���û�
		//4.�ص���ҳ
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
