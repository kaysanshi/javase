package com.zcib;

import java.util.Scanner;

public class TestBank {

	public static void main(String[] args) {
		Scanner scan =new Scanner(System.in);
		System.out.println("�״ΰ������п���������������룺");
		String code=scan.nextLine();
		System.out.println("���������������");
		String name=scan.nextLine();
		System.out.println("���������룺");
		String MIMA=scan.nextLine();
		SavingAccount p=new SavingAccount();
		p.setCode(code);
		p.setName(name);
		p.getMIMA(MIMA);
		System.out.println("������������������֧Ʊȡ�����������-1����֧Ʊȡ�");
		float amount=scan.nextFloat();
		p.deposit(amount);
		p.getBalance(amount);
		if(MIMA.equals(p.getCode())){
			if(p.getBalance(amount)!=-1){
		System.out.println("����Ŀ������Ϊ"+(p.getBalance(amount)));
			}
		if(p.getBalance(amount)==-1){
		System.out.println("������ֻ����֧Ʊ����ȡ�");
		CheckAccount s=new CheckAccount();
		System.out.println("���������ȡ���");
		float amount1=scan.nextFloat();
		s.withdraw(amount1);
		scan.close();
		System.out.println("�۳������Ѻ����ʵ��֧Ʊȡ����Ϊ��"+s.withdraw(amount1));
		System.out.println("������Ƿ���н��Ϊ��"+s.amount1);
			}
		}
	}
}
