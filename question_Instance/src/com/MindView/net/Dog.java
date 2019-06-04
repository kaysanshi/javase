package com.MindView.net;
//p83;
public class Dog {
	public void bark(){
		System.out.println("狗仔叫");
	}
	public void bark(String s){
		System.out.println("Barking");
	}
	public void bark(int m){
		System.out.println("howling");
	}
	public void bark(int m,double n){
		System.out.println("不同个的在叫");
	}
	public void bark(double n,int m){
		System.out.println("两则交换之后的实现");
		
	}
	String s;

	public static void main(String[] args) {
		Dog d=new Dog();
		d.bark();
		d.bark(0);
		d.bark(null);
		d.bark(2.0, 32);
		d.bark(2, 3.0);
		System.out.println(d.s);
	}

}
