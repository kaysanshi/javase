package com.mingribook;

public class SellOutClass {
	private String name;
//	构造方法；
	public SellOutClass(){
		name="苹果";
	}
//	一个外部类中的方法中写了一个内部类，内部类中也进行了实例化对象；
	public void sell(int price){
		class Apple{
			int innerPrice=0;
			public Apple(int price){
				innerPrice=price;
			}
			public void price(){
				System.out.println("现在开始销售"+name);
				System.out.println("单价为："+innerPrice+"元");
			}
		}
		Apple apple=new Apple(price);
		apple.price();//调用内部类的方法；
	}
	public static void main(String[] args) {
		SellOutClass smaple=new SellOutClass();
		smaple.sell(100);

	}

}
