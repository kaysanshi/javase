package com.itheima.filter;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.itheima.domain.User;
import com.itheima.util.DaoUtils;

/**
 * Servlet Filter implementation class AutologinFilter
 */
@WebFilter(
		description = "自动登录过滤器", 
		urlPatterns = { "/*" }, 
		initParams = { 
				@WebInitParam(name = "encode", value = "utf-8", description = "编码过滤")
		})
public class AutologinFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AutologinFilter() {
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
		//1.只有未登录的才能自动登录
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse rsp=(HttpServletResponse)response;
		if (req.getSession(false)==null|| req.getSession().getAttribute("user")==null) {
			//2.只有带自动登录的的cookie才能自动登录
			Cookie[]cs=req.getCookies();
			Cookie findC=null;
			if (cs!=null) {
				for(Cookie c:cs) {
					if ("autologin".equals(c.getName())) {
						findC=c;
						break;
					}
				}
			}
			if (findC!=null) {
				//3.自动登录cookie中保存的用户名密码正确才能登录
				String name=findC.getValue().split(":")[0];
				String password=findC.getValue().split(":")[1];
				User user=null;
				String sql="select *from user where name=?and password=?";
				//数据库的操作
			
				try {
					QueryRunner runner=new QueryRunner(DaoUtils.getSource());
					user=runner.query(sql,new BeanHandler<User>(User.class),name,password);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (user!=null) {
					req.getSession().setAttribute("user", user);
				}
			}
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
