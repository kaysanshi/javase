package com.Mingribook;

public class ThreadSteteTest {

	public static void main(String[] args) throws InterruptedException {
		ThreadState state=new ThreadState();
		Thread thread=new Thread(state);
		System.out.println("新建线程："+thread.getState());
		thread.start();
		System.out.println("启动线程："+thread.getState());
		Thread.sleep(100);
		System.out.println("计时 线程："+thread.getState());
		Thread.sleep(1000);
		System.out.println("等待线程："+thread.getState());
		state.noitfyNow();
		System.out.println("唤醒线程："+thread.getState());
		Thread.sleep(1000);
		System.out.println("终止线程："+thread.getState());
	}

}
