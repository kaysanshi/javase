package com.java1995;

public class Test_yield {
//�߳���ͣ����Thread.yield()������������star()������ʱ���̼߳��ͬʱ����ʱ��Ƭ��
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
