package com.wangluo.question;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class StudentAdmin {

	public static void main(String[] args) {
		ArrayList<Student>  list=new ArrayList<Student>();
		while(true){
			System.out.println("$$��ӭ����ѧ������ϵͳ$$");
			System.out.println("$$1.�鿴ѧ����Ϣ $$");
			System.out.println("$$2.���ѧ�� $$    ");
			System.out.println("$$3.ɾ��ѧ��$$");
			System.out.println("$$4.�޸���Ϣ&&");
			System.out.println("&&0.�˳�&&");
			Scanner scan=new Scanner(System.in);
			String n=scan.nextLine();
			switch(n){
			case "1":findAllStudent(list);break;
			case "2":addStudent(list);break;
			case "3":removeStudent(list);break;
			case "4":updateStudent(list);break;
			default:System.out.println("лл���ʹ��");
			System.exit(0);break;
			}
		}

	}
/*
 * 
 */
//	�޸�ѧ����Ϣ��
	public static void updateStudent(ArrayList<Student> list){
		Scanner scan =new Scanner(System.in );
		System.out.println("����������Ҫ�޸ĵ�ѧ�ţ�");
		String id=scan.nextLine();
		int index=-1;
		for(int x=0;x<list.size();x++){
			Student s=list.get(x);
			if(id.equals(s.getId())){
				index=x;
				break;
			}
		}
		if(index==-1){
			System.out.println("û�����ѧ����Ϣ");
		}else{
			System.out.println("����������");
			String name=scan.nextLine();
			System.out.println("����������");
			String age=scan.nextLine();
			System.out.println("�������ַ");
			String address=scan.nextLine();
			//����ѧ��
			Student s= new Student();
			s.setId(id);
			s.setName(name);
			s.setAge(age);
			s.setAddress(address);
//			�޸ļ����е�ѧ������
			list.set(index, s);
			System.out.println("�޸ĳɹ�");
		}
	}
//	����ѧ����Ϣ
	public static void addStudent(ArrayList<Student> list){
		Scanner scan=new Scanner(System.in);
		String id;
		while(true){
			System.out.println("������ѧ����ѧ�ţ�");
			id=scan.nextLine();
			boolean flag=false;
			for(int i=0;i<list.size();i++){
				Student s=list.get(i);
				if(id.equals(s.getId())){
					flag=true;
					break;
				}
			}
			if(flag){
				System.out.println("�������ѧ���ѱ�ռ������������");
			}else{
				break;
			}
		}
			Student s=new Student();
			System.out.println("��������������");
			String name=scan.nextLine();
			System.out.println("���������������");
			String age=scan.nextLine();
			System.out.println("���������ַ��");
			String address=scan.nextLine();
			s.setId(id);
			s.setName(name);
			s.setAge(age);
			s.setAddress(address);
			list.add(s);	
		System.out.println("��ӳɹ�");
	}
//	ɾ��ѧ����Ϣ
	public static void removeStudent(ArrayList<Student> list){
		Scanner scan=new Scanner(System.in);
		System.out.println("����������Ҫɾ����ѧ��");
		String id=scan.nextLine();
		int index=-1;//һ��������־
		for(int i=0;i<list.size();i++){
			Student s=list.get(i);
 			if(id.equals(s.getId())){
// 				���id�������i��ֵ����list��remove������
 				index=i;
 				break;
 			}
		}
		if(index==-1){
			System.out.println("û�����ѧ������Ϣ");
		}else{
			list.remove(index);
			System.out.println("ɾ���ɹ�");
		}
		
	}
//	��ѯѧ����Ϣ��
	public static void findAllStudent(ArrayList<Student> list){
//		�������Ϊ0����û��ѧ����Ϣ��
		if(list.size()==0){
			System.out.println("û��ѧ����Ϣ���Բ�ѯ");
			return;
		}
		System.out.println("ѧ��\t\t����\t����\t��ַ ");
		Iterator<Student> it=list.iterator();
		while(it.hasNext()){
			Student s=it.next();
		System.out.println(s.getId()+"\t"+s.getName()+"\t"+s.getAge()+"\t"+s.getAddress());
		}
	}

}
