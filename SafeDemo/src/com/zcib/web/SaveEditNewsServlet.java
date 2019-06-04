package com.zcib.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Session;
import org.apache.commons.beanutils.BeanUtils;

import com.zcib.domain.News;
import com.zcib.factory.BasicFactory;
import com.zcib.service.NewsService;

/**
 * Servlet implementation class SaveEditNewsServlet
 */
@WebServlet(description = "保存修改后的新闻", urlPatterns = { "/addmin/SaveEditNewsServlet" })
public class SaveEditNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveEditNewsServlet() {
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
		
		try {
			BeanUtils.populate(news, request.getParameterMap());
			Boolean status=service.updateNews(news);
			if (status==true) {
				response.getWriter().write("1");
			}else{
				response.getWriter().write("0");
			}
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
