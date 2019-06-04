package com.zcib;

import java.util.Scanner;

public class TestEmployee {

	public static void main(String[] args) {
//		string 类中用nextLine();方法来实现
		Scanner scan=new Scanner(System.in);
		System.out.println("请依次输入薪水 管理人的姓名 职责 任务：");
		double salary=scan.nextDouble();
		String name =scan.nextLine();
		String responsibilities=scan.nextLine();
		String duty=scan.nextLine();
		scan.close();
		Employee p=new Employee();
		p.setName("李华");
		p.setAddress("香港");
		p.getSalary(salary);
		p.setPhoneNumber("18364448888");
		p.setNumber("0111");
		System.out.println("工人信息："+"姓名："+p.getName()+"，地址："+p.getAddress()+";电话："+
				p.getPhoneNumber()+"，工号："+p.getNumber()+"工资："+p.getSalary(salary));
		Manager p1=new Manager();
		p1.Resb(responsibilities);
		p1.getDuty(duty);
		p1.getManagerName(name);
		p1.setAddress("北京");
		p1.setNumber("00005");
		p1.setPhoneNumber("2526262");
		p1.listOfEmployee("金华");
		System.out.println("管理人员的信息："+"姓名："+p1.getManagerName(name)+";地址："+p1.getAddress()+
		";任务："+ p1.getDuty(duty)+";工号："+p1.getNumber()+";电话："+p1.getPhoneNumber()+"职责："+
		p1.Resb(responsibilities)+";"+"工资:"+p1.getSalary(salary)+";管理的人员："+p1.listOfEmployee("金华"));
		
	
	}

}
