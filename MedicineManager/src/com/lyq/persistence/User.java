package com.lyq.persistence;

import java.util.Date;
/**
 * 用户持久化类
 * @author Li Yong Qiang
 */
public class User {
	private int id;				//id号
	private String username;	//用户名
	private String password;	//密码
	private Date createTime;	//创建日期
	
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
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
}
