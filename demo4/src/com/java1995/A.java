package com.java1995;

public class A {
	A(){
		System.out.println("�����޲ε�A()");
	}
	A(int i){
		System.out.println("�����вε�A()");
	}
}
class B extends A{
		B(){
			System.out.println("�����޲ε�B()");
		}
		B(int i){
			super(i);//�ڴ���super�ؼ��������ø������вεĹ��췽��
			System.out.println("�����вε�B()");
		}
	}
class C extends B{
		C(){
			super();//�˾�ΪĬ�ϵĵ��ò���Ҫ���ֳ������������Զ����ϣ�
			System.out.println("�����޲ε�C()");
		}
		C(int i){
			super(i);
			System.out.println("�����޲ε�C()");
		}
	}

