package com.zcib.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.zcib.domain.Problem;
import com.zcib.domain.User;
import com.zcib.factory.BasicFactory;
import com.zcib.service.ProblemService;
/**
 * 问题的修改
 */
/**
 * Servlet implementation class UpdateProblemServlet
 */
@WebServlet(description = "修改", urlPatterns = { "/UpdateProblemServlet" })
public class UpdateProblemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProblemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProblemService service=BasicFactory.getFactory().GetInstance(ProblemService.class);
	//1.
		
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
		
		//2.
		service.updateProblem(problem);
		//3
		request.getRequestDispatcher("/ListProblemServlet").forward(request, response);
			
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
