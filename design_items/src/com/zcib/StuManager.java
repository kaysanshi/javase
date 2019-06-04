package com.zcib;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class StuManager {
	private List<Student>list;
//	   构造方法
//	泛型在类中的方法中使用
	public StuManager(List<Student>list){
		this.setList(list);
	}
//	getset方法
	public List<Student> getList() {
		return list;
	}
	public void setList(List<Student> list) {
		this.list = list;   
	}
	

//	删除学生
	public Student Delete(List<Student>  list){
//		System.out.println(list.size());
		Scanner scan=new Scanner(System.in);
		String number=scan.next();
		Iterator<Student> it = list.iterator();  
        while (it.hasNext()) { 
        	Student s=it.next();
            if(s.getNumber().equals(number)){  
            	it.remove();  
            }
        }
        System.out.println("删除后余下的学生信息");
        System.out.println(list.toString());
		return null;
	}
//	根据学生的学号来返回学生信息
	public Student Search(List<Student> list){
		int flag=0;//定义一个标志
		Scanner scan=new Scanner(System.in);
		System.out.println("请你输入你要查询的学号");
		String number=scan.nextLine();
		for(Iterator<Student> it=list.iterator();it.hasNext();){
			Student stu=it.next();
			if(stu.getNumber().equals(number)){
					System.out.println(stu.toString());
			}else{
				flag++;
			}
		}
		if(flag==list.size()){//查寻到表的末尾时，
			System.out.println("没有这个学生的信息！！");
		}
		return null;
	}
//	按姓名查询：
	public Student SearchName(List<Student> list){
		int flag=0;
		Scanner scan=new Scanner(System.in);
		System.out.println("请你输入你要查询的名字");
		String name=scan.nextLine();
		for(Iterator<Student> it=list.iterator();it.hasNext();){
			Student stu=it.next();
			if(stu.getName().equals(name)){
					System.out.println(stu.toString());
			}else{
				flag++;
			}
		}
		if(flag==list.size()){
			System.out.println("没有这个学生的信息！！");
		}
		return null;
	}
//	返回年龄排序姓名//出错误不知如何实现排序

//	根据学号或者姓名来修改
	public Student Modify(List<Student> list){
		int flag=0;
		Iterator<Student>  it=list.iterator();
		Scanner scan=new Scanner(System.in);
		System.out.println("请你输入你学号");
		String number=scan.nextLine();
		while(it.hasNext()){
			Student s=it.next();
			if(s.getNumber().equals(number)){
				System.out.println("请输入新的姓名：");
				String name=scan.nextLine();
				s.setName(name);
				System.out.println("请输入新的地址：");
				String address=scan.nextLine();
				s.setAddress(address);
				System.out.println("新的系别：");
				 String department=scan.nextLine();
				s.setDepartment(department);
				System.out.println("请输入年级：");
				String grade =scan.next();
				s.setGrade(grade);
				System.out.println("请输入总成绩：");
				double score=scan.nextDouble();
				s.setScore(score);
//				System.out.println(s.toString());	
			}else{
				flag++;
			}
		}if(flag==list.size()){
			System.out.println("没有这个学生的信息");
		}
		
		return null;
	}
}
