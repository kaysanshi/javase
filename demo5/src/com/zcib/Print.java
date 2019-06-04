package com.zcib;

public class Print {
//	与demo6一起来实现包的调用；
	public static void println(Object obj){
		System.out.println(obj);
	}
	public static void println(){
		System.out.println();
	}
	public static void print(Object obj){
		System.out.println(obj);
	}
	public static void printf(String format,Object...args){
		System.out.format(format,args);
	}

}
