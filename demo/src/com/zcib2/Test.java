package com.zcib2;

public class Test {
	public static void main(String[] args) {
		Colok colok=new Colok();
		Thread thread=new Thread(colok);
		thread.start();
	}

}
