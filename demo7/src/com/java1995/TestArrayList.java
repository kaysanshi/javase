package com.java1995;

public class TestArrayList {
//���Լ�д��ArrayList
	public static void main(String[] args) {
		ArrayList list=new ArrayList();
		Student s=new Student();
		list.add(1);
		list.add("b");
		list.add("c");
		System.out.println(list);
		System.out.println(list.get(2));
		list.remove(3);
		System.out.println(list); 
		s.setName("�");
		s.setAge("20");
		s.setSex("��");
		s.setAddress("����");
		list.add(s);
		System.out.println(list);

	}

}
