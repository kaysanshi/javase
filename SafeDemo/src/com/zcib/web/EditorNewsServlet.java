package com.zcib.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zcib.domain.News;
import com.zcib.factory.BasicFactory;
import com.zcib.service.NewsService;

/**
 * Servlet implementation class EditorNewsServlet
 */
@WebServlet(description = "修改新闻", urlPatterns = { "/addmin/EditorNewsServlet" })
public class EditorNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditorNewsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		NewsService service=BasicFactory.getFactory().GetInstance(NewsService.class);
		News news=new News();
		String id=request.getParameter("id");
		news.setId(Integer.parseInt(id));
		News newsInfo=service.getNews(news);
		request.setAttribute("list", newsInfo);
		request.getRequestDispatcher("/addmin/EditNews.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
