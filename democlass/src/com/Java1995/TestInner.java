package com.Java1995;

public class TestInner {
	public static void main(String[] args) {
//	�����ڲ������ʵ�ָ���ͽӿڵĵ��ã�
		Out1 out=new Out1(){
			@Override
			public void show() {
					System.out.println("���������ڲ����ʹ��");
			}
			
		};
		out.show();
//		�ڴ˵��ø���Ӧ��ε������������ڲ������ʽ������
//		Parents p=new Parents(){
//			
//			public void eat(){
//				
//			}
//		};
	}
	
//	�ӿ�
	interface Out1{
		public void show();
	}
	class Out2 implements Out1{

		@Override
		public void show() {
			// TODO Auto-generated method stub
		}
		
	}
//	����һ������
	class Parents{
		public void eat(){
			System.out.println("�����еķ�����ʵ��");
		}
	}
	class Chirlden extends Parents{}
}
