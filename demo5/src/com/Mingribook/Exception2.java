package com.Mingribook;

public class Exception2 {
//À„ ˝“Ï≥£
	static int m=2;
	static int n=0;
	public double Devate(int a,int b){
		return a/b;
	}
	
	public static void main(String[] args) {
		Exception2 p=new Exception2();
		p.Devate(m, n);
		System.out.println(p.Devate(m, n));
	}
}
