package com.java1995;

public class Test_P_T {

	public static void main(String[] args) {
//		在这里也运用多线程时；多线程的使用并发进行不唯一的Teacher同时调用一个Print方法：
//		但是在这里并发调用时不是同时唯一不变的；体现了线程并发的特性：
		Print p=new Print();
		Teacher t1=new Teacher(p,"那你",55,44,87);
		Teacher t2=new Teacher(p,"维文",55,98,44);
		Teacher t3=new Teacher(p,"join",150,48,55);
		Thread p1=new Thread(t1);
		Thread p2=new Thread(t2);
		Thread p3=new Thread(t3);
		p1.start();
		p2.start();
		p3.start();
	}

}
