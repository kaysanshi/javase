package com.zcib.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zcib.domain.Problem;
import com.zcib.domain.User;
import com.zcib.factory.BasicFactory;
import com.zcib.service.ProblemService;
import com.zcib.service.UserService;

/**
 * Servlet implementation class EditorUserServlet
 */
@WebServlet(description = "修改用户", urlPatterns = { "/addmin/EditorUserServlet" })
public class EditorUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditorUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserService service=BasicFactory.getFactory().GetInstance(UserService.class);
		User user=new User();
		String id=request.getParameter("id");
		user.setUserid(Integer.parseInt(id));
		User userInfo=service.getUser(user);
		request.setAttribute("list", userInfo);
		request.getRequestDispatcher("/addmin/EditUser.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
