package com.zcib;

public class TestStudent {
	public static void main(String[]args){
		Student p=new Student();
		p.getName();
		p.setName("Ð¡Î¬Äá");
		System.out.println(p.getName());
		p.setAge(14);
		System.out.println(p.getAge());
		p.setId("00009");
		System.out.println(p.getId());
	}
}
