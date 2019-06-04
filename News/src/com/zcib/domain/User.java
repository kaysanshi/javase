package com.zcib.domain;

import java.util.Date;

public class User {
	private int id;//用户id
	private String username;//用户名
	private String password;//密码
	private Date birthday;//生日
	private String email;//邮箱
	private int isenable;//是否可用
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getIsenable() {
		return isenable;
	}
	public void setIsenable(int isenable) {
		this.isenable = isenable;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + ", birthday=" + birthday + ", email=" + email
				+ ", isenable=" + isenable + "]";
	}
	
}
