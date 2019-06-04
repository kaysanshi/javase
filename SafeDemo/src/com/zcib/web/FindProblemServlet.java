package com.zcib.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import com.zcib.domain.Problem;
import com.zcib.factory.BasicFactory;
import com.zcib.service.ProblemService;


/**
 * Servlet implementation class FindProblemServlet
 */
/**
 * 后台问题查询
 * @author 555
 *
 */
@WebServlet(description = "查询问题", urlPatterns = { "/FindProblemServlet" })
public class FindProblemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindProblemServlet() {
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
		try {
			BeanUtils.populate(problem, request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Problem> list= service.findProblembyCheck(problem);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/problem/listproblem.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
