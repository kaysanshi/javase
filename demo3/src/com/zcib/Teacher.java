package com.zcib;

public class Teacher extends People {
	String develop;
	String add;
	public Teacher(){
		
	}
	public String getDevelop(String develop){
		this.develop=develop;
		return develop;
		
	}
//	在子类中的重写父类方法
	public String getadd(String add){
		this.add=add;
		return add+"继承后的类的调用";
	}
}
