package com.zcib;

public class People {
//	��people��ʵ�ּ̳У�Ϊ����Teacher���̳У�
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
			System.out.println("�Ա�");
		}
		public String getadd(String add){
			this.add=add;
			return add;
		}

}
