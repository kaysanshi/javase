package com.zcib.controller;

import java.util.Random;

//�������������ı��
public class Number {
	/*
	 * �����û���ô�
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
