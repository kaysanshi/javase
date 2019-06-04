package com.Java1995;

public class OutClass {
//内部类的测试
	public int i=10;
	private String out_string="out String";
	public void getInner(){
//外部类中的方法调用内部类；外部类创建内部类对象；
		Inner in=new Inner();
		System.out.println("外部类中的方法调用;");
		in.put();	
	}
//	创建内部类；成员内部类相当于外部类的成员变量或者方法；
	class Inner{
		public void put() {
			System.out.println("这是内部类的方法");
			System.out.println(out_string);
		}
	}
}
