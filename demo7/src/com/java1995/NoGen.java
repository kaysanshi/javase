package com.java1995;

public class NoGen {
//	没有泛型  类型转换过程在运行期
//	有泛型时可以提到编译期
	private Object obj;
	NoGen(Object obj){
		this.obj=obj;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	public void show(){
		System.out.println("对象的类型："+obj.getClass().getName());
	}
	/*
	 * 
	 */
	
	public static void main(String[] args) {
		Integer i=new Integer(10);
		NoGen n=new NoGen(i);
		n.show();
		//
		String s=new String("123");
		NoGen n1=new NoGen(s);
		n1.show();
		Integer i2=(Integer)n.getObj();
		String s2=(String)n1.getObj();
		//在这时就会出现不安全的因数；编译可以通过，运行时出错
		String s3=(String)n.getObj();
		System.out.println(i2+" "+s2+"");
		System.out.println(s3);
		
	}
}
