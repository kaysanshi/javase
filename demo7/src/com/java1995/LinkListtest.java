package com.java1995;

import java.util.LinkedList;

public class LinkListtest {
	public static void main(String[] args) {
		LinkedList<String> list=new LinkedList<String>();
		list.add("a");
		list.add("b");
		list.add("d");
		list.add(2, "A");
		System.out.println(list);
		list.addFirst("A");
		list.poll();//�������Ƴ���һ��Ԫ�أ�
		System.out.println(list);
		list.peek();//��������ɾ����һ��Ԫ�أ�
		System.out.println(list);
		list.peekFirst();//��������ɾ����һ��Ԫ�أ�
		System.out.println(list);
//		ת��Ϊ���飻
		String[] s=new String[list.size()];
		list.toArray(s);
		for(String x:s){
			System.out.print(x+" ");
		}
		System.out.println();
		//�������һ����ʽ���вι��췽����
		LinkedList lin=new LinkedList(list);
		System.out.println("��һ����ʽ��");
		System.out.println(lin);
	}

}
