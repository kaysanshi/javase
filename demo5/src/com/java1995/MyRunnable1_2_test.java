package com.java1995;

public class MyRunnable1_2_test {
//�������ȼ���
	public static void main(String[] args) {
		MyRunnable1 r1=new MyRunnable1();
		MyRunnable2 r2=new MyRunnable2();
		Thread t1=new Thread(r1);
		Thread t2=new Thread(r2);

//���ȼ��õĲ��ԣ�
		System.out.println("t1�����ȼ���"+t1.getPriority());
		System.out.println("t2�����ȼ���"+t2.getPriority());
//		�����������ȼ�
		t1.setPriority(Thread.MAX_PRIORITY);
		System.out.println("�ı������ȼ���"+t1.getPriority());
		t2.setPriority(Thread.NORM_PRIORITY);
		System.out.println("t2�ı������ȼ���"+t2.getPriority());
		t1.setPriority(Thread.MIN_PRIORITY);
		System.out.println("t1��С���ȼ��ǣ�"+t1.getPriority());
//		�������ȼ��ߵģ����ܽ�����ִ��һ��������һ��ִ�У�
		t1.start();
		t2.start();

	}

}
