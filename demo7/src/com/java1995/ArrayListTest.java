package com.java1995;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListTest {

	public static void main(String[] args) {
		 ArrayList<String> all=new ArrayList<String>();
		 all.add("a");
		 all.add("b");
		 all.add("c");
		 System.out.println("大小"+all.size());
		 System.out.println(all);
//		 增加
		 all.add(0, "one");
		 all.add("M");
		 System.out.println(all);
//		修改
		 all.set(0,"first");
		 System.out.println(all);
//		 删除
		 all.remove(2);
		 System.out.println(all);
//		 遍历
		 for(int i=0;i<all.size();i++){
			 System.out.print(all.get(i)+" ");
		 }
		 //
		 System.out.println();
		 for(String s:all){
			 
			 System.out.print(s+" ");
		 }
		 //
		 System.out.println();
		 Iterator<String> it=all.iterator();
		 while(it.hasNext()){
			 System.out.print(it.next()+" ");
		 }
		 System.out.println();
		 System.out.println("数组交互：");
//		 数组与结合的交互
		 String[] s1=new String[all.size()];
		 s1=all.toArray(s1);
		 for(String s:all){
			 System.out.print(s+" ");
		 }
		 System.out.println();
//			构造方法 进行传值
		 System.out.println("构造方法传值：");
		 ArrayList<String> all1=new ArrayList<String>(all);
		 System.out.println(all1);
		 System.out.println(all1.equals(all));
//		 
		 //限制大小？不能 因为它能括容
		 ArrayList<String> all3=new ArrayList<String>(3);
		 //addAll可以增加一个引用
		 all3.addAll(all);
		 System.out.println(all3);
	}

}
