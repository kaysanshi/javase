package com.java1995;
//����һ��è�Ƴ����ࣻ������ֻ��һ��ģ�壬���������ǹ��е�������
public abstract class Felidae {
	private int legcount=4;
	private String headShape="round";
	private boolean meateat=true;
//	����һ����ͨ�ķ�����
	public void cry(){
		System.out.println("�����ں��");
	}
//	����һ�����󷽷����ڴ��ó��󷽷�����Ϊ������ʵ�����ķ�����һ��
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
