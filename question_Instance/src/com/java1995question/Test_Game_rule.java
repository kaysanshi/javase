package com.java1995question;
import java.util.Scanner;

public class Test_Game_rule {
/*
 * 
 */
	public static void main(String[] args) {
		while(true){
		System.out.println("��ʼ��Ϸ��");
		String arr[]=new String[]{"����","ʯͷ","��"};
		Scanner scan=new Scanner(System.in);
		System.out.println("�����룺����ʯͷ��");
		String s1=scan.nextLine();
		if(s1.equals("����")||s1.equals("ʯͷ")||s1.equals("��")){
			int count=(int)(Math.random()*3);
			String s2=arr[count];
			getName(s1,s2);
			int flag=getName(s1,s2);
			if(flag==1){
				System.out.println("���Գ���"+s2);
				System.out.println("��Ӯ��");
			}
			if(flag==-1){
				System.out.println("���Գ���"+s2);
				System.out.println("����Ӯ��");
			}
			if(flag==0){
				System.out.println("���Գ���"+s2);
				System.out.println("ƽ��");
				}
			}
	else{
		 if(s1.equals("exit")){
				break;
			}
			System.out.println("�����������");
			
		}
		
		}
		System.out.println("���˳�����Ϸ����");
	}
	public static int getName(String s1,String s2){
		if(s1.equals(s2)){
			return 0;
		}
		if (s1.equals("����")){
			if(s2.equals("ʯͷ")){
				return -1;
			}
			if(s2.equals("��")){
				return 1;
			}
		}
		if(s1.equals("��")){
			if(s2.equals("ʯͷ")){
				return 1;
			}
			if(s2.equals("����")){
				return -1;
			}
		}
		if(s1.equals("ʯͷ")){
			if(s2.equals("����")){
				return 1;
			}
			if(s2.equals("��")){
				return -1;
			}
		}
		return 0;
	}
}
