package com.zcib.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zcib.domain.Exchangearea;
import com.zcib.service.ExchangeService;

/**
 * Servlet implementation class ReplyServlet
 */
@WebServlet("/teacher/ReplyServlet")
public class ReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取参数
		String msid=request.getParameter("msid");
		System.out.println("????"+msid);
		ExchangeService service=new ExchangeService();
		List<Map<String, Object>> list=service.getMessagebyid(msid);
		request.setAttribute("list", list);
		System.out.println(list);
		if (list.size()>0) {
			response.getWriter().write("1");
			System.out.println("查询到有这些");
			request.getRequestDispatcher("/teacher/reply.jsp").forward(request, response);
		}else{
			System.out.println("未能找到");
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
