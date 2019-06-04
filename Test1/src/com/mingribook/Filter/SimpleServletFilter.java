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
//����������^�V��
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
		//servlet����ʱ����������
		filterConfig=null;
		
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		//�����ͽ���ת��
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse resp=(HttpServletResponse)response;
		//�ж�������õ�htttp����İ汾
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
		//��ʼ��������Ϣ�ķ���
		this.filterConfig=fConfig;
	}

}
