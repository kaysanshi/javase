package com.java1995;

public class GenParents<T> {
//	������֮��ļ̳���ʾ
		//��������޲ι��죻
	GenParents(){
		System.out.println("���Ǹ�����޲ι��췽����");
	}
//����
	T t;
	GenParents(T t1){
		this.t=t1;
		System.out.println("���Ǹ�����вι������÷���");
		System.out.println("T�����ͣ�"+t.getClass().getName());
	}
//	�����еķ���
	public void Print(){
		System.out.println("�����еķ���");
	}
}
