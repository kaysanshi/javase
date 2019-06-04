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
@WebFilter(description = "Ȩ�޹�����", urlPatterns = { "/*" })
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
		//��ȡ���ʵ���Դuri
		String uri = req.getRequestURI().substring(req.getContextPath().length());
		
		//�����ʵ���Դ�Ƿ�����/admin��/user��ͷ,������������ҪȨ��
		if(uri.startsWith("/admin") || uri.startsWith("/user")){
			//����û�û�е�¼,����ʾ�û��Ƚ��е�¼����
			if(req.getSession(false)==null || req.getSession().getAttribute("user")==null){
				resp.getWriter().write("����Դ��ҪȨ��,���Ƚ��е�¼!!");
				resp.setHeader("Refresh", "3;url="+req.getContextPath()+"/login.jsp");
				return;
			}else{//����û��Ѿ���¼
				User user = (User) req.getSession().getAttribute("user");
				if(uri.startsWith("/admin") && "admin".equals(user.getRole())){
					//�����ǰ��Դ��ҪadminȨ�޶���ǰ�û���admin�����
					chain.doFilter(request, response);
				}else if(uri.startsWith("/user") && "user".equals(user.getRole())){
					//�����ǰ��Դ��ҪuserȨ�޶���ǰ�û���user�����
					chain.doFilter(request, response);
				}else{
					//���������������������ʾ�û�Ȩ�޲���
					throw new RuntimeException("�������ж�Ӧ��Ȩ��!!!!");
				}
			}
		}else{//�����������ҪȨ��,ֱ�ӷ���
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
