package com.zcib.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import com.zcib.domain.User;
import com.zcib.factory.BasicFactory;
import com.zcib.service.UserService;

/**
 * Servlet implementation class DelUserServlet
 */
/**
 * 删除用户
 * @author 555
 *
 */
@WebServlet(description = "删除", urlPatterns = { "/addmin/DelUserServlet" })
public class DelUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		UserService service=BasicFactory.getFactory().GetInstance(UserService.class);
		try{
		//1.
		
		User  user=new User();
		BeanUtils.populate(user, request.getParameterMap());
		
		//2.
		boolean stuts=service.deleteUser(user);
		if (stuts==true) {
			response.getWriter().write("1");
		}
		//3.
		//request.getRequestDispatcher("/ListUserServlet").forward(request, response);
		}catch(Exception e){
			
		}	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
