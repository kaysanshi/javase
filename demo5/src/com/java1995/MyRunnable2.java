package com.java1995;

public class MyRunnable2  implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<50;i++){
			System.out.print("+");
		}
		
	}

}
