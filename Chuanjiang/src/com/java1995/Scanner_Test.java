package com.java1995;

import java.util.Scanner;

public class Scanner_Test {
	
	public void desply(String name,String s1){
		if(name.equals("admin")&&s1.equals("1")){
			System.out.println("��¼�ɹ�");
		}else{
			System.out.println("�������������");
			System.out.println("����������");
		}
		
	}

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		Scanner_Test st=new Scanner_Test();
		String s=scan.nextLine();
		String s1=scan.nextLine();
		st.desply(s, s1);
	}

}
