package com.lixinghua;

public class Cat implements Pet {

	private String name;
	private String color;
	private int age;
	public Cat(String name,String color,int age){
		this.name=name;
		this.color=color;
		this.age=age;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	@Override
	public String getColor() {
		// TODO Auto-generated method stub
		return this.color;
	}

	@Override
	public int getAge() {
		// TODO Auto-generated method stub
		return this.age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
