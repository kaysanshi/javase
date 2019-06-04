package com.kaysanshi.testArray;
/**
 * �ݹ����
 * �����εĵ�����
 * @author leoill
 *@date 2019��4��27��
 */
public class Triangle {
	
	public static int getNumber(int n){
		int total=0;
		
		while (n>0) {
			total=total+n;
			n--;
		}
		return total;
	}
	/**
	 * �ݹ����
	 * @param n
	 * @return
	 */
	public static int getNubmerByRecursion(int n){
		if (n==1) {
			return 1;
		}else{
			//���εݹ鱾��
			return n+getNubmerByRecursion(n-1);
		}
	}
	public static void main(String[] args) {
		System.out.println(Triangle.getNumber(3));
		System.out.println(Triangle.getNubmerByRecursion(3));
	}
}
