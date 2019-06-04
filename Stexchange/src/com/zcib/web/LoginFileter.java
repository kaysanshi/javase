package com.zcib.web;

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
import javax.xml.ws.http.HTTPBinding;

/**
 * Servlet Filter implementation class LoginFileter
 */
@WebFilter(description = "判断权限", urlPatterns = { "/student/stuindex.jsp","/teacher/teacherindex.jsp","/addmin/addminindex.jsp" })
public class LoginFileter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFileter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest request2=(HttpServletRequest)request;
		HttpSession session=request2.getSession();
		System.out.println(request2.getContextPath());
		//获取请求的页面
		String requestPath=request2.getServletPath();
		System.out.println(session.getAttribute("username"));
		System.out.println("过滤器："+session.getAttribute("id"));
		System.out.println(requestPath);
		//判断session
		if (session.getAttribute("username")==null) {
			((HttpServletResponse)response).sendRedirect(request.getScheme()+"://"
					+request.getServerName()+":"+request.getServerPort()+request2.getContextPath()+"/login.jsp");
		}
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
