package com.mingribook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;

public class ListIteratorDemo {
	/*
	 * Iterator�ӿ��е�������ʹ��
	 */
	public static void main(String[] args) {
//		�������ݶ�������ΪInteger�ļ���
		ArrayList<Integer>array=new ArrayList<Integer>();
//		ʹ��Collections���еĹ��߷���addAll()���Ԫ��
		Collections.addAll(array, 1,2,3,4,5);
		System.out.println("�����е�Ԫ�أ�"+array);
//		ʹ���޲εĹ��췽�����ListIterator����
		ListIterator<Integer> iterator=array.listIterator();
//		���ڳ�ʼλ���ж��Ƿ�����һ��Ԫ��
		boolean hasNext=iterator.hasNext();
		System.out.println("�ж��Ƿ�����һ��Ԫ�أ�"+hasNext);
		System.out.println("�ж��Ƿ���ǰһ��Ԫ�أ�"+iterator.hasPrevious());
		System.out.println("��ü����е���һ��Ԫ�أ�"+iterator.next());
		System.out.println("��ü����е���һ��Ԫ�ص�������"+iterator.nextIndex());
		System.out.println("��ü����е�ǰһ��Ԫ�أ�"+iterator.previous());
		System.out.println("��ü����е�ǰһ��Ԫ�ص�������"+iterator.previousIndex());
		iterator.add(7);
		System.out.println(array);
		iterator.next();//�����һ��Ԫ��
		iterator.set(12);//�ı��õ�Ԫ��ֵ
		System.out.println("�޸ĺ�ģ�"+array);
		iterator.remove();
		System.out.println("�ٴ��޸ĺ�ģ�"+array);
//		�õ����������
		for(Iterator<Integer>it=array.iterator();it.hasNext();){
			System.out.print(it.next()+" ");
		}
//		������ʽ��
		Iterator<Integer>it=array.iterator();
		while(it.hasNext()){
			System.out.print(it.next()+" ");
		}
	}

}
