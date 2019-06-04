package com.itheima.domain;

import java.io.Serializable;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class User implements Serializable ,HttpSessionBindingListener {
	private int id;
	private String name;
	private String password;
	private String role;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public void valueBound(HttpSessionBindingEvent event) {
		//当用户登录时,代表用户的bean存入了session中,此时自动向用户列表中添加自己
		HttpSession session  = event.getSession();
		ServletContext context = session.getServletContext();
		
		Map<User,HttpSession> map = (Map<User, HttpSession>) context.getAttribute("usermap");
		map.put(this, session);
	}
	public void valueUnbound(HttpSessionBindingEvent event) {
		//当用户下线时,无论是手动注销还是超时下线,代表用户的bean都移除出了session,此时自动从用户列表中移除自己
		HttpSession session  = event.getSession();
		ServletContext context = session.getServletContext();
		
		Map<User,HttpSession> map = (Map<User, HttpSession>) context.getAttribute("usermap");
		map.remove(this);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final User other = (User) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
