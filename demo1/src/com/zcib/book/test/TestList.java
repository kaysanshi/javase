package com.zcib.book.test;

import java.util.ArrayList;
import java.util.Iterator;
public class TestList {
	public static void main(String[] args) {
		ArrayList<String> name=new ArrayList<String>();
		name.add("����");
		name.add("����");
		name.add("����");
		name.add("����");
		name.add("����");
		for(int i=0;i<name.size();i++){
			System.out.println(name.get(i));
		}
//		�õ���������
		System.out.println();
		for(Iterator<String> it=name.iterator(); it.hasNext();){
			System.out.println(it.next());
		}
		System.out.println("���ϵĴ�С��"+name.size());//��С��
		
		System.out.println("ɾ��������Ԫ�غ�");
//		����forѭ��ɾ���Ժ�δ�������ĸı��ĳ��ȣ�����Ҫ��remove()������
		for(int i=0;i<name.size();i++){
			if(i!=2){
				System.out.println(name.get(i));
			}
		}
		System.out.println("ɾ����Ԫ�أ�"+name.get(2));
		name.remove(2);//ȥ��������Ԫ��
		System.out.println("ɾ���󼯺ϵĳ��ȣ�"+name.size());
		System.out.println("ɾ��������Ԫ�غ��õ�����Ԫ�أ�"+name.get(2));
	}
}