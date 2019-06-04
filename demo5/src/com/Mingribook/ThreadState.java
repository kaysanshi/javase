package com.Mingribook;

public class ThreadState implements Runnable{
	public synchronized void waitForASecond()throws InterruptedException{
		wait(500);//ʹ��ǰ�̵߳ȴ�0.5��������̵߳���notify()������
	}
	public synchronized void waitForYears()throws InterruptedException{
		wait();
	}
	public synchronized void noitfyNow()throws InterruptedException{
		notify();//�����е���wait()�ķ�������ȴ�״̬���߳�
	}
	@Override
	public void run() {
		try{
			waitForASecond();
			waitForYears();
		}catch(InterruptedException e){
			e.printStackTrace();
			
		}
		
	}

}
