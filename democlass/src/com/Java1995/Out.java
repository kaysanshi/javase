package com.Java1995;

public class Out {
//内部类
	private  int age=12;//外部类变量
  class In{
		private int age=13;//内部类变量
		public void printf(){
			int age=14;//局部变量
			System.out.println("外部类变量："+Out.this.age);
			System.out.println("内部变量："+this.age);
			System.out.println("局部变量："+age);	
		}
	}
	public static void  main(String []args){
//	调用内部类的方式1
		Out.In in=new Out().new In();
		in.printf();
//		也可以用以下方法直接掉用内部类的方法2
		Out out=new Out();
		Out.In inn=out.new In();
		inn.printf();
	}
}
