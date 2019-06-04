package com.mingribook;

import java.awt.Container;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class UserInforTrace implements HttpSessionBindingListener {
	private String user;
	private UserInforList list=UserInforList.getInstance();
	 public UserInforTrace() {
		// TODO Auto-generated constructor stub
		 user="";
	}
	 public void setUser(String user) {
		this.user = user;
	}
	 public String getUser() {
		return user;
	}
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		System.out.println("上线："+this.user);
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		System.out.println("下线："+this.user);
		if(user!=null){
			list.remove(user);
		}
	}

}
