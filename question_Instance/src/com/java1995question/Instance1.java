package com.java1995question;
import java.util.Scanner;
public class Instance1 {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("������������ý׳�����");
		double n=scan.nextDouble();//  �������Ҫ�ر������int
								//���͸�Ϊdouble����
		scan.close();
		double ride=1;
		for(int i=1;i<=n;i++){
			ride*=i;
		}
		System.out.println(ride);
	}
}
