package com.zcib;

public class People {
	private String skin;
	private String eyecolor;
	public void Hello(){
		System.out.println("hello");
	}
	public void averageHeight() {
		System.out.println("平均升高自己查去");
		
	}
	public void averageWeight(){
		System.out.println("平均重量自己查：");
		
	}
	public String getSkin() {
		return skin;
	}
	public void setSkin(String skin) {
		this.skin = skin;
	}
	public String getEyecolor() {
		return eyecolor;
	}
	public void setEyecolor(String eyecolor) {
		this.eyecolor = eyecolor;
	}
}
