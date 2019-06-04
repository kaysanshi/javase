package com.zcib.web;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zcib.domain.User;
import com.zcib.factory.BasicFactory;
import com.zcib.service.UserService;
import com.zcib.utils.MD5Utils;

/**
 * Servlet implementation class LoginServlet
 */
/**
 * 登录
 * @author 555
 *
 */
@WebServlet(urlPatterns = { "/addmin/LoginServlet","/LoginServlet"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserService service = BasicFactory.getFactory().GetInstance(UserService.class);
		//获得项目名
		String requestPath1=request.getContextPath();
		int star=requestPath1.length();
		System.out.println(star);
		//获取请求的路径
		String requestpath=request.getRequestURI();
		System.out.println(requestpath);
		int i=requestpath.lastIndexOf("/");
		System.out.println(i);
		//获取请求的是哪一个
		String path=requestpath.substring(star,i);
		System.out.println(path);
		
		//1.
		String username = request.getParameter("username");
		String password = MD5Utils.md5(request.getParameter("password"));
		//2.
		User user = service.getUserByNameAndPsw(username,password);
		if(user == null){
			request.setAttribute("msg", "请输入用户名");
			request.setAttribute("msg_p", "请输入密码");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}if ((user.getUsername())!=null&&user.getPassword()!=null) {
			request.setAttribute("logincode", "已登录");
		}
		if (path.equalsIgnoreCase("/addmin")) {
			//4.
			request.getSession().setAttribute("user", user.getUsername());
			request.getSession().setAttribute("id", user.getUserid());
			response.sendRedirect(request.getContextPath()+"/addmin/index.jsp");
		}else{
		//4.
		request.getSession().setAttribute("user", user);
		response.sendRedirect(request.getContextPath()+"/index.jsp");
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
