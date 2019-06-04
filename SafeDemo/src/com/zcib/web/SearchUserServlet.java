package com.zcib.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.sun.org.apache.xalan.internal.xsltc.dom.SAXImpl.NamespaceWildcardIterator;
import com.zcib.domain.News;
import com.zcib.domain.Page;
import com.zcib.domain.User;
import com.zcib.factory.BasicFactory;
import com.zcib.service.UserService;

/**
 * Servlet implementation class SearchUserServlet
 */
@WebServlet(description = "搜索用户", urlPatterns = { "/addmin/SearchUserServlet" })
public class SearchUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserService service=BasicFactory.getFactory().GetInstance(UserService.class);
		String text=request.getParameter("username");
		User user=new User();
		user.setUsername(text);
		try {
			BeanUtils.populate("user", request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String username=(String)request.getSession().getAttribute("user");
		if (username==null) {
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
				System.out.println("当前页："+thispage);
			}
			
			//判断是否为空
			int rowperpage = 3;
			//2.调用Service中分页查询客户的方法,查找出客户信息
			Page page = service.getSearchPageUser(thispage,rowperpage,user);
			//
			request.setAttribute("list", page);
			request.getRequestDispatcher("/addmin/listUser.jsp").forward(request, response);

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
