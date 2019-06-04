package com.Mingribook;

public class ThreadTest extends Thread{
	private int count=10;
	public void run(){//÷ÿ–¥run∑Ω∑®£ª
		while(true){
			System.out.print(count+" ");
			if(--count==0){
				return;
			}
		}
		
	}
	public static void main(String []args){
		new ThreadTest().start();
	}

}
