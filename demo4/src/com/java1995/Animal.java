package com.java1995;
/*
 * ����
 * ������ֻ��д�������ԣ�
 */
public class Animal {
	private String name;
	private String skin;
	private int leghtcount;
	public void eat(){
		System.out.println("�����ڳԶ�����");
	}
	public void breath(){
		System.out.println("�����ں���");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSkin() {
		return skin;
	}
	public void setSkin(String skin) {
		this.skin = skin;
	}
	public int getLeghtcount() {
		return leghtcount;
	}
	public void setLeghtcount(int leghtcount) {
		this.leghtcount = leghtcount;
	}
	

}
