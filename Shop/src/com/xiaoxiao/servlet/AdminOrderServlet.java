package com.xiaoxiao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xiaoxiao.service.OrderService;

public class AdminOrderServlet extends HttpServlet {
	private OrderService orderService = new OrderService();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action = request.getParameter("action");
		if("findAll".equals(action)){
			findAll(request,response);
		}
	}

	private void findAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1.获取所有订单
		 * 2.存入request
		 * 3.重定向到admin/orderList.jsp页面
		 */
		request.setAttribute("orderlist", orderService.findAll());
		request.getRequestDispatcher("/admin/orderList.jsp").forward(request, response);
		
	}

}
