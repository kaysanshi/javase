package com.MindView.net;
/*
 * ����������ʾ��p83��
 */


public class Instance3 {
	//�޲εĹ�������
	Instance3(){
		System.out.println("�����޲εĹ���������new��ʱ��Ĭ�ϵ��õ�");
	}
//	���ع�����
	 Instance3(String s){
		System.out.println(s);
	}

	public static void main(String[] args) {
//	�������ص�ʱ�����������Ϊ��Ҫ�����Լ��ù����䲻��ȥ����Ĭ�ϵĹ�������
		Instance3 i=new Instance3();
//		�Ӷ���ֻ�����Լ��Ĺ�����
		Instance3 i3=new Instance3("hello");
//		һ�·�ʽ�ᱨ��
//		Scanner scan=new Scanner(System.in);
//		String s=scan.nextLine();
//		i3.InStance3(s);
	}

}
