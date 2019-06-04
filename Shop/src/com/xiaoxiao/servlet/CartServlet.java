package com.xiaoxiao.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xiaoxiao.domain.User;
import com.xiaoxiao.service.AddressService;
import com.xiaoxiao.service.ProductService;


public class CartServlet extends HttpServlet {
	private ProductService productService = new ProductService();
	private AddressService addressService = new AddressService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if("addCart".equals(action)){
			addCart(request,response);
		}else if("delete".equals(action)){
			delete(request,response);
		}else if("deletemore".equals(action)){
			deleteMore(request,response);
		}else if("updatecount".equals(action)){
			updateCount(request,response);
		}else if("updatecount".equals(action)){
			updateCount(request,response);
		}
	}





	private void updateCount(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		response.setContentType("application/json; charset=utf-8");//防止中文乱码
		String id = request.getParameter("id");
		int  buycount = Integer.parseInt(request.getParameter("buycount"));
		//1.获取购物车
		HttpSession session = request.getSession();
		List<Map<String,Object>> cart = (List<Map<String, Object>>) session.getAttribute("cart");
		float total = 0;
		float totalprice = 0;
		//2.循环查找购物车中该商品，找到后，更新商品购买数量和该商品总价，并计算购物车所有商品总价
		for(int i=0;i<cart.size();i++){
			Map<String,Object> item = cart.get(i);//取出第i个商品
			if(item.get("productid").toString().equals(id)){
				//找到该商品
				item.put("buycount", buycount);
				total = Float.parseFloat(item.get("price").toString())*buycount;
				item.put("total",total);
				totalprice += total;
			}else{
				float t = Float.parseFloat(item.get("price").toString())*Integer.parseInt(item.get("buycount").toString());
				totalprice += t;
			}
		}
		session.setAttribute("totalprice", totalprice);
		//4.返回该商品总价和购物车总价格
		String jsonstr = "{\"total\":"+total+",\"totalprice\":"+totalprice+"}";
		response.getWriter().println(jsonstr);
		
	}


	private void deleteMore(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1.获取要删除的id集合，判断是否为空
		 * 2.得到购物车，循环删除购物车中的商品
		 * 3.转发到cart.jsp页面
		 */
		String ids[] = request.getParameterValues("sel");
		if(ids!=null&&ids.length>0){
			HttpSession session = request.getSession();
			List<Map<String,Object>> cart = (List<Map<String, Object>>) session.getAttribute("cart");
			if(cart==null){
				request.getRequestDispatcher("/cart.jsp").forward(request, response);
				return;
			}
			float totalprice = ((Float)(session.getAttribute("totalprice"))).floatValue();
			
			//从购物车中删除这些商品
			for(int i=0;i<cart.size();i++){
				//循环取出购物车中每一个商品
				Map<String,Object> item = cart.get(i);
				
				for(int j=0;j<ids.length;j++){
					//比较该商品的id和数组中的id是否相同
					if(item.get("productid").toString().equals(ids[j])){
						//查到第i个商品
						totalprice -= ((Float)item.get("total")).floatValue();
						cart.remove(i);
						break;
					}
				}
				session.setAttribute("totalprice", totalprice);
			}
			//防止刷新重复提交
			request.setAttribute("msg", "<script>alert('删除成功！');window.location.href='"+request.getContextPath()+"/cart.jsp';</script>");
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/cart.jsp").forward(request, response);
		}
		
		
	}


	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1.获取id
		 * 2.获取购物车
		 * 3.从购物车中查找该id的商品，从购物车中移除
		 * 4.转发到msg页面，然后返回购物车也米娜
		 */
		//1.获取id
		int productid =Integer.parseInt(request.getParameter("id"));
		//2.获取购物车
		HttpSession session = request.getSession();
		List<Map<String,Object>> cart = (List<Map<String, Object>>) session.getAttribute("cart");
		if(cart==null){
			request.getRequestDispatcher("/cart.jsp").forward(request, response);
			return;
		}
		//3.从购物车中查找该id的商品，从购物车中移除
		boolean incart = false;
		
		for(int i=0;i<cart.size();i++){
			//查找该商品
			Map<String,Object> map = cart.get(i);
			if(map.get("productid").equals(productid)){
				float totalprice = ((Float)(session.getAttribute("totalprice"))).floatValue();
				totalprice -= ((Float)map.get("total")).floatValue();
				cart.remove(i);//把第i个商品从购物车中删除
				session.setAttribute("totalprice", totalprice);
				incart = true;
			}
		}
		String msg;
		if(!incart){
			//购物车中没有要删除的商品
			msg = "删除失败，没有要删除的商品";
		}else{
			msg = "删除成功！";
		}
		//重定向到msg.jsp，显示删除结果，然后跳转到cart.jsp页面
		request.setAttribute("msg", "<script>alert('"+msg+"');window.location.href='"
		+request.getContextPath()+"/cart.jsp';</script>");
		request.getRequestDispatcher("/msg.jsp").forward(request, response);
		
	}


	private void addCart(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1.获取要加入购物车的商品id，通过id获取该商品
		 * 2.获取购物车（使用一个Map表示购物车，
		 * 			其中key是productid，value是另一个Map，包括该id的商品信息
		 * 			还包括count，totalsize
		 * 3.如果购物车不存在，创建购物车
		 * 4.从购物车中获取该商品
		 * 5.如果商品不存在，则存入购物车，商品数量为1
		 * 6.如果商品存在，则商品数量加1
		 */
		//1.获取要加入购物车的商品id，获取该商品
		String id = request.getParameter("productid");
		String bcount= request.getParameter("buycount");//购买数量
		int buycount = Integer.parseInt(bcount);
		int productid = Integer.parseInt(id);
		Map<String,Object> item = productService.findById(productid);
		//添加购买数量
		
		//获取购物车
		HttpSession session = request.getSession();
		List<Map<String,Object>> cart = (List<Map<String, Object>>) session.getAttribute("cart");
		float totalprice = 0;
		if(cart==null){
			cart = new ArrayList<Map<String,Object>>();//没有购物车，创建它
			//将购买数量加入到map中
			
			item.put("buycount", buycount );
			//将购买总价加入到map中
			float total = Float.parseFloat(item.get("price").toString())*buycount;
			item.put("total",total );
			//加入到购物车中
			cart.add(item);
			totalprice =  total;
		}else{//有购物车，通过循环查看该购物车有无该商品
			boolean incart = false;
			for(int i=0;i<cart.size();i++){
				Map<String,Object> map = cart.get(i);//取出第i个商品
				if(map.get("productid").equals(productid)){//有该商品，在原有的基础上加buycount
					buycount += Integer.parseInt(map.get("buycount").toString());
					map.put("buycount", buycount);
					float total = Float.parseFloat(item.get("price").toString())*buycount; 
					map.put("total", total);
					incart = true;
					totalprice += total;
				}else{
					float total = (Float)map.get("total"); 
					totalprice += total;
				}
			}
			if(!incart){//购物车中没有该商品
				item.put("buycount", buycount );
				//将购买总价加入到map中
				float total = Float.parseFloat(item.get("price").toString())*buycount;
				item.put("total", total);
				totalprice += total;
				//加入到购物车中
				cart.add(item);
			}
		}
		//将购物车放回session
		session.setAttribute("cart", cart);
		session.setAttribute("totalprice", totalprice);
		//防止刷新重复提交
		request.setAttribute("msg", "<script>window.location.href='"+request.getContextPath()+"/cart.jsp';</script>");
		request.getRequestDispatcher("/msg.jsp").forward(request, response);
	}

}
