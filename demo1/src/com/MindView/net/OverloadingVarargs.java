package com.MindView.net;

public class OverloadingVarargs {
//	可变参数的重载
	static void f(Character...args){
		System.out.print("first");
		for(Character c:args)
			System.out.print(" "+c);
		System.out.println();
	}
	static void f(Integer...args){
		System.out.print("second");
		for(Integer i:args)
			System.out.print(" "+i);
		System.out.println();
	}static void f(Long...args){
		System.out.print("third");
		for(Long c:args)
			System.out.print(" "+c);
		System.out.println();
	}
	public static void main(String[] args) {
		f('a','b','c','d');
		f(1);
		f(2,1);
		f(0);
		f(0l);
		f(1,4,4,5);

	}

}
