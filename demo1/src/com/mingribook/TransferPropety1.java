package com.mingribook;

public class TransferPropety1 {
//	static 定义的成员变量的值可以被本类或其他类共享；
	 static int i=47;//静态成员变量
//	定义成员方法
	public void call(){
		System.out.println("调用call方法");
		for(i=0;i<3;i++){
			System.out.print(i+" ");
			if(i==2){
				System.out .println("\n");
			}
		}
	}
//	定义构造方法；
	public TransferPropety1(){
		
	} 
	public static void main(String[] args) {
		TransferPropety1  p=new TransferPropety1 ();
		TransferPropety1 p1=new TransferPropety1 ();
		p.i=60;//改变类成员变量的值；
		System.out.println("第一个引用调用"+p.i++);
		p.call();
		System.out.println("第二个引用调用"+p1.i);
		p1.call();
//		若要调用静态的成员变量可用以下方法
		System.out.println(TransferPropety1.i);
	}


}
