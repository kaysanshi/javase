package com.mingribook;

public class OutClass {
//	���������ⲿ��ʵ�����ڲ�������ñ���
	innerClass in=new innerClass();
	public void ouf(){
		System.out.println("�ⲿ���еķ����е����ڲ���ķ�����");
		in.inf();
	}
//	����һ���ڲ��ࣻ
	class innerClass{
		innerClass(){
			System.out.println("�����ڲ���Ĺ��췽����");
		}
		public void inf(){
			System.out.println("�����ڲ���ķ�����");
		}
		int y=0;
	}
//	�ⲿ�෽����
	public innerClass doit(){
		in.y=4;
		return new innerClass();
	}
	

	public static void main(String[] args) {
		OutClass out=new OutClass();
//		�ڲ���Ķ���ʵ���������������ⲿ����ⲿ���еķǾ�̬������ʵ�֣�
		OutClass.innerClass in=out.doit();

	}

}
