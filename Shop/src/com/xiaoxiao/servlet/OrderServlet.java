package com.xiaoxiao.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xiaoxiao.domain.Address;
import com.xiaoxiao.domain.Order;
import com.xiaoxiao.domain.OrderItem;
import com.xiaoxiao.domain.Product;
import com.xiaoxiao.domain.User;
import com.xiaoxiao.service.AddressService;
import com.xiaoxiao.service.OrderService;

public class OrderServlet extends HttpServlet {
	private OrderService orderService = new OrderService();
	private AddressService addressService = new AddressService();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action = request.getParameter("action");
		if("add".equals(action)){
			add(request,response);
		}
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1.获取表单数据
		 * 2.创建订单对象
		 *    2.1获取购物车中所有商品
		 *    2.2生成OrderItem
		 *    2.3生成Order
		 *    2.4清空购物车
		 * 3.用来调用Service层的add(Order order)方法
		 * 4.清空购物车
		 * 4.转发到付款paying.jsp页面
		 */
		String addressid = request.getParameter("addressid");
		HttpSession session = request.getSession();
		List<Map<String,Object>> cart = (List<Map<String, Object>>) session.getAttribute("cart");
		
		if(cart==null){
			//购物车为空，抛出错误！
			throw new RuntimeException();
		}
		
		//2.创建订单对象
		Order order = new Order();
		//设置配送地址
		
		order.setUser((User) session.getAttribute("user"));
		order.setAddress(addressService.find(Integer.parseInt(addressid)));
		order.setTotalprice((Float) session.getAttribute("totalprice"));
		order.setOrdertime(new Date());
		order.setOrderid(UUID.randomUUID().toString().replace("-", ""));
		order.setStatus(0);//未付款
		
		List<OrderItem> orderItemList =new ArrayList<OrderItem>();
		for(int i=0;i<cart.size();i++){
			//依次取出购物车中商品，每一个商品生成一个订单条目
			Map<String,Object> map = cart.get(i);
			OrderItem orderItem = new OrderItem();
			orderItem.setTotal((Float) map.get("total"));
			orderItem.setOrder(order);
			orderItem.setBuycount((Integer) map.get("buycount"));
			
			Product product = new Product();
			product.setCategoryid((Integer) map.get("categoryid"));
			product.setContent((String) map.get("content"));
			product.setHit((Integer) map.get("hit"));
			product.setMarkprice((Float) map.get("markprice"));
			product.setName((String) map.get("name"));
			product.setPhoto((String) map.get("photo"));
			product.setPrice((Float) map.get("price"));
			product.setProductid((Integer) map.get("productid"));
			product.setQuality((Integer) map.get("quality"));
			product.setTime((Date) map.get("time"));
			
			orderItem.setProduct(product);
			
			orderItemList.add(orderItem);
		}
		order.setOrderItemList(orderItemList);
		
		orderService.add(order);
		
		//清空购物车
		cart.removeAll(cart);//清空购物车
		session.removeAttribute("cart");
		session.removeAttribute("totalprice");
		
		request.setAttribute("msg", "<script>window.location.href='"+request.getContextPath()+"/home/paying.jsp';</script>");
		request.getRequestDispatcher("/msg.jsp").forward(request, response);
	}

}
