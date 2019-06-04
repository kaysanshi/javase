package com.java1995;

public class Test_yield {
//线程暂停；用Thread.yield()方法；当调用star()方法的时候线程间会同时来抢时间片；
	public static void main(String[] args) {
		Thread t1=new Thread(new MThread());
		Thread t2=new Thread(new MyThread1());
		t1.start();
		t2.start();
	}
}
class MThread implements Runnable{
	@Override
	public void run() {
		for(int i=0;i<50;i++){
			System.out.println("*****");
			Thread.yield();
		}
		
	}
	
}
class MyThread1 implements Runnable{
	@Override
	public void run() {
		for(int i=0;i<50;i++){
			System.out.println("@<<<<<<<");
			Thread.yield();
		}
		
	}
	
}
