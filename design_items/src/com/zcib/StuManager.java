package com.zcib;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class StuManager {
	private List<Student>list;
//	   ���췽��
//	���������еķ�����ʹ��
	public StuManager(List<Student>list){
		this.setList(list);
	}
//	getset����
	public List<Student> getList() {
		return list;
	}
	public void setList(List<Student> list) {
		this.list = list;   
	}
	

//	ɾ��ѧ��
	public Student Delete(List<Student>  list){
//		System.out.println(list.size());
		Scanner scan=new Scanner(System.in);
		String number=scan.next();
		Iterator<Student> it = list.iterator();  
        while (it.hasNext()) { 
        	Student s=it.next();
            if(s.getNumber().equals(number)){  
            	it.remove();  
            }
        }
        System.out.println("ɾ�������µ�ѧ����Ϣ");
        System.out.println(list.toString());
		return null;
	}
//	����ѧ����ѧ��������ѧ����Ϣ
	public Student Search(List<Student> list){
		int flag=0;//����һ����־
		Scanner scan=new Scanner(System.in);
		System.out.println("����������Ҫ��ѯ��ѧ��");
		String number=scan.nextLine();
		for(Iterator<Student> it=list.iterator();it.hasNext();){
			Student stu=it.next();
			if(stu.getNumber().equals(number)){
					System.out.println(stu.toString());
			}else{
				flag++;
			}
		}
		if(flag==list.size()){//��Ѱ�����ĩβʱ��
			System.out.println("û�����ѧ������Ϣ����");
		}
		return null;
	}
//	��������ѯ��
	public Student SearchName(List<Student> list){
		int flag=0;
		Scanner scan=new Scanner(System.in);
		System.out.println("����������Ҫ��ѯ������");
		String name=scan.nextLine();
		for(Iterator<Student> it=list.iterator();it.hasNext();){
			Student stu=it.next();
			if(stu.getName().equals(name)){
					System.out.println(stu.toString());
			}else{
				flag++;
			}
		}
		if(flag==list.size()){
			System.out.println("û�����ѧ������Ϣ����");
		}
		return null;
	}
//	����������������//������֪���ʵ������

//	����ѧ�Ż����������޸�
	public Student Modify(List<Student> list){
		int flag=0;
		Iterator<Student>  it=list.iterator();
		Scanner scan=new Scanner(System.in);
		System.out.println("����������ѧ��");
		String number=scan.nextLine();
		while(it.hasNext()){
			Student s=it.next();
			if(s.getNumber().equals(number)){
				System.out.println("�������µ�������");
				String name=scan.nextLine();
				s.setName(name);
				System.out.println("�������µĵ�ַ��");
				String address=scan.nextLine();
				s.setAddress(address);
				System.out.println("�µ�ϵ��");
				 String department=scan.nextLine();
				s.setDepartment(department);
				System.out.println("�������꼶��");
				String grade =scan.next();
				s.setGrade(grade);
				System.out.println("�������ܳɼ���");
				double score=scan.nextDouble();
				s.setScore(score);
//				System.out.println(s.toString());	
			}else{
				flag++;
			}
		}if(flag==list.size()){
			System.out.println("û�����ѧ������Ϣ");
		}
		
		return null;
	}
}
