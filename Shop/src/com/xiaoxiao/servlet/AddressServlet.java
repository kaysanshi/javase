package com.xiaoxiao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xiaoxiao.domain.Address;
import com.xiaoxiao.domain.User;
import com.xiaoxiao.service.AddressService;

public class AddressServlet extends HttpServlet {
	private AddressService addressService = new AddressService();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String action = request.getParameter("action");
		if("add".equals(action)){
			add(request,response);
		}else if("find".equals(action)){
			find(request,response);
		}else if("delete".equals(action)){
			delete(request,response);
		}else if("paybefore".equals(action)){
			payBefore(request,response);
		}
	}
	
	private void payBefore(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		/*
		 * 1.如果用户没有登录，则跳转到登录页面
		 * 2.从Session中取出用户id，从地址表中查找地址信息
		 * 3.根据id读出地址列表，存入request
		 * 4.重定向到pay.jsp页面
		 */
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		int vipid = user.getVipid();
		request.setAttribute("addresslist", addressService.findById(vipid));
		request.getRequestDispatcher("/home/pay.jsp").forward(request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1.获取id
		 * 2.调用Service层deleteById进行删除
		 * 3.防止刷新重复提交，先转向msg页面，然后再转回本Servlet中调用find方法
		 */
		String id = request.getParameter("id");
		addressService.deleteById(Integer.parseInt(id));
		request.setAttribute("msg", "<script>alert('删除成功！');window.location.href='"+request.getContextPath()+"/addressServlet?action=find'</script>");
		request.getRequestDispatcher("/home/msg.jsp").forward(request, response);
	}

	private void find(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		/*
		 * 1.获取session中的用户
		 * 2.如果为空，返回登录页面
		 * 3.如果不为空，则取出vipid
		 * 4.根据vipid调用Service层的findById方法，获取地址列表
		 * 5.存入request中
		 * 6.重定向到pay.jsp页面
		 */
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		int vipid = user.getVipid();
		request.setAttribute("addresslist", addressService.findById(vipid));
		request.getRequestDispatcher("/home/pay.jsp").forward(request, response);
		
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		/*
		 * 1.获取表单中的数据
		 * 2.封装成Address对象
		 * 3.调用Service层将Address插入到数据库中
		 * 4.返回pay.jsp页面，防止重复刷新
		 */
		//地址
		String addresspart = request.getParameter("addresspart");
		String province = request.getParameter("pro");
		String city = request.getParameter("ci");
		String area = request.getParameter("ar");
		StringBuilder addressname = new StringBuilder(province);
		if((!"市辖区".equals(city))&&(!"县".equals(city))){
			addressname.append(city);
		}
		if(!("市辖区".equals(area))){
			addressname.append(area);
		}
		addressname.append(addresspart);
		
		String postcode = request.getParameter("postcode");
		String receiver = request.getParameter("receiver");
		String phone = request.getParameter("phone");
		int vipid = user.getVipid();
		//封装到Address对象中
		Address address = new Address();
		address.setAddressname(addressname.toString());
		address.setPhone(phone);
		address.setPostcode(postcode);
		address.setReceiver(receiver);
		address.setVipid(vipid);
		
		addressService.add(address);
		
		request.setAttribute("msg", "<script>window.location.href='"+request.getContextPath()+"/addressServlet?action=find'</script>");
		request.getRequestDispatcher("/home/msg.jsp").forward(request, response);
		
	}

}
