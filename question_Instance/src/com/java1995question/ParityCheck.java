package com.java1995question;
import java.util.Scanner;
public class ParityCheck {
	public static void main(String[] args){
		Scanner scan =new Scanner(System.in);//����������ɨ�裻
		System.out.println("������һ��������");
		long number= scan.nextLong();//���ڽ����û������������
		scan.close();
		String check=(number%2==0)?"������ǣ�ż��":"������ǣ�����";
		System.out.println(check);
	}

}
