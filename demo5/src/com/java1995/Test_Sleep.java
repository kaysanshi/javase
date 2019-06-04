package com.java1995;

public class Test_Sleep {
//	线程休眠用法：
	public static void main(String[] args) {
		for(int i=0;i<10;i++){
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for(int i=0;i<10;i++){
			System.out.println("*");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
