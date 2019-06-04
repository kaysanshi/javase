package com.mingribook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;

public class ListIteratorDemo {
	/*
	 * Iterator接口中迭代器的使用
	 */
	public static void main(String[] args) {
//		创建数据对象类型为Integer的集合
		ArrayList<Integer>array=new ArrayList<Integer>();
//		使用Collections类中的工具方法addAll()添加元素
		Collections.addAll(array, 1,2,3,4,5);
		System.out.println("集合中的元素："+array);
//		使用无参的构造方法获得ListIterator对象
		ListIterator<Integer> iterator=array.listIterator();
//		对于初始位置判断是否右下一个元素
		boolean hasNext=iterator.hasNext();
		System.out.println("判断是否有下一个元素："+hasNext);
		System.out.println("判断是否有前一个元素："+iterator.hasPrevious());
		System.out.println("获得集合中的下一个元素："+iterator.next());
		System.out.println("获得集合中的下一个元素的索引："+iterator.nextIndex());
		System.out.println("获得集合中的前一个元素："+iterator.previous());
		System.out.println("获得集合中的前一个元素的索引："+iterator.previousIndex());
		iterator.add(7);
		System.out.println(array);
		iterator.next();//获得下一个元素
		iterator.set(12);//改变获得的元素值
		System.out.println("修改后的："+array);
		iterator.remove();
		System.out.println("再次修改后的："+array);
//		用迭代器输出；
		for(Iterator<Integer>it=array.iterator();it.hasNext();){
			System.out.print(it.next()+" ");
		}
//		遍历方式二
		Iterator<Integer>it=array.iterator();
		while(it.hasNext()){
			System.out.print(it.next()+" ");
		}
	}

}
