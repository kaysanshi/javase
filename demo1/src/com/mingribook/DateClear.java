package com.mingribook;

import java.util.Date;
import java.util.Locale;

public class DateClear {
//����ϵͳ�ڲ��� һЩ��ʽ��
	public static void main(String[] args) {
		Date today=new Date();
		String a=String.format(Locale.US, "%tb", today);
		String b=String.format(Locale.US, "%tB", today);
		String c=String.format("%ta", today);//ָ�������е����ڼ��ļ��
		String d=String.format("%tA", today);//ָ�������е����ڼ���ȫ��
		String e=String.format("%tY", today);//��λ���
		String f=String.format("%ty", today);//��λ���
		String g=String.format("%tm", today);//�·�
		String h=String.format("%td", today);//һ�����еĵڼ���
		String i=String.format("%te", today);//һ�����е�ĳһ��
		String k=String.format("%tc", today);//����ȫ�������ں�ʱ��
		String l=String.format("%tj", today);//һ���еĵڼ���
		System.out.println("��ʽ������ַ�����Ӣ����д��"+a);
		System.out.println("��ʽ������ַ�����Ӣ��ȫд��"+b);
		System.out.println("�¸�ʽ������ַ���Ϊ���ڣ�"+c);
		System.out.println("��ʽ������ַ���Ϊ���ڣ�"+d);
		System.out.println("��ʽ������ַ���Ϊ4λ�����ֵ��"+e);
		System.out.println("��ʽ������ַ���Ϊ4λ�����ֵ��"+f);
		System.out.println("��ʽ������ַ���Ϊ2λ���·�ֵ��"+g);
		System.out.println("��ʽ������ַ���Ϊ2λ������ֵ��"+h);
		System.out.println("��ʽ������ַ���Ϊ1λ������ֵ��"+i);
		System.out.println("����ֵ��"+k);
		System.out.println("�����еĵڼ��죺"+l);
	}

}
