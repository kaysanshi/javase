package com.mingribook;

public class BuilderString {

	public static void main(String[] args) {
		System.out.println("测试追加到生成器的方法：");
		String s="good";//声明字符串
		StringBuilder builder=new StringBuilder();//构造字符串的生成器
		builder.append(s);//将s的值增加字符串生成器中
		System.out.println(builder);
		StringBuffer buffer=new StringBuffer("Sunday");//创建内容的字符串缓存；
		StringBuilder str=new StringBuilder();//够造字符串生成器
		str.append(buffer);//将缓存的内容追加代字符串生成器中；
		System.out.println(str);
		String s1="int";
		String s2="ser";
		StringBuilder st=new StringBuilder(s1);//将s1追加到字符串生成器
		st.insert(2, s2);//向索引值为2处添加s2;
		System.out.println(st);
		StringBuilder p=new StringBuilder("studentman");
		StringBuilder p1=p.delete(4, 6);//含前不含后,删除后原来的字符串会变被覆盖
		System.out.println(p1+","+p);//删除后原来的字符串会变被覆盖
		String p2=p.toString();
		System.out.println(p2);
	}

}
