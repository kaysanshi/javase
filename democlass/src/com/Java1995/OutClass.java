package com.Java1995;

public class OutClass {
//�ڲ���Ĳ���
	public int i=10;
	private String out_string="out String";
	public void getInner(){
//�ⲿ���еķ��������ڲ��ࣻ�ⲿ�ഴ���ڲ������
		Inner in=new Inner();
		System.out.println("�ⲿ���еķ�������;");
		in.put();	
	}
//	�����ڲ��ࣻ��Ա�ڲ����൱���ⲿ��ĳ�Ա�������߷�����
	class Inner{
		public void put() {
			System.out.println("�����ڲ���ķ���");
			System.out.println(out_string);
		}
	}
}
