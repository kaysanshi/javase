package com.Java1995;

public class Innerjubu {
//局部内部类的实现
	public static void main(String[] args) {
		Outer out=new Outer();
		OutI oi=out.Way(3);
		System.out.println(oi);
	}
}
class Outer{
	private String name;
//	局部内部类的变量必须是final的；
	public OutI Way(final int i){
		final int count = 0;
//	定义一个局内部类；
		class Inner implements OutI{
			public void innerWay(){
				System.out.println(name);
				System.out.println(i);
				System.out.println(count);
				}
			}
		return new Inner();
		}
	}
interface OutI{
	
}