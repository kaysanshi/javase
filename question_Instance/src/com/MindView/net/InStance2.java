package com.MindView.net;

/*
 * page77:����һ���ಢ�Ұ���δ��ʼ����String���ã���֤Ϊ�գ�
 * ������һ�����ʱ����ʱ�ͱ���ʼ����String���Լ���һ��ͨ����������ʼ���Ƚϲ�ͬ��
 */
public class InStance2 {
//	��ʼ����ʵ������new�������һ��ʱ�ͱ���ʼ���ˣ����Զ����ù�������
	String s;
	InStance2(){
//		s="hello everybody";//��֤������Ҫ�õ���
		System.out.println(s);
	}
	String s1="hello java";//���ڹ��������Ѿ���ʼ��
	public static void main(String[] args) {
		InStance2 sr=new InStance2();
		System.out.println(sr.s);
		System.out.println(sr.s1);
	}

}
