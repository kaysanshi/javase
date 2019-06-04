package com.itheima.web;

import java.io.IOException;
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
 * Servlet implementation class AddCustomerServlet
 */
@WebServlet("/AddCustomerServlet")
public class AddCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//解决乱码：
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		CustomerService service=BasicFactory.getFactory().GetInstance(CustomerService.class);
		try{
		//1.封装数据校验数据
		
		Customer  customer=new Customer();
		BeanUtils.populate(customer, request.getParameterMap());
		//单独处理爱好：
		String[] preference=request.getParameterValues("preference");
		StringBuffer buffer=new StringBuffer();
		for(String pString:preference){
			buffer.append(pString+",");
		}
		String pString=buffer.substring(0, buffer.length()-1);
		customer.setPreference(pString);
		
		//2.调用service 中的添加客户的方法
		service.addCustomer(customer);
		//3.从定向回到主页；
		response.sendRedirect(request.getContextPath()+"/index.jsp");

		}catch(Exception e){
			
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
