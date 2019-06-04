package com.zcib.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zcib.domain.Problem;
import com.zcib.factory.BasicFactory;
import com.zcib.service.ProblemService;

/**
 * Servlet implementation class ProblemInfoServlet
 */
@WebServlet(description = "问题信息", urlPatterns = { "/ProblemInfoServlet" })
public class ProblemInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProblemInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProblemService service=BasicFactory.getFactory().GetInstance(ProblemService.class);
		String id=request.getParameter("id");
		Problem problem=service.getinfobyid(id);
		request.setAttribute("problem",problem);
		request.getRequestDispatcher("/problem/updateproblem.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
