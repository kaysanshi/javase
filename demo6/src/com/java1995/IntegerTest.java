package com.java1995;

public class IntegerTest {
//integer ��װ��
	public static void main(String[] args) {
//Integer���е������Сֵ
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		Integer p=new Integer("123");
		System.out.println("�� Integer��ֵ��Ϊdouble :"+p.doubleValue());
		System.out.println("�� Integer��ֵ��Ϊ int :"+p.intValue());
//		parseInt(String s) 
//		���ַ�����������Ϊ�����ŵ�ʮ����������
		int i=Integer.parseInt("123");
		System.out.println(i);
		int s=10;
		System.out.println("��ʮ����ת��Ϊ�����ƣ�"+Integer.toBinaryString(s));
		System.out.println("���ַ�����ʾΪ�޷���ʮ����ֵ��"+Integer.toUnsignedString(12));
//	������в����Զ�װ�������
		Integer q2=new Integer("123");
		int q1=q2;
		System.out.println(q1);//����
//		װ��
		int i1=4;
		Integer i2=i1;
		System.out.println(i2);

	}

}
