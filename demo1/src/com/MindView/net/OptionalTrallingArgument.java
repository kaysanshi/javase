package com.MindView.net;

public class OptionalTrallingArgument {
	static void f(int required,String...tralling){
		System.out.println("required:"+required+" ");
		for(String s:tralling){
			System.out.print(s+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		f(1,"one");
		f(2,"two","three");
		f(0);

	}

}
