package com.java1995;

public class TestAssigment {
	
	public static void main(String[] args){
		//声明变量
		int speed,salary;
		float time,basicSalary,prize,distance;
		char alphabet;
		//给变量赋值；
		alphabet='a';
		basicSalary=5059.5F;//基本工资
		prize=3001.4F;
		speed=30;
		time=5.1f;
		//表达式赋值
		salary=(int)(basicSalary+prize);//总薪水；
		distance=speed*time;
		System.out.println("字母aphabet="+alphabet);
		System.out.println("基本工资basicSalary="+basicSalary);
		System.out.println("奖金prize="+prize);
		System.out.println("总工资="+salary);
		System.out.println("距离distance="+distance);
		
		
		
	}

}
