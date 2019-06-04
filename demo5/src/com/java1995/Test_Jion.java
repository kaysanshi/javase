package com.java1995;

public class Test_Jion {
//	线程加入的方法：
	public static void main(String[] args) {
		Thread t1=new Thread(new Thread1());
		t1.start();
		for(int i=0;i<1000;i++){
			if(i%10==0){
				try {
					t1.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("++++++++22");
		}
	}
	
	

}
class Thread1 implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<100;i++){
			System.out.println("******M");
		}
		
	}
	
}