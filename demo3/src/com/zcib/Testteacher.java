package com.zcib;

public class Testteacher {
//	�̳е�ʵ��ʹ������new�������������м̳������и�������ԣ�������ʵ�֣�
//	�ڶ��������ʱҪ��������ʽ��

	public static void main(String[] args) {
		Teacher p=new Teacher();
		p.develop ="����";
		System.out.println(p.getDevelop(p.develop) );
		 System.out.println(p.getName("������"));
		System.out.println(p.getDevelop("fast"));
		p.getSex();
		p.add="henan";
		System.out.println(p.getadd(p.add) );
		System.out.println(p.name );
	}

}
