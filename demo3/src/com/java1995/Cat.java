package com.java1995;

public class Cat extends Felidae{
/*
 * è�Ĳ�ʳ����
 */
	@Override
	public void cathAnimals(Animal animal) {
		if(animal instanceof Mouse){
			System.out.println("è���ڲ�ʳ����");
		}else{
			System.out.println("è���ܲ�ʳ��");
		}
		
	}
}
