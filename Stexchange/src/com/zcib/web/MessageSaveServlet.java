package com.zcib.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zcib.domain.Exchangearea;
import com.zcib.service.ExchangeService;

/**
 * Servlet implementation class MessageSaveServlet
 */
@WebServlet(description = "保存", urlPatterns = { "/student/MessageSaveServlet" })
public class MessageSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageSaveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String teacherid=request.getParameter("teacher");
		String title=request.getParameter("title");
		String content=request.getParameter("mscontent");
		System.out.println(teacherid+","+title+","+content);
		Exchangearea exchangearea=new Exchangearea();
		exchangearea.setContent(content);
		exchangearea.setTitle(title);
		//exchangearea.setStudentid();
		exchangearea.setTeacherid(Integer.parseInt(teacherid));
		ExchangeService service=new ExchangeService();
		boolean status=service.addMessage(exchangearea);
		if (status==true) {
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
