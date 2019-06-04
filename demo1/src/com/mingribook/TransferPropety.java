package com.mingribook;

public class TransferPropety {
	int i=47;//成员变量
//	定义成员方法
	public void call(){
		System.out.println("调用call方法");
		for(i=0;i<3;i++){
			System.out.print(i+" ");
			if(i==2){
				System.out.println("\n");
			}
		}
	}
//	定义构造方法；
	public TransferPropety(){
		
	} 
	public static void main(String[] args) {
		TransferPropety  p=new TransferPropety ();
		TransferPropety  p1=new TransferPropety ();
		p.i=60;//改变类成员变量的值；
		System.out.println("第一个引用调用"+p.i++);
		p.call();
		System.out.println("第二个引用调用"+p1.i++);
		p1.call();
	}

}
