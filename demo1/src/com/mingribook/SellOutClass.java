package com.mingribook;

public class SellOutClass {
	private String name;
//	���췽����
	public SellOutClass(){
		name="ƻ��";
	}
//	һ���ⲿ���еķ�����д��һ���ڲ��࣬�ڲ�����Ҳ������ʵ��������
	public void sell(int price){
		class Apple{
			int innerPrice=0;
			public Apple(int price){
				innerPrice=price;
			}
			public void price(){
				System.out.println("���ڿ�ʼ����"+name);
				System.out.println("����Ϊ��"+innerPrice+"Ԫ");
			}
		}
		Apple apple=new Apple(price);
		apple.price();//�����ڲ���ķ�����
	}
	public static void main(String[] args) {
		SellOutClass smaple=new SellOutClass();
		smaple.sell(100);

	}

}
