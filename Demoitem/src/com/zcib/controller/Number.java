package com.zcib.controller;

import java.util.Random;

//定义个随机产生的编号
public class Number {
	/*
	 * 这个类没有用处
	 */
	private String number;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	public Number(){
		Random res=new Random();
		res.nextInt(15);
	}

}
