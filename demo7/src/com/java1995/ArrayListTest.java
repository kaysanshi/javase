package com.java1995;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListTest {

	public static void main(String[] args) {
		 ArrayList<String> all=new ArrayList<String>();
		 all.add("a");
		 all.add("b");
		 all.add("c");
		 System.out.println("��С"+all.size());
		 System.out.println(all);
//		 ����
		 all.add(0, "one");
		 all.add("M");
		 System.out.println(all);
//		�޸�
		 all.set(0,"first");
		 System.out.println(all);
//		 ɾ��
		 all.remove(2);
		 System.out.println(all);
//		 ����
		 for(int i=0;i<all.size();i++){
			 System.out.print(all.get(i)+" ");
		 }
		 //
		 System.out.println();
		 for(String s:all){
			 
			 System.out.print(s+" ");
		 }
		 //
		 System.out.println();
		 Iterator<String> it=all.iterator();
		 while(it.hasNext()){
			 System.out.print(it.next()+" ");
		 }
		 System.out.println();
		 System.out.println("���齻����");
//		 �������ϵĽ���
		 String[] s1=new String[all.size()];
		 s1=all.toArray(s1);
		 for(String s:all){
			 System.out.print(s+" ");
		 }
		 System.out.println();
//			���췽�� ���д�ֵ
		 System.out.println("���췽����ֵ��");
		 ArrayList<String> all1=new ArrayList<String>(all);
		 System.out.println(all1);
		 System.out.println(all1.equals(all));
//		 
		 //���ƴ�С������ ��Ϊ��������
		 ArrayList<String> all3=new ArrayList<String>(3);
		 //addAll��������һ������
		 all3.addAll(all);
		 System.out.println(all3);
	}

}
