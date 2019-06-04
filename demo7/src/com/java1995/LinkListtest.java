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
		list.poll();//检索并移除第一个元素；
		System.out.println(list);
		list.peek();//检索但不删除第一个元素；
		System.out.println(list);
		list.peekFirst();//检索但不删除第一个元素；
		System.out.println(list);
//		转换为数组；
		String[] s=new String[list.size()];
		list.toArray(s);
		for(String x:s){
			System.out.print(x+" ");
		}
		System.out.println();
		//构造的另一种形式：有参构造方法：
		LinkedList lin=new LinkedList(list);
		System.out.println("另一种形式：");
		System.out.println(lin);
	}

}
