package com.mingribook.question;

public class Test_String_appear_times {
//�ж��ַ�����mingrikejijavabu����i�ַ����ֵĴ�����
//	�������������Ҫ��charAt(int Index);��������ȡָ��λ�õ��ַ���
	public static void main(String[] args) {
		String s="mingrikejijavabu";
			int count=0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=='i'){
				count++;
				}
			}
		System.out.println(count);
		int count1=0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=='j'){
				count1++;
			}
		}
		System.out.println("�ַ�j���ֵĴ���"+count1);
	}

}
