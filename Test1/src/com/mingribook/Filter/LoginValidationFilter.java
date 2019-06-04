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
	//����������
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
		//�����ͽ���ת��
			HttpServletRequest req=(HttpServletRequest)request;
			HttpServletResponse resp=(HttpServletResponse)response;
		//���session;
			HttpSession session=req.getSession();
			String reqURL=req.getServletPath();
		//��¼��������LOginServlet����Ҫ���ˣ�
		//��¼ҳ��login.html����Ҫ���ˣ�
		//������ʾҳ��loginError.html;
			String loginMess=(String)session.getAttribute("login");
		//�����Ѿ���¼���û���session�д���ĵ�¼��ϢΪ����login��,"true")             
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
