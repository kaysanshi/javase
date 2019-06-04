package com.Mingribook;

public class ThreadState implements Runnable{
	public synchronized void waitForASecond()throws InterruptedException{
		wait(500);//使当前线程等待0.5秒或其他线程调用notify()方法；
	}
	public synchronized void waitForYears()throws InterruptedException{
		wait();
	}
	public synchronized void noitfyNow()throws InterruptedException{
		notify();//唤醒有调用wait()的方法进入等待状态的线程
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
