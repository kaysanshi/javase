package com.mingribook;

public class BuilderString {

	public static void main(String[] args) {
		System.out.println("����׷�ӵ��������ķ�����");
		String s="good";//�����ַ���
		StringBuilder builder=new StringBuilder();//�����ַ�����������
		builder.append(s);//��s��ֵ�����ַ�����������
		System.out.println(builder);
		StringBuffer buffer=new StringBuffer("Sunday");//�������ݵ��ַ������棻
		StringBuilder str=new StringBuilder();//�����ַ���������
		str.append(buffer);//�����������׷�Ӵ��ַ����������У�
		System.out.println(str);
		String s1="int";
		String s2="ser";
		StringBuilder st=new StringBuilder(s1);//��s1׷�ӵ��ַ���������
		st.insert(2, s2);//������ֵΪ2�����s2;
		System.out.println(st);
		StringBuilder p=new StringBuilder("studentman");
		StringBuilder p1=p.delete(4, 6);//��ǰ������,ɾ����ԭ�����ַ�����䱻����
		System.out.println(p1+","+p);//ɾ����ԭ�����ַ�����䱻����
		String p2=p.toString();
		System.out.println(p2);
	}

}
