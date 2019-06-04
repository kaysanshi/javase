package com.itheima.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.factory.BasicFactory;
import com.itheima.service.CustomerService;
//批量删除客户信息
/**
 * Servlet implementation class BatchDeleteCustomerServlet
 */
@WebServlet("/BatchDeleteCustomerServlet")
public class BatchDeleteCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BatchDeleteCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CustomerService service=BasicFactory.getFactory().GetInstance(CustomerService.class);	
	
	//1.获取所有的删除客户的id;
		String [] ids=request.getParameterValues("delId");
	//调用service中批量删除的客户
		service.batchdel(ids);
	//重定向到列表
	request.getRequestDispatcher("/ListCustomerServlet").forward(request, response);

	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
