package com.itheima.filter;

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

import com.itheima.domain.User;

/**
 * Servlet Filter implementation class PrivilegeFilter
 */
@WebFilter(description = "权限顾虑器", urlPatterns = { "/*" })
public class PrivilegeFilter implements Filter {

    /**
     * Default constructor. 
     */
    public PrivilegeFilter() {
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
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		//获取访问的资源uri
		String uri = req.getRequestURI().substring(req.getContextPath().length());
		
		//检查访问的资源是否是以/admin或/user开头,如果是则表明需要权限
		if(uri.startsWith("/admin") || uri.startsWith("/user")){
			//如果用户没有登录,则提示用户先进行登录操作
			if(req.getSession(false)==null || req.getSession().getAttribute("user")==null){
				resp.getWriter().write("该资源需要权限,请先进行登录!!");
				resp.setHeader("Refresh", "3;url="+req.getContextPath()+"/login.jsp");
				return;
			}else{//如果用户已经登录
				User user = (User) req.getSession().getAttribute("user");
				if(uri.startsWith("/admin") && "admin".equals(user.getRole())){
					//如果当前资源需要admin权限而当前用户是admin则放行
					chain.doFilter(request, response);
				}else if(uri.startsWith("/user") && "user".equals(user.getRole())){
					//如果当前资源需要user权限而当前用户是user则放行
					chain.doFilter(request, response);
				}else{
					//如果上面两个都不符合提示用户权限不足
					throw new RuntimeException("您不具有对应的权限!!!!");
				}
			}
		}else{//如果不是则不需要权限,直接放行
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
