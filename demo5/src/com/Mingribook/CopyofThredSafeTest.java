package com.Mingribook;

public class CopyofThredSafeTest implements Runnable {
	int num=50;
	@Override
	public void run() {
		while(true){
			synchronized(""){
				if(num>0){
					try{
						Thread.sleep(1000);
					}catch(Exception e){
						e.printStackTrace();
						}
					System.out.println("tickets车票还有"+num--+"张");
					}
				}
			}
		
		}
	public static void main(String[] args) {
//		在使用接口线程时：先进行接口实现类的创建对象；
//		在用Thread类新建对象在进行把 
		CopyofThredSafeTest t=new CopyofThredSafeTest();
		Thread ta=new Thread(t);
		Thread tb=new Thread(t);
		Thread tc=new Thread(t);
		Thread td=new Thread(t);
		ta.start();
		tb.start();
		tc.start();
		td.start();
	}


}
