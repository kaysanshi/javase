package com.zcib.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.zcib.domain.News;
import com.zcib.factory.BasicFactory;
import com.zcib.service.NewsService;

/**
 * Servlet implementation class DeleteNewsServlet
 */
@WebServlet(description = "删除新闻", urlPatterns = { "/addmin/DeleteNewsServlet" })
public class DeleteNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteNewsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//
		NewsService service=BasicFactory.getFactory().GetInstance(NewsService.class);
		String  id=request.getParameter("id");
		
		News news=new News();
		news.setId(Integer.parseInt(id));
		Boolean boolean1=service.deleteNews(news);
		if(boolean1==true){
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
