package com.java1995;

public class Cat extends Felidae{
/*
 * 猫的捕食方法
 */
	@Override
	public void cathAnimals(Animal animal) {
		if(animal instanceof Mouse){
			System.out.println("猫正在捕食老鼠");
		}else{
			System.out.println("猫不能捕食他");
		}
		
	}
}
