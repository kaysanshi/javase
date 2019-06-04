package com.java1995;
/*
 * 多线程可以继承Thread类和runnable接口
 */
public class MyThread extends Thread{
//	多线程的实现
//	所有的线程执行的代码必须放在run方法内
	public MyThread (String name){
//		为自己的线程创建名字重写构造方法
		super(name);
	}
	
	public void run(){
		for(int i=0;i<10;i++){
		try {
//			程序休眠这么久后进行开始就绪状态
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}//两百毫秒
		System.out.println("myThread:"+i);
		}
		
	}
//下面进行对测试
	public static void main(String[] args) {
		MyThread p=new MyThread("wodeThread");
//		调用多线程时要用star()的方法
//		多线程的必须调用star()的方法之后
//		线程进入就绪状态等待cpu分配资源后又会调用run方法（）
		p.start();
//		p.run();这个只是调用了run（）这个方法还是至上由下执行
		
		for(int i=0;i<10;i++){
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("主线程的方法"+i);
		}
		System.out.println("程序执行完毕");
//		获取自己创建的线程的名字
		System.out.println(p.getName());
	}
}
