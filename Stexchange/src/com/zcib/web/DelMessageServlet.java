package com.zcib.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zcib.service.ExchangeService;

/**
 * Servlet implementation class DelMessageServlet
 */
@WebServlet(description = "删除消息", urlPatterns = { "/teacher/DelMessageServlet" })
public class DelMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelMessageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//
		String mssageid=request.getParameter("msid");
		ExchangeService service=new ExchangeService();
		boolean status=service.DelMessage(mssageid);
		if(status==true){
			System.out.println("删除成功");
			response.getWriter().write("1");
		}else{
			System.out.println("删除失败");
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
