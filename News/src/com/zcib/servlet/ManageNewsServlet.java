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

public class ManageNewsServlet extends HttpServlet {

	private NewsService newsService = new NewsService();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action = request.getParameter("action");
		if("addNew".equals(action)){
			addNew(request,response);
		}else if("findAll".equals(action)){
			findAll(request,response);
		}else if("delete".equals(action)){
			deleteById(request,response);
		}else if("updatebefore".equals(action)){
			updatebefore(request,response);
		}else if("updateNew".equals(action)){
			updateNew(request,response);
		}else if("deleteMore".equals(action)){
			deleteMore(request,response);
		}
		
	}

	private void deleteMore(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1.获取表单数据
		 * 2.调用Service的deleteMore方法，进行删除
		 * 3.调用findAll方法，显示删除后的列表
		 */
		//1.获取表单数据
		String ids[]= request.getParameterValues("sel");
		newsService.deleteMore(ids);
		findAll(request,response);
	}


	private void updateNew(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1.获取表单数据
		 * 2.封装到New对象中
		 * 3.调用Service的update方法进行更新
		 * 4.调用findAll方法，显示更新后的列表
		 */
		//1.获取表单数据
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String content = request.getParameter("content");
		String publishedDate = request.getParameter("publishedDate");
		//2.封装到New对象中
		New annew = new New();
		annew.setId(Integer.parseInt(id));
		annew.setAuthor(author);
		annew.setContent(content);
		annew.setTitle(title);
		try {
			annew.setPublishedDate(new SimpleDateFormat("yyyy-MM-dd").parse(publishedDate));
		} catch (ParseException e) {
			throw new RuntimeException(e.getMessage());
		}
		//3.调用Service的update方法进行更新
		newsService.update(annew);
		//4.调用findAll方法，显示更新后的列表
		findAll(request,response);
		
	}


	private void updatebefore(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1.获取id
		 * 2.调用service的findById（id），获取编号是id的记录
		 * 3.把该条新闻存入request中
		 * 4.请求转发到updateNew.jsp
		 */
		//1.获取id
		String id = request.getParameter("id");
		// 2.调用service的findById（id），获取编号是id的记录3.把该条新闻存入request中
		request.setAttribute("annew", newsService.findById(id));
		
		//4.请求转发到updateNew.jsp
		request.getRequestDispatcher("manage/updateNews.jsp").forward(request, response);
		
	}


	private void deleteById(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 根据id删除一条新闻
		 * 1.获取id值
		 * 2.调用service的deleteById删除该条记录
		 * 3.跳转新闻列表页，显示删除后的新闻列表
		 */
		String id = request.getParameter("id");
		newsService.deleteById(id);
		findAll(request,response);
		
	}


	public void addNew(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 1.获取表单信息，验证
		 * 2.封装到New对象中
		 * 3.调用Service的addNew方法，添加一条新闻
		 * 4.根据返回信息，
		 * 5.跳转到addNews.jsp页面，显示提示信息
		 */
		New annew = new New();
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String content = request.getParameter("content");
		String publishedDate = request.getParameter("publishedDate");
		
		annew.setTitle(title);
		annew.setAuthor(author);
		annew.setContent(content);
		try {
			annew.setPublishedDate(new SimpleDateFormat("yyyy-MM-dd").parse(publishedDate));
		} catch (ParseException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
		System.out.println(annew);
		newsService.addNew(annew);
		request.setAttribute("msg", "发布成功！");
		request.getRequestDispatcher("manage/addNews.jsp").forward(request, response);
	}

	private void findAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("list", newsService.findNewsList());
		request.getRequestDispatcher("manage/newsList.jsp").forward(request,response);
		
	}

}
