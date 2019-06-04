package com.zcib.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zcib.domain.News;
import com.zcib.domain.Problem;
import com.zcib.factory.BasicFactory;
import com.zcib.service.NewsService;
import com.zcib.service.ProblemService;

/**
 * Servlet implementation class EditorSubjectServlet
 */
@WebServlet(description = "修改问题", urlPatterns = { "/addmin/EditorSubjectServlet" })
public class EditorSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditorSubjectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProblemService service=BasicFactory.getFactory().GetInstance(ProblemService.class);
		Problem problem=new Problem();
		String id=request.getParameter("id");
		problem.setSubjectid(Integer.parseInt(id));
		Problem problemInfo=service.getProblem(problem);
		request.setAttribute("list", problemInfo);
		request.getRequestDispatcher("/addmin/EditProblem.jsp").forward(request, response);
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
