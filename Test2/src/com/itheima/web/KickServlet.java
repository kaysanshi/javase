package com.itheima.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.itheima.domain.User;
import com.itheima.util.DaoUtils;

/**
 * Servlet implementation class KickServlet
 */
@WebServlet("/KickServlet")
public class KickServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KickServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1.��ȡҪ�����ߵ��˵�id
				String id = request.getParameter("id");
				//2.����id��ѯ���û�
				String sql = "select * from user where id = ?";
				QueryRunner runner = new QueryRunner(DaoUtils.getSource());
				User user = null;
				try {
					user = runner.query(sql, new BeanHandler<User>(User.class),id);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//3.��usermap���ҵ�����û���Ӧ��session
				ServletContext context = this.getServletContext();
				Map<User,HttpSession> map = (Map<User, HttpSession>) context.getAttribute("usermap");
				HttpSession session = map.get(user);
				//4.ɱ������û�session
				if(session!=null)
					session.invalidate();
				//5.�ض����û��б�ҳ��
				response.sendRedirect(request.getContextPath()+"/userList.jsp");
			}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
