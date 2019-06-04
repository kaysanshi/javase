package com.zcib;

public class Dog {
	private String name;
	public String love;
	double height;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private void speak(){
		System.out.println("¹·¹·»á½²»°");
	}
	public void bark(){
		System.out.println("ÍôÍô");
	}
	public String bark(String name){
		this.name=name;
		return name+"ÍôÍô";
	}
	Dog(){}
	Dog(String name,String love,double height){
		this.name=name;
		this.love =love;
		this.height=height;
	}
}
