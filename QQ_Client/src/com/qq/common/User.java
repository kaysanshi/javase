package com.qq.common;

import java.io.Serializable;
//��ͬ���������л��Ĵ���
public class User implements Serializable{
	private String id;
	private String passward;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassward() {
		return passward;
	}
	public void setPassward(String passward) {
		this.passward = passward;
	}
}
