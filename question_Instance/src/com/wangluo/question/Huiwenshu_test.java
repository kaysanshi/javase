package com.wangluo.question;

import java.util.Scanner;

public class Huiwenshu_test {
//	���������жϣ�
//	�����㷨�����ȡ������λ������
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		for(int i=10000;i<100000;i++){
			int ge=i%10;
			int shi=i/10%10;
			int qian=i/10/10/10%10;
			int wan=i/10/10/10/10%10;
			if(ge==wan&&qian==shi){
				System.out.println(i);
			}
		}
		
		System.out.println("���������λ����");
		int x=scan.nextInt();
		int ge=x%10;
		int shi=x/10%10;
		int qian=x/10/10/10%10;
		int wan=x/10/10/10/10%10;
		if(ge==wan&&qian==shi){
			System.out.println("������ǻ�����");
		}else{
			System.out.println("��������Ǹ�������");
		}

	}

}
