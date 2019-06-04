package com.itheima.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.Customer;
import com.itheima.domain.Page;
import com.itheima.factory.BasicFactory;
import com.itheima.service.CustomerService;

/**
 * Servlet implementation class PageCustomerServlet
 */
@WebServlet("/PageCustomerServlet")
public class PageCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CustomerService service = BasicFactory.getFactory().GetInstance(CustomerService.class);
		//1.获取当前要显示的页和每页记录数
		int thispage = Integer.parseInt(request.getParameter("thispage"));
		int rowperpage = 5;
		//2.调用Service中分页查询客户的方法,查找出客户信息
		Page page = service.pageCust(thispage,rowperpage);
		//3.存入request域中,带到pageList.jsp页面中进行显示
		request.setAttribute("page", page);
		request.getRequestDispatcher("/pageList.jsp").forward(request, response);
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
