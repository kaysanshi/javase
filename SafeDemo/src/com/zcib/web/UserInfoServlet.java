package com.zcib.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zcib.domain.User;
import com.zcib.factory.BasicFactory;
import com.zcib.service.UserService;
/**
 * Servlet implementation class UserInfoServlet
 */
@WebServlet(description = "用户信息", urlPatterns = { "/UserInfoServlet" })
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserService service=BasicFactory.getFactory().GetInstance(UserService.class);
		//1.获取id
		String id=request.getParameter("id");
		System.out.println("id为"+id);
		//2.
		User user=service.findUserByid(id);
		if(user==null){
			throw new RuntimeException("用户不存在");
		}
		//3.
		request.setAttribute("user", user);
		
		request.getRequestDispatcher("/user/updateUser.jsp").forward(request, response);	

	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
