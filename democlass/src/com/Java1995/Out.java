package com.Java1995;

public class Out {
//�ڲ���
	private  int age=12;//�ⲿ�����
  class In{
		private int age=13;//�ڲ������
		public void printf(){
			int age=14;//�ֲ�����
			System.out.println("�ⲿ�������"+Out.this.age);
			System.out.println("�ڲ�������"+this.age);
			System.out.println("�ֲ�������"+age);	
		}
	}
	public static void  main(String []args){
//	�����ڲ���ķ�ʽ1
		Out.In in=new Out().new In();
		in.printf();
//		Ҳ���������·���ֱ�ӵ����ڲ���ķ���2
		Out out=new Out();
		Out.In inn=out.new In();
		inn.printf();
	}
}
