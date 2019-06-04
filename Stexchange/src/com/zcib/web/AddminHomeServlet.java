package com.zcib.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zcib.domain.Addmin;
import com.zcib.domain.Student;
import com.zcib.service.AddminService;
import com.zcib.service.StudentService;

/**
 * Servlet implementation class EddminHomeServlet
 */
@WebServlet(description = "管理员个人信息管理", urlPatterns = { "/addmin/AddminHomeServlet" })
public class AddminHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddminHomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sessio=request.getSession();
		String id=sessio.getAttribute("id").toString();
		System.err.println(id);
		if (id==null) {
			response.sendRedirect("/login.jsp");
		}
		System.out.println(id);
		AddminService service=new AddminService();
		Addmin addmin=new Addmin();
		addmin.setId(Integer.parseInt(id));
		List<Map<String, Object>> list=service.getAddminInfoById(addmin);
		System.out.println("addmin"+list.size());
		request.setAttribute("list",list);
		
		request.getRequestDispatcher("/addmin/upmyhome.jsp").forward(request, response);
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
