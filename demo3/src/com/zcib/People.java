package com.zcib;

public class People {
//	用people类实现继承；为了让Teacher来继承；
		String name;
		String sex;
		int age;
		String add;
		public String getName(String name){
			return name;
		}
		public String getSex(String sex){
			return sex;
		}
		public void getSex(){
			System.out.println("性别");
		}
		public String getadd(String add){
			this.add=add;
			return add;
		}

}
