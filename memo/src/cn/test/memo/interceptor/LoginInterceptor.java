package cn.test.memo.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

import cn.test.memo.entity.User;

public class LoginInterceptor extends MethodFilterInterceptor {

	private static final long serialVersionUID = 1L;

	@Override
	public String doIntercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("拦截器");
		HttpServletRequest request  =ServletActionContext.getRequest();
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return "login";
		}
		return arg0.invoke();
	}

}
