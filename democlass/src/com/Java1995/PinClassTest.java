package com.Java1995;

public class PinClassTest {

	public static void main(String[] args) {
//		此方法无效；
//		PinClass.In in=new Pinclass.In();
//		PinClass.In in=new PinClass().new In();
//		这也是通过外部类来访问内部类；前提是在外部类中先访问内部类
		PinClass out=new PinClass();
		out.outPrint();
	}

}
