package com.lyq.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/**
 * Hibenrate过滤器
 * 用于初始化Session工厂及获取Session对象
 * 通过ThreadLocal进行管理Session
 * @author Li Yong Qiang
 */
public class HibernateFilter implements Filter{
	// ThreadLocal对象
	private static ThreadLocal threadLocal = new ThreadLocal();
	// SessionFactory对象
	private static SessionFactory factory = null;
	@Override
	public void destroy() {
		if(!factory.isClosed()){
			factory.close();
		}
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		try {
			chain.doFilter(request, response);
		} finally{
			Session session = (Session)threadLocal.get();
			if(session != null){
				if(session.isOpen()){
					session.close();
				}
				threadLocal.remove();
			}
		}
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		//初始化SessionFactory
		try {
			Configuration cfg = new Configuration().configure();
			factory = cfg.buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 获取Session
	 * @return Session
	 */
	public static Session getSession() {
		Session session = (Session)threadLocal.get();
		if (session == null) {
			session = factory.openSession();
			threadLocal.set(session);
		}
		return session;
	}
}
