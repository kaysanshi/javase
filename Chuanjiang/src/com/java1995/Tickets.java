package com.java1995;

public class Tickets implements Runnable{
	int count=50;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			synchronized(""){
		if(count >=0){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("还有"+count--+"张");
				}
		if(count==0){
			System.out.println("已售完");
			System.exit(0);
		}
			}
		}
	}
	public static void main(String[] args) {
		//可以模拟四个窗口同时售票；
		Tickets t=new Tickets();
		Thread t1=new Thread(t);
		Thread t2=new Thread(t);
		Thread t3=new Thread(t);
		Thread t4=new Thread(t);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
