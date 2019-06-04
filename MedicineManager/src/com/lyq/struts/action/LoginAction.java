package com.lyq.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.lyq.dao.UserDao;
import com.lyq.persistence.User;
import com.lyq.struts.form.UserForm;

/**
 * 用户登录Action类
 * 
 * @author Li Yong Qiang
 */
public class LoginAction extends Action {
	// 处理用户登录请求
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UserForm uf = (UserForm) form;		// 获取ActionForm
		String userName = uf.getUsername();	// 用户名
		String password = uf.getPassword();	// 密码
		User user = null;
		// 查询用户
		if (userName != null && password != null) {
			UserDao userDao = new UserDao();
			user = userDao.login(userName, password);
		}
		// 查询到用户则登录成功，否则登录失败返回到登录页面
		if (user != null) {
			request.getSession().setAttribute("user", user);
			return mapping.findForward("manage");
		} else {
			request.setAttribute("error", "error");
			return mapping.findForward("loginFail");
		}
	}
}
