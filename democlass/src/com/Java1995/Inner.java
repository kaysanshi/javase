package com.Java1995;

public class Inner extends A.B{
//	在构造器中进行对内部类中调用必须借助于外部类
//	才能使其成成功继承内部类
		public Inner(A a){
			a.super();
		}
	
}
class A{
		
	class B{
			
		}
	}
