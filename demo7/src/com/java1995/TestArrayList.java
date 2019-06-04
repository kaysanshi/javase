package com.java1995;

public class TestArrayList {
//用自己写的ArrayList
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
		s.setName("李虎");
		s.setAge("20");
		s.setSex("男");
		s.setAddress("河南");
		list.add(s);
		System.out.println(list);

	}

}
