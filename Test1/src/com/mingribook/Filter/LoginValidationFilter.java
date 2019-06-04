package com.mingribook.Filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//
/**
 * Servlet Filter implementation class LoginValidationFilter
 */
@WebFilter({ "/LoginValidationFilter", "/admin.html", "/common.html" })
public class LoginValidationFilter implements Filter {
	//创建过滤器
	protected FilterConfig filterConfig;
    /**
     * Default constructor. 
     */
    public LoginValidationFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		filterConfig=null;
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		//对类型进行转换
			HttpServletRequest req=(HttpServletRequest)request;
			HttpServletResponse resp=(HttpServletResponse)response;
		//获得session;
			HttpSession session=req.getSession();
			String reqURL=req.getServletPath();
		//登录处理程序的LOginServlet不需要过滤；
		//登录页面login.html不需要过滤；
		//出错提示页面loginError.html;
			String loginMess=(String)session.getAttribute("login");
		//对于已经登录的用户，session中储存的登录信息为（“login”,"true")             
			if (loginMess==null || !loginMess.equals("true")) {
				resp.sendRedirect(req.getContextPath()+"/loginError.html");
				return;
			}
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.filterConfig=fConfig;
	}

}
