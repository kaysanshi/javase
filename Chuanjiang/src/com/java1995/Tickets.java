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
			System.out.println("����"+count--+"��");
				}
		if(count==0){
			System.out.println("������");
			System.exit(0);
		}
			}
		}
	}
	public static void main(String[] args) {
		//����ģ���ĸ�����ͬʱ��Ʊ��
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
