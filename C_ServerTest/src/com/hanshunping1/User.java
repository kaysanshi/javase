package com.hanshunping1;

import java.io.Serializable;
///在网络间传输是要进行序列化;
public class User implements Serializable{
	private String name;
	private  String pass;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	

}
