package com.mingribook;

import java.util.Date;

public class GetTime {
//����ϵͳ�ڲ���ʱ���ʽ��
	public static void main(String[] args) {
		Date date=new Date();
		System.out.println("Ĭ��ʱ��ĸ�ʽ��"+date);
		System.out.println("��λ24Сʱ�Ƶ�Сʱ��"+String.format("%tH", date));
		System.out.println("��λ12Сʱ�Ƶ�Сʱ��"+String.format("%tl", date));
		System.out.println("24�Ƶ�Сʱ��"+String.format("%tk", date));
		System.out.println("12�Ƶ�Сʱ��"+String.format("%tl", date));
		System.out.println("��λСʱ�еķ��ӣ�"+String.format("%tM", date));
		System.out.println("��λ���ӵ����룺"+String.format("%tS", date));
		System.out.println("��ʾʱ����д��ʽ��"+String.format("%tZ", date));
		System.out.println("���绹�����磺"+String.format("%tp", date));
		System.out.println("����ʱ����ϸ�ʽ����");
		System.out.println("Ĭ��ʱ��ĸ�ʽ��"+date);
		System.out.println("24Сʱ�Ƶ�ʱ�䣬����ʽ��ΪСʱ�ͷ��ӣ�"+String.format("%tR", date));
		System.out.println("24Сʱ�Ƶ�ʱ�䣬����ʽ��ΪСʱ�ͷ��ӣ���"+String.format("%tT", date));
		System.out.println("12�Ƶ�ʱ�䣺"+String.format("%tr", date));
		System.out.println("���ڱ���ʽ����"+String.format("%tD", date));
		System.out.println("ISO 8601��ʽ���������ڣ�"+String.format("%tF", date));
		System.out.println("���ں�ʱ���ʽ��Ϊ��"+String.format("%tc", date));
	}

}
