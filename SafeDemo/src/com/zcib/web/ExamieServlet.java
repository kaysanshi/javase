package com.zcib.web;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.zcib.domain.Problem;
import com.zcib.factory.BasicFactory;
import com.zcib.service.ProblemService;

/**
 * Servlet implementation class ExamieServlet
 */
/**
 * 答题出卷
 * @author 555
 *
 */
@WebServlet("/ExamieServlet")
public class ExamieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExamieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProblemService service=BasicFactory.getFactory().GetInstance(ProblemService.class);
		Object user=request.getSession().getAttribute("user");
	
		
			int count=service.getAllProblemCount();
			//List<Object> list1=service.getRowid();
			//for(Object object:list1){
			//	System.out.println(object);
			//}
			//System.out.println(list1.toString());
			if (count!=0) {
				List<Problem> list=service.outProblem(count);
				request.setAttribute("list",list);
				request.getRequestDispatcher("/problem/examie.jsp").forward(request, response);
			}else{
				response.sendRedirect(request.getContextPath()+"/index.jsp");
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
