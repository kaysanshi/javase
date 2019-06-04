package com.zcib.book.test;

import java.util.ArrayList;
import java.util.Iterator;
public class TestList {
	public static void main(String[] args) {
		ArrayList<String> name=new ArrayList<String>();
		name.add("张三");
		name.add("李四");
		name.add("王二");
		name.add("马六");
		name.add("赵七");
		for(int i=0;i<name.size();i++){
			System.out.println(name.get(i));
		}
//		用迭代器遍历
		System.out.println();
		for(Iterator<String> it=name.iterator(); it.hasNext();){
			System.out.println(it.next());
		}
		System.out.println("集合的大小："+name.size());//大小；
		
		System.out.println("删除第三个元素后：");
//		利用for循环删除以后未能真正的改变表的长度：所以要用remove()方法；
		for(int i=0;i<name.size();i++){
			if(i!=2){
				System.out.println(name.get(i));
			}
		}
		System.out.println("删除的元素："+name.get(2));
		name.remove(2);//去掉第三个元素
		System.out.println("删除后集合的长度："+name.size());
		System.out.println("删除第三个元素后获得第三个元素："+name.get(2));
	}
}