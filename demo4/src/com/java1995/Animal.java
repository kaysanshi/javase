package com.java1995;
/*
 * 父类
 * 父类中只能写公共属性；
 */
public class Animal {
	private String name;
	private String skin;
	private int leghtcount;
	public void eat(){
		System.out.println("动物在吃东西；");
	}
	public void breath(){
		System.out.println("动物在呼吸");
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
