package com.java1995;
/*
 * ���߳̿��Լ̳�Thread���runnable�ӿ�
 */
public class MyThread extends Thread{
//	���̵߳�ʵ��
//	���е��߳�ִ�еĴ���������run������
	public MyThread (String name){
//		Ϊ�Լ����̴߳���������д���췽��
		super(name);
	}
	
	public void run(){
		for(int i=0;i<10;i++){
		try {
//			����������ô�ú���п�ʼ����״̬
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}//���ٺ���
		System.out.println("myThread:"+i);
		}
		
	}
//������жԲ���
	public static void main(String[] args) {
		MyThread p=new MyThread("wodeThread");
//		���ö��߳�ʱҪ��star()�ķ���
//		���̵߳ı������star()�ķ���֮��
//		�߳̽������״̬�ȴ�cpu������Դ���ֻ����run��������
		p.start();
//		p.run();���ֻ�ǵ�����run�����������������������ִ��
		
		for(int i=0;i<10;i++){
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("���̵߳ķ���"+i);
		}
		System.out.println("����ִ�����");
//		��ȡ�Լ��������̵߳�����
		System.out.println(p.getName());
	}
}
