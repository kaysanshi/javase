package com.zcib.job;

public class TestString {
//	1、定义一个字符串“ 我爱学Java，Java很好学，对其进行如下操作：
//	1）打印字符个数
//	2）打印最后一个字符的位置
//	3）将字符串转为大写
//	4）将字符串转为小写
//	5）打印从第3字符开始的所有字符
//	6）打印从第5至第9个字符
//	7）把所有的'学'替换为'练'
//	8）把第一个'学'替换为'练'：
//	9）打印第一次出现'Java'的位置为
//	10）打印最后一次出现'Java'的位置
//	 
//	11）打印当前字符串值是否为'我爱学'
//	12）打印去掉前后空白内容
//	13）打印是否以'我爱'开始
//	14）打印是否以'好学'结束


	public static void main(String[] args) {
		String s=" 我爱学Java,Java很好学";
		System.out.println("字符个数:"+s.length());
		System.out.println("最后一个字符的位置:"+s.lastIndexOf("学"));
		System.out.println("将字符串转为大写:"+s.toUpperCase());
		System.out.println("将字符串转为小写:"+s.toLowerCase());
		System.out.println("从第3字符开始的所有字符:"+s.substring(3));
		System.out.println("打印从第5至第9个字符:"+s.substring(5, 9));
		System.out.println("把所有的'学'替换为'练':"+s.replaceAll("学", "练"));
		System.out.println("把第一个'学'替换为'练'："+s.replaceFirst("学", "练"));
		System.out.println("第一次出现'Java'的位置为："+s.indexOf("Java"));
		System.out.println("最后一次出现'Java'的位置为："+s.lastIndexOf("Java"));
		System.out.println("当前字符串值是否为'我爱学':"+s.equals("我爱学"));
		System.out.println("打印去掉前后空白内容:"+s.replaceAll(" ", ""));
		System.out.println("打印是否以'我爱'开始:"+s.startsWith("我爱"));
		System.out.println("是否以'好学'结束："+s.endsWith("好学"));
	}

}
