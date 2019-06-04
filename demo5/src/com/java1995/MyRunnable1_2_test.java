package com.java1995;

public class MyRunnable1_2_test {
//测试优先级：
	public static void main(String[] args) {
		MyRunnable1 r1=new MyRunnable1();
		MyRunnable2 r2=new MyRunnable2();
		Thread t1=new Thread(r1);
		Thread t2=new Thread(r2);

//优先级得的测试：
		System.out.println("t1的优先级："+t1.getPriority());
		System.out.println("t2的优先级："+t2.getPriority());
//		测试设置优先级
		t1.setPriority(Thread.MAX_PRIORITY);
		System.out.println("改变后的优先级："+t1.getPriority());
		t2.setPriority(Thread.NORM_PRIORITY);
		System.out.println("t2改变后的优先级："+t2.getPriority());
		t1.setPriority(Thread.MIN_PRIORITY);
		System.out.println("t1最小优先级是："+t1.getPriority());
//		设置优先级高的，它能进行先执行一会再让另一个执行；
		t1.start();
		t2.start();

	}

}
