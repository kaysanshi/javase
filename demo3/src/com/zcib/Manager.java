package com.zcib;

public class Manager extends Employee {
//	�̳е�ʵ��
	String responsibilities;//ְ��
	String listOfEmployee;//�����Ա��
	String duty;//����
	String name;
	public String getManagerName(String name){
		this.name=name;
		return name;
		
	}
	public String Resb(String responsibilities){
		this.responsibilities=responsibilities;
		return responsibilities;
	}
	public String listOfEmployee(String name){
		this.name=name;
		return name;
	}
	public double getSalary(double salary){
		this.salary=salary;
		return salary*0.25+salary;	
	}
	public String getDuty(String duty){
		this.duty=duty;
		return duty;
	}
}
