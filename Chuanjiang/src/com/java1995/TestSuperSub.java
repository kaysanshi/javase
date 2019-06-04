package com.java1995;
/*
 * 	
 */
class Super{
	public void m1(){
	System.out.println("m1() in Super" );
	}
	public void m2(){	
		System.out.println("m2() in Super" );
		}

}
class Sub extends Super{
		public void m1(){
		System.out.println("m1() in Sub");

		super.m1();
		}
	}
public class TestSuperSub{
		public static void main(String args[]){
		Sub s = new Sub();
		s.m1();

		s.m2();

		}
}