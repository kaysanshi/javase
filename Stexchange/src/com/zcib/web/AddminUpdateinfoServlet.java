package com.zcib.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zcib.domain.Addmin;
import com.zcib.service.AddminService;

/**
 * Servlet implementation class AddminUpdateinfoServlet
 */
@WebServlet(description = "管理员修改个人信息", urlPatterns = { "/addmin/AddminUpdateinfoServlet" })
public class AddminUpdateinfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddminUpdateinfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		Addmin addmin=new Addmin();
		addmin.setId(Integer.parseInt(id));
		addmin.setPassword(password);
		AddminService service=new AddminService();
		int i=service.updeteAddmin(addmin);
		if (i !=0) {
			System.out.println("修改成功");
			response.getWriter().write("1");
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
