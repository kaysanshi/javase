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

/**
 * Servlet Filter implementation class SimpleServletFilter
 */
@WebFilter("/*")
//不緩存頁面過濾器
public class SimpleServletFilter implements Filter {
	
	protected FilterConfig filterConfig;
    /**
     * Default constructor. 
     */
    public SimpleServletFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		//servlet销毁时过滤器销毁
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
		//判断浏览器用的htttp请求的版本
		if(req.getProtocol().compareTo("HTTP/1.0")==0){
			resp.setHeader("Pragma", "no-cache");
			
		}else if(req.getProtocol().compareTo("HTTP/1.1")==0){
			resp.setHeader("Cache-Control", "no-cache");
		}
		resp.setDateHeader("Exprise", -1);
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}	

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		//初始化过滤信息的方法
		this.filterConfig=fConfig;
	}

}
