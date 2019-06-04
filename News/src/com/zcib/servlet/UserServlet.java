package com.zcib.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zcib.domain.User;
import com.zcib.service.UserException;
import com.zcib.service.UserService;

public class UserServlet extends HttpServlet {
	private UserService userService = new UserService();
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action = request.getParameter("action");
		if("login".equals(action))
		{
			login(request,response);
		}else if("regist".equals(action)){
			regist(request,response);
		}else if("checkName".equals(action)){
			checkName(request,response);
		}
	}

	//用户名是否可用
	private void checkName(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String username = request.getParameter("username");
		try {
			userService.validateUserName(username );
		} catch (UserException e) {
			response.getWriter().write(e.getMessage());
		}
	}

	//注册
	public void regist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 1.获取表单数据
		 * 2.验证表单数据的正确性
		 * 3.调用service的regist方法，进行注册
		 * 4.注册成功，返回User对象
		 */
		//获取表单数据
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String birthday = request.getParameter("birthday");
		String email = request.getParameter("email");
		
		//验证表单数据的正确性
		
		//调用service的regist方法，进行注册
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		Date d;
		try {
			d = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
			user.setBirthday(d);
		} catch (ParseException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
		user.setEmail(email);
		user.setIsenable(1);
		try {
			userService.regist(user);
			request.setAttribute("msg", "用户注册成功！");
			request.getRequestDispatcher("msg.jsp").forward(request, response);
		} catch (UserException e) {
			request.setAttribute("error",e.getMessage());
			request.getRequestDispatcher("regist.jsp").forward(request, response);
		}
	}
	
	//登录
	public void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 1. 取出表单中的用户名和密码
		 * 2. 检查表单数据的正确性（非空，格式验证等）
		 *    检查验证码是否正确
		 * 3. 调用service层，来验证用户名和密码是否正确
		 *   4.正确，则保存用户信息到session中，跳转到主页面index.jsp
		 *   5.不正确，则保存错误信息到request中，重定向到错误显示页面。
		 */
		
		//1. 取出表单中的用户名和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String verifyCode = request.getParameter("verifyCode");
		
		// 2. 验证表单数据的正确性（非空，格式验证等），不正确返回到login.jsp页面中
	
		if(username == null || username.trim().isEmpty()){
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		if(password == null || password.trim().isEmpty()){
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		if(verifyCode == null || verifyCode.trim().isEmpty()){
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}else if(!verifyCode.equalsIgnoreCase(request.getSession().getAttribute("verifyCode").toString())){
			//验证码输入不正确，则返回错误信息，重新输入
			request.setAttribute("verifyCodeError", "验证码不正确，请重新输入");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		
		// 3. 调用service层，来验证用户名和密码是否正确
		try{
			User user = userService.validate(username, password);
			//4.正确，则保存用户信息到session中，跳转到主页面index.jsp
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}catch(UserException e){
			// 5.不正确，则保存错误信息到request中，重定向到错误显示页面。
				request.setAttribute("msg", e.getMessage());
				request.getRequestDispatcher("/msg.jsp").forward(request,response);
		}
	}
}
