package com.mingribook.question;

public class Test_I {
/*
 * problem:�������в����ĸ�������ѭ����ӡ����i��ֵ�ô�����
 */
	int j;
	 static int count=0;
	static void getcanshu(int ... j){
//		System.out.println(j.length);�����ĳ��ȣ�
		for(int i=1;i<=j.length;i++){
			System.out.print(i+" ");
			count++;
		}	
		System.out.println("�����ܹ���"+count+"��");
		count=0;
	}
	public static void main(String[] args) {
		getcanshu(2,3,3,444,4,4,5);
		getcanshu(1,2,4);
		getcanshu(2,35,8547,847,44);
	}

}
