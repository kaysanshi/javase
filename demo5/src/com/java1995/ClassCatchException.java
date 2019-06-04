package com.java1995;

public class ClassCatchException {

	public static void main(String[] args) {
		People p1=new Student();
//		强制转换为Student对象
		try{
		Student s1=(Student)p1;
		Teacher2 t1=(Teacher2)p1;
		}catch(ClassCastException e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
	class People{
		
	}
	class Student extends People{
		private String name;
	}
	class Teacher2 extends People{
		
	}

