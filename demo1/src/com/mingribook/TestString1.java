package com.mingribook;

import java.util.StringTokenizer;//包声明

public class TestString1 {

	public static void main(String[] args) {
		String s=" we are students";
//	获取指定字符索引的位置用：对象名.indexOf("substr");x为要索引的字符（对象）索因对象字符下标从0开始；
		System.out.println("字符中的e在哪个位置："+s.indexOf("e"));
//		对象名.lastIndexOf("substr");substr为要搜索的对象,要索引出此对象的最后一次出现的位置
		System.out.println("字符串中e出现的最后一次的位置："+s.lastIndexOf("e"));
//		获取指定索引位置的字符：对象名.charAt(int index)index为整形值用于返回字符的下标；
		System.out.println("字符串中第7个字符是："+s.charAt(7));
//		去除字符串中的所有空格1；对象名.StringTokenizer(String str,String delim)delim为从字符串str中
//		去除的字符串.还可以用 2 ：对象名.replaceAll(String regex, String replacement)
//		regex为想要被替换的字符串，replacement为新字符串用来替换各个regex;
		StringTokenizer st=new StringTokenizer(s," ");//使用空格来分分割字符串
		StringBuffer sb=new StringBuffer();//定义字符串的缓存对象
		while (st.hasMoreTokens()){
			@SuppressWarnings("unused")
			int i=0;
			i++;
			sb.append(st.nextToken());//向字符串生成器中增加内容；
		}
		System.out.println("去掉字符串中的所用空格之后的字符串是：");
		System.out.println(sb.toString());
//		2所替换的字符要用""引起来
		s=s.replaceAll(" " , "");
		System.out.println("去除空格后的字符串："+s);
//		字符串的替换：对象名.replace(String regex, String replacement)
//		和替换空格方式一样所替换的字符要用""引起来
		String news=s.replace("students", "yang man");
		System.out.println("字符串替换后的串是："+news);
//		字符串中只替换第一个出现的字符：对象名.replaceFirst(String regex, String replacement)
//		此替换只替换第一个字符所替换的字符要用""引起来
		s=s.replaceFirst("we", "you");
		System.out.println("第一个字符替换后为："+s);
	}

}
