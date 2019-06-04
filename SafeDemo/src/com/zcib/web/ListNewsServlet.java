package com.zcib.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mchange.v2.async.StrandedTaskReporting;
import com.sun.swing.internal.plaf.basic.resources.basic;
import com.zcib.domain.News;
import com.zcib.domain.Page;
import com.zcib.factory.BasicFactory;
import com.zcib.service.NewsService;

/**
 * Servlet implementation class ListNewsServlet
 */
@WebServlet(description = "新闻列表", urlPatterns = { "/ListNewsServlet" ,"/addmin/ListNewsServlet" })
public class ListNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListNewsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		NewsService service=BasicFactory.getFactory().GetInstance(NewsService.class);
		String user=(String)request.getSession().getAttribute("user");
		if (user==null) {
			String url=request.getServletPath();
			String url1=request.getServerName();
			String url2=request.getScheme();
			System.out.println(url+":"+url1+";"+url2);
			response.sendRedirect(request.getContextPath()+"/addmin/login.jsp");
		}else{
			//1.获取当前要显示的页和每页记录数
			System.out.println(request.getParameter("thispage"));
			String p=request.getParameter("thispage");
			int thispage = 1;
			if (p==null) {
				System.out.println("未能接受到参数");
				thispage=1;
			}else{
				System.out.println(thispage);
				thispage = Integer.parseInt(p);
			}
			
			//判断是否为空
			int rowperpage = 5;
			//2.调用Service中分页查询客户的方法,查找出客户信息
			Page page = service.getPageNews(thispage,rowperpage);	
			
			//1.
			
			//List<Video> list=service.getPageVideo(thispage,rowperpage);
			//分页显示出来		
			//2.
			request.setAttribute("page", page);
			request.getRequestDispatcher("/addmin/listnews.jsp").forward(request, response);
		
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
