package com.zcib.job;

public class TestString {
//	1������һ���ַ����� �Ұ�ѧJava��Java�ܺ�ѧ������������²�����
//	1����ӡ�ַ�����
//	2����ӡ���һ���ַ���λ��
//	3�����ַ���תΪ��д
//	4�����ַ���תΪСд
//	5����ӡ�ӵ�3�ַ���ʼ�������ַ�
//	6����ӡ�ӵ�5����9���ַ�
//	7�������е�'ѧ'�滻Ϊ'��'
//	8���ѵ�һ��'ѧ'�滻Ϊ'��'��
//	9����ӡ��һ�γ���'Java'��λ��Ϊ
//	10����ӡ���һ�γ���'Java'��λ��
//	 
//	11����ӡ��ǰ�ַ���ֵ�Ƿ�Ϊ'�Ұ�ѧ'
//	12����ӡȥ��ǰ��հ�����
//	13����ӡ�Ƿ���'�Ұ�'��ʼ
//	14����ӡ�Ƿ���'��ѧ'����


	public static void main(String[] args) {
		String s=" �Ұ�ѧJava,Java�ܺ�ѧ";
		System.out.println("�ַ�����:"+s.length());
		System.out.println("���һ���ַ���λ��:"+s.lastIndexOf("ѧ"));
		System.out.println("���ַ���תΪ��д:"+s.toUpperCase());
		System.out.println("���ַ���תΪСд:"+s.toLowerCase());
		System.out.println("�ӵ�3�ַ���ʼ�������ַ�:"+s.substring(3));
		System.out.println("��ӡ�ӵ�5����9���ַ�:"+s.substring(5, 9));
		System.out.println("�����е�'ѧ'�滻Ϊ'��':"+s.replaceAll("ѧ", "��"));
		System.out.println("�ѵ�һ��'ѧ'�滻Ϊ'��'��"+s.replaceFirst("ѧ", "��"));
		System.out.println("��һ�γ���'Java'��λ��Ϊ��"+s.indexOf("Java"));
		System.out.println("���һ�γ���'Java'��λ��Ϊ��"+s.lastIndexOf("Java"));
		System.out.println("��ǰ�ַ���ֵ�Ƿ�Ϊ'�Ұ�ѧ':"+s.equals("�Ұ�ѧ"));
		System.out.println("��ӡȥ��ǰ��հ�����:"+s.replaceAll(" ", ""));
		System.out.println("��ӡ�Ƿ���'�Ұ�'��ʼ:"+s.startsWith("�Ұ�"));
		System.out.println("�Ƿ���'��ѧ'������"+s.endsWith("��ѧ"));
	}

}
