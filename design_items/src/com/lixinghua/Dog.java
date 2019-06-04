package com.lixinghua;

public class Dog implements Pet {
	private String name;
	private String color;
	private int age;
	public Dog(String name,String color,int Age){
		
		this.name=name;
		this.color=color;
		this.age=Age;
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
