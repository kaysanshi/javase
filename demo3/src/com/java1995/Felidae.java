package com.java1995;
//定义一个猫科抽象类；抽象类只是一个模板，此类有他们共有的特征；
public abstract class Felidae {
	private int legcount=4;
	private String headShape="round";
	private boolean meateat=true;
//	定义一个普通的方法；
	public void cry(){
		System.out.println("动物在吼叫");
	}
//	定义一个抽象方法；在此用抽象方法是因为子类中实现他的方法不一样
	public abstract void cathAnimals(Animal animal);
//	
	public int getLegcount() {
		return legcount;
	}
	public void setLegcount(int legcount) {
		this.legcount = legcount;
	}
	public String getHeadShape() {
		return headShape;
	}
	public void setHeadShape(String headShape) {
		this.headShape = headShape;
	}
	public boolean isMeateat() {
		return meateat;
	}
	public void setMeateat(boolean meateat) {
		this.meateat = meateat;
	}
}
