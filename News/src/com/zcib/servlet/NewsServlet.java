package com.zcib.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zcib.domain.New;
import com.zcib.service.NewsService;

public class NewsServlet extends HttpServlet {
	private NewsService newsService = new NewsService();
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action = request.getParameter("action");
		if("findAll".equals(action)){
			findAll(request,response);
		}
	}
	
	
	
	public void findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 1.调用Service层的findAllNews方法来获取所有新闻
		 * 2.存入request域中
		 * 3.转到new_list.jsp页面来显示。
		 */
		
		request.setAttribute("list", newsService.findNewsList());
		request.getRequestDispatcher("news_list.jsp").forward(request, response);
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}
}
