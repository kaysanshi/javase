package com.mingribook.question;

import java.util.StringTokenizer;

public class Test_String_remove {
//ȥ���ո���forѭ������ʵ��
	public static void main(String[] args) {
		String s="java is very oop";
		System.out.println("Java�б��е�ȥ������1��"+s.replaceAll(" ",""));
		StringTokenizer st=new StringTokenizer(s," ");//s��Ҫȥ���ո���ַ�������һ����Ҫȥ�����ַ�����
		StringBuffer sb=new StringBuffer();
		@SuppressWarnings("unused")
		int i=1;
		while(st.hasMoreTokens()){
			i++;
			sb.append(st.nextToken());
		}
		System.out.println("Java�б��е�ȥ������2��"+sb.toString());
		System.out.println("������forѭ����ʵ��3��");
		String s1="java is very oop";
		for(int j=0;j<s1.length();j++){
			if(s1.charAt(j)!=' '){
				System.out.print(s1.charAt(j));
			}
			
		}
		
	}

}
