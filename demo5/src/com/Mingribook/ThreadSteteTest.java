package com.Mingribook;

public class ThreadSteteTest {

	public static void main(String[] args) throws InterruptedException {
		ThreadState state=new ThreadState();
		Thread thread=new Thread(state);
		System.out.println("�½��̣߳�"+thread.getState());
		thread.start();
		System.out.println("�����̣߳�"+thread.getState());
		Thread.sleep(100);
		System.out.println("��ʱ �̣߳�"+thread.getState());
		Thread.sleep(1000);
		System.out.println("�ȴ��̣߳�"+thread.getState());
		state.noitfyNow();
		System.out.println("�����̣߳�"+thread.getState());
		Thread.sleep(1000);
		System.out.println("��ֹ�̣߳�"+thread.getState());
	}

}
