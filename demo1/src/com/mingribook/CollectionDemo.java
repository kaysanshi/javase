package com.mingribook;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CollectionDemo {
/*
 * 集合对象想对象中添加元素
 */
	public static void main(String[] args) {
		String a="A",b="B",c="C",d="d",e="e";//定义字符对象
		List<String>list=new LinkedList<String>();//创建字符串行的集合
//		向集合中添加元素
		list.add(a);
		list.add(b);
		list.add(c);
//		创建迭代器然后进行输出形式一：
		Iterator<String> f=list.iterator();
		while(f.hasNext()){
			System.out.print(f.next()+" ");
		}
//		修改其中的数字list.set(索引值，修改的值)
//		add(String item, int index) 
//		将指定的项目添加到由索引指示的位置的滚动列表中。 
		list.set(1, d);
		list.set(2, e);
//		进行输出形式二：
		Iterator<String> it=list.iterator();
		while(it.hasNext()){
			String s=(String)it.next();
			System.out.print(s+" ");
		}
//		形式三：当再次遍历时以便为修改后的元素
		for(Iterator<String> it1=list.iterator();it1.hasNext();){
			String s1=(String)it1.next();
			System.out.print(s1+" ");
		}
	}

}
