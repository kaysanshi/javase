package com.kaysanshi.testArray;
/**
 * 쳲���������:
 * �ݹ���ã�
 * @author leoill
 *@date 2019��4��27��
 */
public class Fibonacci {

	public static int getnumber(int n){
		
		if (n==1) {
			return 0;
		}else if (n==2) {
			return 1;
		}else{
			return getnumber(n-1)+getnumber(n-2);
		}
		
	}
	
	public static void main(String[] args) {
		int res=Fibonacci.getnumber(20);
		System.out.println(res);
	}
}
