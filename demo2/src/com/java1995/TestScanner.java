package com.java1995;
import java.util.Scanner;

public class TestScanner {

	public static void main(String[] args) {
		System.out.println("��������������");
		Scanner scan=new Scanner(System.in);
		int a=scan.nextInt();
		int b=scan.nextInt();
		int c=scan.nextInt();
		if(a>b){
			if(a>c){
				System.out.println("���ֵΪ��"+a);
			}
		}else if(b>c){
			if(c>a){
				System.out.println("���ֵΪ��"+b);
			}
			
		}else if(c>b){
			if(b>a){
				System.out.println("���ֵΪ��"+c);
			}
		}
		System.out.println("�����������������͵���Сֵ��");
		System.out.println("��ֱ�����������");
		float m=scan.nextFloat();
		float n=scan.nextFloat();
		float s=scan.nextFloat();
		scan.close();
		if(m<n){
			if(n<s){
				System.out.println("��СֵΪ��"+m);
			}
		}else if(n<s){
			if(s<m){
				System.out.println("��СֵΪ��"+n);
			}
		}else if(s<m){
			if(m<n){
				System.out.println("��СֵΪ��"+s);
			}
		}
		
		System.out.println("�������ת����");
		String str="123";
		int q=Integer.parseInt(str);//Integer���е�parseInt()���Խ��ַ���ת��Ϊ���֣�
		System.out.println("�ַ���ת��Ϊ����"+q);
	}

}
