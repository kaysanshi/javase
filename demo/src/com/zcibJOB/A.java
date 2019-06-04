package com.zcibJOB;

public class A {
/*  static int k=3;
	  public static void main(String[] args) { 
	    int k=4;
	    A  x1=new A();
	    x1.k++;
	    A  x2=new A();
	    x2.k++;
	    k++;
	    System.out.println(x1.k); 
	  }*/
	  static int k=3;
	  static int m;
	  public static void main(String[] args) {
	     k++;
	     if (m==0) 
	       System.out.println(k); 
	     else
	       System.out.println(B.k); 
	     k++;
	  }
	 }
	 class B {
	     static int k=6;
	 } 

