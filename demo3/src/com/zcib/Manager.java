package com.zcib;

public class Manager extends Employee {
//	继承的实现
	String responsibilities;//职责
	String listOfEmployee;//管理的员工
	String duty;//任务
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
