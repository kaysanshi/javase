package com.zcib;

public class TestDog {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog p=new Dog();
		p.height=20;
		p.love ="��";
		p.bark("����");
		p.bark();
//		�ڴ˲������в��ܲ���speak�ķ�����Ϊ����˽�еģ�
		System.out.println(p.bark("����"));
	}

}
