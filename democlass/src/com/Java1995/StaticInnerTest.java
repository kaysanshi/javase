package com.Java1995;

public class StaticInnerTest {
	public static void main(String[] args) {
//		��̬�ڲ���ĵ��÷�ʽ
		StaticInner.In in=new StaticInner.In();
		in.print();
//		���þ�̬�ڲ���ľ�̬������
		StaticInner.In.put();
//		Ϊ��̬�ڲ����еľ�̬������ֵ
		StaticInner.In.name="10";
//		���þ�̬�ڲ���ľ�̬������
		StaticInner.In.print1(StaticInner.In.name);

	}

}
