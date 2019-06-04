package com.itheima.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.Customer;
import com.itheima.factory.BasicFactory;
import com.itheima.service.CustomerService;

/**
 * Servlet implementation class CustomerInfoServlet
 */
@WebServlet("/CustomerInfoServlet")
public class CustomerInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CustomerService service=BasicFactory.getFactory().GetInstance(CustomerService.class);
		//1.获取要查询客户的id
		String id=request.getParameter("id");
		System.out.println("id的值："+id);
		//2.调用Service中的方法
		Customer customer=service.findCustomerByid(id);
		if(customer==null){
			throw new RuntimeException("找不到该客户");
		}
		//3.把信息存入到request域中请求转发到updatecustomer.jsp中
		request.setAttribute("customer", customer);
		
		request.getRequestDispatcher("/updateCustomer.jsp").forward(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
