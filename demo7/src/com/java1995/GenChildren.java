package com.java1995;

public class GenChildren<T> extends GenParents<T> {
//	�������в����б������������еĲ������ͣ�����Ĳ������͵Ĳ����б�����ж��
		 GenChildren(T t){
			 super(t);
		System.out.println("��������Ĺ��췽��");
	}
//		 ������д����ķ���
		public void Print(){
			System.out.println("�����еķ���");
		}

}
