package com.xiaoxiao.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class EncodingFilter
 */
@WebFilter(description = "编码", urlPatterns = { "/EncodingFilter" })
public class EncodingFilter implements Filter {

    /**
     * Default constructor. 
     */
    public EncodingFilter() {
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
		// 处理post请求编码问题
				request.setCharacterEncoding("utf-8");
				
				HttpServletRequest req = (HttpServletRequest) request;

				/*
				 * 处理GET请求的编码问题
				 */
			
				/*
				 * 调包request
				 * 1. 写一个request的装饰类
				 * 2. 在放行时，使用我们自己的request
				 */
				if(req.getMethod().equalsIgnoreCase("GET")) {
					EncodingRequest er = new EncodingRequest(req);
					chain.doFilter(er, response);
				} else if(req.getMethod().equalsIgnoreCase("POST")) {
					chain.doFilter(request, response);
				}else{
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
