package cn.test.memo.action;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.test.memo.entity.User;
import cn.test.memo.service.UserService;
import cn.test.memo.util.ResultUtil;
import cn.test.memo.util.StringUtil;

/**
 * 用户相关的所有操作
 * 1.登录 (每次登录的时候 数据库刷新下最后登录时间和最后登录ip)
 * 2.账号验证  (注册时验证账号是否已经存在)
 * 3.注册
 * 4.修改密码
 * @author Qfeng
 *
 */
public class UserAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private UserService userService;
	
	public UserAction() {
		this.userService = new UserService();
	}
	
	/**
	 * 登录验证
	 * @return
	 */
	public String login() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
			request.setAttribute("msg", "账号或密码不能为空");
			return "login";
		}
		User user = userService.login(username, password);
		if (user == null) {
			request.setAttribute("msg", "账号或密码错误");
			return "login";
		} else {
			request.getSession().setAttribute("user", user);
			String ip = "0.0.0.0";
			
			//获取用户ip
			ip = request.getHeader("x-forwarded-for");  
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	            ip = request.getHeader("Proxy-Client-IP");  
	        }  
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	            ip = request.getHeader("WL-Proxy-Client-IP");  
	        }  
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	            ip = request.getHeader("HTTP_CLIENT_IP");  
	        }  
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	            ip = request.getHeader("HTTP_X_FORWARDED_FOR");  
	        }  
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	            ip = request.getRemoteAddr();  
	        }  
			System.out.println("ip:" + ip);
			userService.updatalogin(user, ip);
			return "home";
		}
	}
	
	/**
	 * 账号验证
	 * @return
	 */
	public String check() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Map<String, Object> map = new HashMap<>();
		String username = request.getParameter("username");
		if (username == null || username.isEmpty()) {
			map.put("status", 0);
			map.put("msg", "账号不能为空");
			ResultUtil.toJson(ServletActionContext.getResponse(), map);
			return NONE;
		}
		if (userService.checkUsername(username)) {
			map.put("status", 1);
			map.put("msg", "账号可用");
		} else {
			map.put("status", 0);
			map.put("msg", "账号已存在");
		}
		ResultUtil.toJson(ServletActionContext.getResponse(), map);
		return NONE;
	}
	
	/**
	 * 用户注册
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public String register() throws UnsupportedEncodingException {
		HttpServletRequest request = ServletActionContext.getRequest();
		Map<String, Object> map = new HashMap<>();
		String nick = request.getParameter("nick");
		System.out.println(nick);
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if (nick == null ||nick.isEmpty() || username == null || username.isEmpty() || password == null || password.isEmpty()) {
			map.put("status", 0);
			map.put("msg", "内容不全");
			ResultUtil.toJson(ServletActionContext.getResponse(), map);
			return NONE;
		}

		String ip = "0.0.0.0";
		
		//获取用户ip
		ip = request.getHeader("x-forwarded-for");  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("Proxy-Client-IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("WL-Proxy-Client-IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("HTTP_CLIENT_IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getRemoteAddr();  
        }  
		System.out.println("ip:" + ip);
		User user = new User();
		user.setLast_login_ip(ip);
		user.setNick(nick);
		user.setUsername(username);
		user.setPassword(password);
		if (userService.add(user)) {
			map.put("status", 1);
			map.put("msg", "注册成功");
		} else {
			map.put("status", 0);
			map.put("msg", "注册失败");
		}
		ResultUtil.toJson(ServletActionContext.getResponse(), map);
		return NONE;
	}
	
	/**
	 * 修改密码
	 * @return
	 */
	public String changepwd() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Map<String, Object> map = new HashMap<>();
		String oldpwd = request.getParameter("oldpwd");
		String newpwd = request.getParameter("newpwd");
		if (oldpwd == null || oldpwd.isEmpty() || newpwd == null || newpwd.isEmpty()) {
			map.put("status", 0);
			map.put("msg", "密码不能为空");
			ResultUtil.toJson(ServletActionContext.getResponse(), map);
			return NONE;
		}
		User user = (User) request.getSession().getAttribute("user");
		if (!user.getPassword().equals(StringUtil.stringToMD5(oldpwd))) {
			map.put("status", 0);
			map.put("msg", "原密码不正确");
			ResultUtil.toJson(ServletActionContext.getResponse(), map);
			return NONE;
		}
		if (userService.updatepwd(user, newpwd)) {
			user.setPassword(StringUtil.stringToMD5(newpwd));
			map.put("status", 1);
			map.put("msg", "修改成功");
		} else {
			map.put("status", 0);
			map.put("msg", "修改失败");
		}
		ResultUtil.toJson(ServletActionContext.getResponse(), map);
		return NONE;
	}
	
	/**
	 * 退出
	 * @return
	 */
	public String exit() {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().removeAttribute("user");
		return "login";
	}
}





























