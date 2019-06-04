package com.java1995;
//九九乘法表
/*最后一个答案是：
 * 	m1() in Sub
	m1() in Super
	m2() in Super
 */
public class Demo1 {
	public void print(){
		for(int i=1;i<=9;i++){
			for(int j=1;j<=i;j++){
				System.out.print(j+"*"+i+"="+i*j+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Demo1 s=new Demo1();
		s.print();
	}
}
