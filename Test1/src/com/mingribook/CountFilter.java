package com.mingribook;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class CountFilter
 */
//������eclipes�����ò����ķ�ʽ��
@WebFilter(
		urlPatterns = { "/jsp/index.jsp" }, 
		initParams = { 
				@WebInitParam(name = "count", value = "5000")
		})
public class CountFilter implements Filter {
	
	private int count;
    /**
     * Default constructor. 
     */
    public CountFilter() {
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
		count++;
		///��servletRequestת����HttpServletRequest
		HttpServletRequest req=(HttpServletRequest)request;
		//��ȡServletContext
		ServletContext context=req.getSession().getServletContext();
		context.setAttribute("count", count);
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		String param=fConfig.getInitParameter("count");
		count=Integer.valueOf(param);
	}

}
