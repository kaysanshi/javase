package com.java1995;

public class MyRunnable implements Runnable {
//即在类中重写接口Runnable中的run方法才能实现多继承
//	令一个是继承Thread类后进行重写run方法；
	@Override
	public void run() {
		for(int i=0;i<10;i++){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("线程中的"+i);
		}
		
	}
	public static void main(String[] args) {
//		在多线程的接口的调用时进行调用run()方法；
		MyRunnable mr=new MyRunnable();
		Thread t=new Thread(mr);
		t.start();
//		在主方法中实现主线程的代码
//		可以演示多线程的并发调用时有cpu中控制主线程和多线程的调用；随机
		for(int i=0;i<10;i++){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("主方法"+i);
		}
	}
//用接口的方法来实现多线程的
}
