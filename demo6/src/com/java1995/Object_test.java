package com.java1995;

public class Object_test {

	public static void main(String[] args) {
		Object a1=new Object();
		Object a2=new Object();
		System.out.println(a1.equals(a2));
//		hashCode��һ���ڴ��ַ�㷨��
		System.out.println(a1.hashCode()+","+a2.hashCode());
//		clone����ʹ�ú�������ַ��ͬ���൱������һ��������
		Student s1=new Student();
		s1.setName("�");
		s1.setAge(12);
		s1.setSex("��");
		System.out.println(s1);
		try {
			Student s2=s1.clone();
			System.out.println(s2);
			System.out.println(s1.equals(s2));
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
	class Student implements Cloneable{
		private String name;
		private String sex;
		private int age;
		public Student clone() throws CloneNotSupportedException{
			return (Student)super.clone();
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		@Override
		public String toString() {
			return "student [name=" + name + ", sex=" + sex + ", age=" + age + "]";
		}
		
	}


