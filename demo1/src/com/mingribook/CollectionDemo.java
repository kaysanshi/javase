package com.mingribook;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CollectionDemo {
/*
 * ���϶�������������Ԫ��
 */
	public static void main(String[] args) {
		String a="A",b="B",c="C",d="d",e="e";//�����ַ�����
		List<String>list=new LinkedList<String>();//�����ַ����еļ���
//		�򼯺������Ԫ��
		list.add(a);
		list.add(b);
		list.add(c);
//		����������Ȼ����������ʽһ��
		Iterator<String> f=list.iterator();
		while(f.hasNext()){
			System.out.print(f.next()+" ");
		}
//		�޸����е�����list.set(����ֵ���޸ĵ�ֵ)
//		add(String item, int index) 
//		��ָ������Ŀ��ӵ�������ָʾ��λ�õĹ����б��С� 
		list.set(1, d);
		list.set(2, e);
//		���������ʽ����
		Iterator<String> it=list.iterator();
		while(it.hasNext()){
			String s=(String)it.next();
			System.out.print(s+" ");
		}
//		��ʽ�������ٴα���ʱ�Ա�Ϊ�޸ĺ��Ԫ��
		for(Iterator<String> it1=list.iterator();it1.hasNext();){
			String s1=(String)it1.next();
			System.out.print(s1+" ");
		}
	}

}
