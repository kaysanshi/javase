package com.zcib;

import java.util.Scanner;

public class TestEmployee {

	public static void main(String[] args) {
//		string ������nextLine();������ʵ��
		Scanner scan=new Scanner(System.in);
		System.out.println("����������нˮ �����˵����� ְ�� ����");
		double salary=scan.nextDouble();
		String name =scan.nextLine();
		String responsibilities=scan.nextLine();
		String duty=scan.nextLine();
		scan.close();
		Employee p=new Employee();
		p.setName("�");
		p.setAddress("���");
		p.getSalary(salary);
		p.setPhoneNumber("18364448888");
		p.setNumber("0111");
		System.out.println("������Ϣ��"+"������"+p.getName()+"����ַ��"+p.getAddress()+";�绰��"+
				p.getPhoneNumber()+"�����ţ�"+p.getNumber()+"���ʣ�"+p.getSalary(salary));
		Manager p1=new Manager();
		p1.Resb(responsibilities);
		p1.getDuty(duty);
		p1.getManagerName(name);
		p1.setAddress("����");
		p1.setNumber("00005");
		p1.setPhoneNumber("2526262");
		p1.listOfEmployee("��");
		System.out.println("������Ա����Ϣ��"+"������"+p1.getManagerName(name)+";��ַ��"+p1.getAddress()+
		";����"+ p1.getDuty(duty)+";���ţ�"+p1.getNumber()+";�绰��"+p1.getPhoneNumber()+"ְ��"+
		p1.Resb(responsibilities)+";"+"����:"+p1.getSalary(salary)+";�������Ա��"+p1.listOfEmployee("��"));
		
	
	}

}
