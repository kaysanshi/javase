package com.xiaoxiao.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xiaoxiao.domain.User;
import com.xiaoxiao.exception.UserException;
import com.xiaoxiao.service.UserService;
import com.xiaoxiao.service.VerifyService;
import com.xiaoxiao.utils.EmailUtils;
import com.xiaoxiao.utils.MD5;

public class UserServlet extends HttpServlet {
	private UserService userService = new UserService();
	private VerifyService verifyService = new VerifyService();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//处理请求中中文乱码问题
		String action = request.getParameter("action");
		if("regist".equals(action)){
			regist(request,response);
		}else if("login".equals(action)){
			login(request,response);
		}else if("activate".equals(action)){
			activate(request,response);
		}else if("validateusername".equals(action)){
			validateusername(request,response);
		}
		
	}


	private void validateusername(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		/*
		 * 1.获取用户名
		 * 2.调用Service中validateName，查看用户名是否被占用
		 * 3.返回json
		 */
		String username = request.getParameter("username");
		boolean result = userService.validateUsername(username);
		response.getWriter().print(result);
	}


	//验证邮件回执
	private void activate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1.获取验证码
		 * 2.进行激活
		 * 3.激活成功，转向登录页面
		 * 4.激活失败，转向msg.jsp页面
		 */
		String code = request.getParameter("code");
     	try {
			verifyService .activate(code);//激活成功
		} catch (UserException e) {//激活失败
				request.setAttribute("msg", e.getMessage());
				request.getRequestDispatcher("/msg.jsp").forward(request, response);
				return;
		}
     	String msg = "<script>alert('激活成功！');window.location.href='"+request.getContextPath()+"/login.jsp';</script>";
     	request.setAttribute("msg", msg);
     	request.getRequestDispatcher("/msg.jsp").forward(request, response);
		
	}


	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		/*
		 * 1.获取参数,验证正确性
		 * 2.调用Service中的login方法进行登录
		 * 3.登录成功，转到index.jsp页面
		 * 4.登录失败，转到login.jsp页面
		 */
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//对密码进行md5加密
		password = MD5.md5(password);
		try {
			User user = userService.login(username, password);
			userService.updateLastLoginTime(user.getVipid());
			//登录成功，保存用户登录成功的信息
			request.getSession().setAttribute("user", user);
			response.sendRedirect(request.getContextPath()+"/productServlet?action=findIndex");
		} catch (UserException e) {
			request.setAttribute("error", e.getMessage());
			request.getRequestDispatcher("/login.jsp").forward(request,response);
		}
		
	}


	private void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1.获取参数
		 * 2.验证参数的正确性
		 * 3.封装到User对象中
		 * 4.调用Service层的regist方法进行注册
		 * 5.跳转到login.jsp页面（防止重复刷新）
		 */
		//1.获取参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String email = request.getParameter("email");
		//2.验证参数的正确性，回显
		if(username==null||username.trim().isEmpty()){
			//用户名为空
			request.setAttribute("error", "用户名不能为空!");
			request.setAttribute("email", email);
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		if(password==null||password.trim().isEmpty()){
			//密码为空
			request.setAttribute("username", username);
			request.setAttribute("email", email);
			request.setAttribute("error", "密码不能为空!");
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		if(!password.equals(password2)){
			request.setAttribute("username", username);
			request.setAttribute("email", email);
			//两次密码不一致
			request.setAttribute("error", "两次密码不一致!");
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		//验证邮箱的正则表达式
		String regex="^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";  
		Pattern p=Pattern.compile(regex);  
		Matcher m=p.matcher(email);
		if(!m.find()){//返回true表示符合规则，false表示不符合规则
			request.setAttribute("username", username);
			request.setAttribute("error", "邮箱格式不正确！");
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		//3.封装到User对象中
		User user = new User();
		user.setUsername(username);
		password = MD5.md5(password);
		user.setPassword(password);
		
		user.setEmail(email);
		user.setLastlogintime(new Date());
		
		user.setStatus(false);
		
		//4.调用Service层的regist方法进行注册
		
		userService.regist(user);
		
		//5.注册后发邮件进行验证
		//5.1生成验证码
		String code = UUID.randomUUID().toString().replace("-", "");
		//5.2将验证码写入到表中
		verifyService.addverify(user.getVipid(),code);
		EmailUtils emailUtils = new EmailUtils();
		emailUtils.sendVerifyMail(email,code);
		
		//5.跳转到login.jsp页面（防止重复刷新）
		request.setAttribute("msg", "<script>alert('注册成功!');window.location='"
				+ request.getContextPath()
				+ "/login.jsp'</script>");
		request.getRequestDispatcher("/msg.jsp").forward(request,response);
		
	}

}
