package com.java1995;

public class MyRunnable implements Runnable {
//����������д�ӿ�Runnable�е�run��������ʵ�ֶ�̳�
//	��һ���Ǽ̳�Thread��������дrun������
	@Override
	public void run() {
		for(int i=0;i<10;i++){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("�߳��е�"+i);
		}
		
	}
	public static void main(String[] args) {
//		�ڶ��̵߳Ľӿڵĵ���ʱ���е���run()������
		MyRunnable mr=new MyRunnable();
		Thread t=new Thread(mr);
		t.start();
//		����������ʵ�����̵߳Ĵ���
//		������ʾ���̵߳Ĳ�������ʱ��cpu�п������̺߳Ͷ��̵߳ĵ��ã����
		for(int i=0;i<10;i++){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("������"+i);
		}
	}
//�ýӿڵķ�����ʵ�ֶ��̵߳�
}
