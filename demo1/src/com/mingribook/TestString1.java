package com.mingribook;

import java.util.StringTokenizer;//������

public class TestString1 {

	public static void main(String[] args) {
		String s=" we are students";
//	��ȡָ���ַ�������λ���ã�������.indexOf("substr");xΪҪ�������ַ���������������ַ��±��0��ʼ��
		System.out.println("�ַ��е�e���ĸ�λ�ã�"+s.indexOf("e"));
//		������.lastIndexOf("substr");substrΪҪ�����Ķ���,Ҫ�������˶�������һ�γ��ֵ�λ��
		System.out.println("�ַ�����e���ֵ����һ�ε�λ�ã�"+s.lastIndexOf("e"));
//		��ȡָ������λ�õ��ַ���������.charAt(int index)indexΪ����ֵ���ڷ����ַ����±ꣻ
		System.out.println("�ַ����е�7���ַ��ǣ�"+s.charAt(7));
//		ȥ���ַ����е����пո�1��������.StringTokenizer(String str,String delim)delimΪ���ַ���str��
//		ȥ�����ַ���.�������� 2 ��������.replaceAll(String regex, String replacement)
//		regexΪ��Ҫ���滻���ַ�����replacementΪ���ַ��������滻����regex;
		StringTokenizer st=new StringTokenizer(s," ");//ʹ�ÿո����ַָ��ַ���
		StringBuffer sb=new StringBuffer();//�����ַ����Ļ������
		while (st.hasMoreTokens()){
			@SuppressWarnings("unused")
			int i=0;
			i++;
			sb.append(st.nextToken());//���ַ������������������ݣ�
		}
		System.out.println("ȥ���ַ����е����ÿո�֮����ַ����ǣ�");
		System.out.println(sb.toString());
//		2���滻���ַ�Ҫ��""������
		s=s.replaceAll(" " , "");
		System.out.println("ȥ���ո����ַ�����"+s);
//		�ַ������滻��������.replace(String regex, String replacement)
//		���滻�ո�ʽһ�����滻���ַ�Ҫ��""������
		String news=s.replace("students", "yang man");
		System.out.println("�ַ����滻��Ĵ��ǣ�"+news);
//		�ַ�����ֻ�滻��һ�����ֵ��ַ���������.replaceFirst(String regex, String replacement)
//		���滻ֻ�滻��һ���ַ����滻���ַ�Ҫ��""������
		s=s.replaceFirst("we", "you");
		System.out.println("��һ���ַ��滻��Ϊ��"+s);
	}

}