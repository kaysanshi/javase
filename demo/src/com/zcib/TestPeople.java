package com.zcib;

public class TestPeople {

	public static void main(String[] args) {
		ChinaPeople p=new ChinaPeople();
		AmericanPeople p1=new AmericanPeople();
		System.out.println("///�й��˵����ԣ���");
		p.averageHeight();
		p.averageWeight();
		p.speakHello();
		p.chinaGongfu();
		p.setSkin("��ɫƤ��");
		System.out.println("��ɫ:"+p.getSkin());
		p.setEyecolor("��ɫ");
		System.out.println("�۾�����ɫ��"+p.getEyecolor());
		System.out.println("///�����˵����ԣ���");
		p1.americanBoxing();
		p1.averageHeight();
		p1.averageWeight();
		p1.speakHello();
		p1.setSkin("��ɫƤ��");
		System.out.println("��ɫ:"+p1.getSkin());
		p1.setEyecolor("��ɫ");
		System.out.println("�۾�����ɫ��"+p1.getEyecolor());
	}

}
