package com.xiaoxiao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xiaoxiao.domain.Page;
import com.xiaoxiao.service.ProductService;

public class ProductServlet extends HttpServlet {

	private ProductService productService = new ProductService();
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");//防止请求中中文乱码
		String action = request.getParameter("action");
		if("findIndex".equals(action)){
			findIndex(request,response);
		}else if("findAll".equals(action)){
			findAll(request,response);
		}else if("findById".equals(action)){
			findById(request,response);
		}
		if(action == null){
			findIndex(request,response);
		}
		
	}


	private void findById(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1.获取id
		 * 2.调用Service层读取id的数据
		 * 3.请求转发到productdetails.jsp页面
		 */
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		
		request.setAttribute("item", productService.findById(id));
		request.getRequestDispatcher("/productdetails.jsp").forward(request, response);
		
	}

	private void findAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//用于分页的参数
		String current = request.getParameter("current");
		int currentPage;
		try{
			currentPage = Integer.parseInt(current);
		}catch(Exception e){
			currentPage = 1;
		}
		//用于查询的参数
		String skey = "name";
		String svalue = request.getParameter("svalue");
		//用于排序的参数
		String sortkey = request.getParameter("sortkey");
		String sort = request.getParameter("sort");
		//调用Service层来获取数据
		Page page = productService.findAll(currentPage,skey,svalue,sortkey,sort);
		//存入request中
		request.setAttribute("sortkey", sortkey);
		request.setAttribute("sort", sort);
		request.setAttribute("svalue", svalue);
		request.setAttribute("page", page);
		//请求转发到productList.jsp页面
		request.getRequestDispatcher("/productList.jsp").forward(request,response);
	}


	private void findIndex(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1.调用Service层的方法，读取0-12条记录
		 * 2.存入到request中
		 * 3.请求转发到myindex.jsp页面
		 */
		request.setAttribute("list", productService.findIndex());
		request.getRequestDispatcher("/myindex.jsp").forward(request, response);
	}

}
