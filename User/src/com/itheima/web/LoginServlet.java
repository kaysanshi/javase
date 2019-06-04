package com.itheima.web;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.User;
import com.itheima.service.UserService;

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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		UserService service = new UserService();
		//1.��ȡ�ͻ����ύ���û�������
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//2.����Service�еķ�������û�������
		User user = service.isUser(username, password);
		if(user == null){
			//3.�������ȷ����ʾ
			request.setAttribute("msg", "�û������벻��ȷ!");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}else{
			//4.��ȷ���¼�û����ض���ص���ҳ
			request.getSession().setAttribute("user", user);
			
			if("ok".equals(request.getParameter("remname"))){
				//����û���ѡ����ס�û�����cookie������������û���
				Cookie remNameC = new Cookie("remname",URLEncoder.encode(user.getUsername(), "utf-8"));
				remNameC.setPath(request.getContextPath());
				remNameC.setMaxAge(3600*24*30);
				response.addCookie(remNameC);
			}else{
				//����û�û�й�ѡ��ס�û�����ɾ����ס�û�����cookie
				Cookie remNameC = new Cookie("remname","");
				remNameC.setPath(request.getContextPath());
				remNameC.setMaxAge(0);
				response.addCookie(remNameC);
			}
			//�Ӷ���
			response.sendRedirect(request.getContextPath()+"/index.jsp");
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
