package com.zcib;

import java.util.Scanner;

public class TestCard {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("�������������");
		String name=scan.nextLine();
		System.out.println("�������������");
		String code=scan.nextLine();
		Card p=new Card();
		p.setName(name);
////		System.out.println();
		p.setCode(code);
//		System.out.println(p.getCode());	
		System.out.println("������ǹ����(1)������ͨ��(0)");{
		int a=scan.nextInt();
			if(a==0){
				System.out.println("�������ֵ�Ľ�");
				float money=scan.nextFloat();
				System.out.println("��ϲ"+p.getName()+"����/Ůʿ��ֵ�ɹ��������Ϊ��"+p.recharge(money));
				System.out.println("��������˴ι���Ľ�");
				float amount=scan.nextFloat();
				p.pay(amount);
		System.out.println("����ι����ѵĽ��Ϊ��"+p.pay(amount));
		System.out.println("������Ϊ��"+p.getBalance()+"��ӭ�´ι��٣�����");
		}else{
				VipCard m=new VipCard();
				System.out.println("��������˴ι���Ľ�");
				float amount1=scan.nextFloat();
				System.out.println("�������ۿۣ�");
				 float discount=scan.nextFloat();
				 m.setDiscount(discount);
				 System.out.println("������������룺");
				 String password=scan.next();
				 m.setPassword(password);
					if(m.getPassword().equals(p.getCode())){
						m.getbalance(amount1);
				System.out.println("����� "+m.getbalance(amount1));
					scan.close();
				}else{
					System.out.println("�������������������������!!!");
				}
					
			}
		}
	}
}
