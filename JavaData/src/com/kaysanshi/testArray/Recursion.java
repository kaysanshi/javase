package com.kaysanshi.testArray;
/**
 * �ݹ��ʹ��:
 *������ñ���ģ������н����ı�־ 
 * @author leoill
 *@date 2019��4��27��
 */
public class Recursion {
	
	public static void test() {
		System.out.println("���Եݹ�");
		test();
	}
	public static void test2(int n){
		if(n==0){
			return ;
		}
		System.out.println(n);
		test2(n-1);
	}
	public static void main(String[] args) {
		test2(100);
	}
}
