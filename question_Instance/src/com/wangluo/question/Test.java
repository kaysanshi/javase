package com.wangluo.question;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		System.out.println("��ӭ����������蹫˾��");
		System.out.println("��������Ҫ��������1.�γ���2.�ͳ�");
		Scanner scan = new Scanner(System.in);
		int name1= scan.nextInt();
		if(name1==1){
			System.out.println("���������������Ʒ�ƣ�1.����  2.��ˣ�");
			int name=scan.nextInt();
			System.out.println("������γ���Ʒ������(1.550 2.������ 3.����GL)");
			int type= scan.nextInt();
			System.out.println("����������������");
			int day=scan.nextInt();
			scan.close();
			JiaoChe p=new JiaoChe();
			p.getName(name);
			p.getType(type);
			p.day=day;
			p.getMoney(p.getName(),p.getType(),p.day);
			System.out.println("�������Ҫ֧����"+p.getMoney(p.getName(),p.getType(),p.day)+"Ԫ");
			System.out.println("��ӭ�����´ι��٣�����");
		}else if(name1==2){
			System.out.println("����������Ʒ��1.�𱭡�2.����");
			int name=scan.nextInt();
			System.out.println("����������λ����");
			int sit=scan.nextInt();
			System.out.println("����������������");
			int day=scan.nextInt();
			KeChe p1=new KeChe();
			scan.close();
			p1.getName(name);
			p1.sit =sit;
			p1.day=day;
			p1.getMoney(p1.getName(),p1.sit,p1.day);
			System.out.println("�������Ҫ֧����"+p1.getMoney(p1.getName(),p1.sit,p1.day)+"Ԫ");
			System.out.println("��ӭ�����´ι��٣�����");
		}
	}
}