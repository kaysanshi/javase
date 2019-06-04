package com.zcib.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zcib.factory.BasicFactory;
import com.zcib.service.UserService;

/**
 * Servlet implementation class BatchDeleteUserServlet
 */
/**
 * 批量删除
 * @author 555
 *
 */
@WebServlet(description = "批量删除", urlPatterns = { "/addmin/BatchDeleteUserServlet" })
public class BatchDeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BatchDeleteUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserService service=BasicFactory.getFactory().GetInstance(UserService.class);	
		
		//1.
			String [] ids=request.getParameterValues("delId");
		//
			service.batchdel(ids);
		//
		request.getRequestDispatcher("/ListUserServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
