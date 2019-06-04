package com.itheima.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class Demo1Filter
 */
@WebFilter(asyncSupported = true, description = "filterdemo", urlPatterns = { "/demo1Filr" })
public class Demo1Filter implements Filter {

    /**
     * Default constructor. 
     */
    public Demo1Filter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	System.out.println("filter销毁了");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("demo1前");
		// pass the request along the filter chain
		//意思是执行下一个节点可以为过滤器可以为资源
		chain.doFilter(request, response);
		System.out.println("demo1后");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	System.out.println("filter创建了");
	}

}
