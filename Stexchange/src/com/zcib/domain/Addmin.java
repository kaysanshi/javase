package com.zcib.domain;

import java.util.Date;

/**
 * 管理员
 * @author 555
 *@date 2018年5月8日
 */
public class Addmin {
	private int id;//id
	private String username;//用户名
	private String password;//密码
	private Date addtime;//添加时间；
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

}
