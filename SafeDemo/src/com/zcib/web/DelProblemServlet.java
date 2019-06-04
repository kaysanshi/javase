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
import com.zcib.domain.Video;
import com.zcib.factory.BasicFactory;
import com.zcib.service.ProblemService;

/**
 * Servlet implementation class DelProblemServlet
 */
/**
 * 删除问题
 * @author 555
 *
 */
@WebServlet(description = "删除问题", urlPatterns = { "/addmin/DelProblemServlet" })
public class DelProblemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelProblemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProblemService service =BasicFactory.getFactory().GetInstance(ProblemService.class);
		
		Problem  problem=new Problem();
		String id=request.getParameter("id");
		problem.setSubjectid(Integer.parseInt(id));
		try {
			BeanUtils.populate(problem, request.getParameterMap());
			
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			boolean sturs=service.delProblem(problem);
			if (sturs==true) {
				response.getWriter().write("1");
			}else{
				response.getWriter().write("0");
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
