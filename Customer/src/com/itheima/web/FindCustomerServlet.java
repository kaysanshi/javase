package com.itheima.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.itheima.domain.Customer;
import com.itheima.factory.BasicFactory;
import com.itheima.service.CustomerService;

/**
 * Servlet implementation class FindCustomerServlet
 */
@WebServlet("/FindCustomerServlet")
public class FindCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			request.setCharacterEncoding("utf-8");
			CustomerService service = BasicFactory.getFactory().GetInstance(CustomerService.class);
			//1.获取查询条件封装到bean中
			Customer cust = new Customer();
			BeanUtils.populate(cust, request.getParameterMap());
			//2.调用Service中条件查询客户的方法,查出符合条件的客户
			List<Customer> list = service.findCustomerByCond(cust);
			//3.将查到的客户存入request域中带到listCust.jsp页面进行展示
			request.setAttribute("list", list);
			request.getRequestDispatcher("/listCustomer.jsp").forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
