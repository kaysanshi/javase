package com.zcib;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Test {
	//��̬������
	public static void myprint(){
		System.out.println("��ȷ����Ҫִ�е�����");
		System.out.println("------------------------");
		System.out.println("- ���������룺1         -");
		System.out.println("- ��ѯ������:2          -");
		System.out.println("- ɾ�������룺3         -");
		System.out.println("- ���������룺4         -");
		System.out.println("- �޸���Ϣ���룺5       -");
		System.out.println("- �˳������룺0         -");
		System.out.println("-----------------------");
	}
	public static void main(String[] args) {
		System.out.println("��ӭ���Ĳ�Ѳϵͳ�ɼ�����������������룺");
		Scanner scan=new Scanner(System.in);
			ArrayList<Student> list=new ArrayList<Student>();
			StuManager manager=new StuManager(list);
			Student stu=new Student();
			String password=scan.nextLine();
			stu.setPassword(password);
			System.out.println("�������������:");
			String Mima=scan.nextLine();
			stu.getMima(Mima);
		if(stu.getMima(Mima).equals(password)){
			Test.myprint();
			
			Student stu1=new Student("201601014224","��ΰ","��",20,"����","��Ϣ����ϵ",299,"��һ","c����", 95 );
			Student stu2=new Student("201601014222","����","��",22,"����","���繤��",292,"���","Java", 98 );
			Student stu3=new Student("201601010001","�","Ů",20,"����","���ù���ѧ",295,"����","����ѧ",85);
			Student stu4=new Student("201601010002","���","��",22,"�½�","����������",292,"���","���������", 95 );
			Student stu5=new Student("201601010003","����","Ů",23,"�Ϻ�","����ѧ",295,"����","����ѧ",85);
//			���ѧ��
			
			manager.getList().add(stu1);
			manager.getList().add(stu2);
			manager.getList().add(stu3);
			manager.getList().add(stu4);
			manager.getList().add(stu5);
			
			int m=scan.nextInt();
			while(true){
			if(m==1){
				Student stu11=new Student();
//				System.out.println("���������ѧ���ĸ�����");
				System.out.println("���������ѧ�ţ�2016��ͷ");
				String number=scan.next();
				stu11.setNumber(number);
				System.out.println("����������");
				String name=scan.next();
				stu11.setName(name);
				System.out.println("�������Ա�");
				String sex=scan.next();
				if(sex.equals("��")||sex.equals("Ů")){
					stu11.setSex(sex);
				}else{
					System.out.println("������Ĳ��Ϸ�");
				}
				System.out.println("������������䣺");
				int age=scan.nextInt();
				stu11.setAge(age);
				System.out.println("��������ĵ�ַ:");
				String address=scan.next();
				stu11.setAddress(address);
				System.out.println("������ϵ��");
				String department=scan.next();
				stu11.setDepartment(department);
				System.out.println("�������꼶��");
				String grade =scan.next();
				stu11.setGrade(grade);
				System.out.println("�������ܳɼ���");
				double score=scan.nextDouble();
				stu11.setScore(score);
			System.out.println("������רҵ�ο�Ŀ��");
			String subject=scan.next();
			stu11.getSubject(subject);
			System.out.println("�������Ŀ��"+stu11.getSubject(subject)+"�ĳɼ�");
			float score3=scan.nextFloat();
			stu11.getsubscore(score3);
			System.out.println(stu11.getSubject(subject)+stu11.getsubscore(score3));
				manager.getList().add(stu11);
				System.out.print(list);
				System.out.println("��������Ҫִ�е���ţ�"); 
				m=scan.nextInt();
			}
		if(m==2){
		System.out.println("ѧ����Ϣ�б����£�");
		System.out.println(list);
		System.out.println("��������Ҫִ�е���ţ�"); 
			m=scan.nextInt();
		}
//		ɾ��
		if(m==3){
		manager.Delete(list);
		System.out.println("��������Ҫִ�е���ţ�"); 
		 	m=scan.nextInt();
		}
//		����
		if(m==4){
		System.out.println("����ѧ���������룺1.���������� 2��");
		int s=scan.nextInt();
		if(s==1){
		manager.Search(list);}
		if(s==2){
			System.out.println("�������Ϊ��");
			manager.SearchName(list);
		}
			System.out.println("��������Ҫִ�е���ţ�"); 
			m=scan.nextInt();
		}
//		�޸�
		if(m==5){
			manager.Modify(list);
			System.out.println("ѧ����Ϣ���£�");
			System.out.println(list);
			System.out.println("��������Ҫִ�е���ţ�"); 
			m=scan.nextInt();
		}
		if(m==0){
			System.out.println("�����˳�");
			System.exit(0);
		}
			}
		}else{
			System.out.println("������벻��ȷ�������������������룺");
		}
	}

}
