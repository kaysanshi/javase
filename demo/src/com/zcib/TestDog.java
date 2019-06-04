package com.zcib;

public class TestDog {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog p=new Dog();
		p.height=20;
		p.love ="肉";
		p.bark("京巴");
		p.bark();
//		在此测试类中不能测试speak的方法因为他是私有的；
		System.out.println(p.bark("京巴"));
	}

}
