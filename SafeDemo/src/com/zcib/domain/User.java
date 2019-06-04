package com.zcib.domain;

import java.io.Serializable;
import java.sql.Date;
/**
 * 用户
 * @author 555
 *
 */
public class User implements Serializable{
	private int userid;
	private String username;
	private String nickname;
	private String password;
	private String gender;
	private String stunumber;
	private String cellphone;
	private String email;
	private Date addtime;
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getStunumber() {
		return stunumber;
	}
	public void setStunumber(String stunumber) {
		this.stunumber = stunumber;
	}
	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
}
