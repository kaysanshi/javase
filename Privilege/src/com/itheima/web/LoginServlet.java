package com.itheima.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.itheima.domain.User;
import com.itheima.util.DaoUtils;
import com.itheima.util.MD5Utils;

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
		response.setContentType("text/html;charset=utf-8");
		//1.��ȡ�û�������
		String name = request.getParameter("name");
		String password  = MD5Utils.md5(request.getParameter("password"));
		//2.У���û�������
		String sql = "select * from user where name = ? and password = ? ";
		User user = null;
		try {
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			user = runner.query(sql, new BeanHandler<User>(User.class),name,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(user == null){
			response.getWriter().write("�û������벻��ȷ");
			return;
		}else{
			//3.��¼�û�
				ServletContext context = this.getServletContext();
				request.getSession().setAttribute("user", user);
			//4.�ض�����ҳ
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
