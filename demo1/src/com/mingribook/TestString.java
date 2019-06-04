package com.mingribook;

public abstract class TestString {

	public static void main(String[] args) {
		System.out.println("字符串的替换的实现：");
		String s="bad bad study";
		String str=s.replace("bad", "good");
		System.out.println("字符串的替换后："+str);
		String str1=s.replaceFirst("bad", "good");
		System.out.println("替换第一个字符串后："+str1);
		System.out.println("下面进行的是判断字符串是否相等：：");
		String st1=new String("I am a student");
		String st2=new String("I am a student");
		String st3=new String("I AM A STUDENT");
		String st4=st1;
		boolean b1=(st1==st2);//内存位置的比较
		boolean b2=(st1==st4);
		boolean b3=st1.equals(st2);
		boolean b4=st1.equals(st3);//判断比较区分大小写
		boolean b5=st1.equalsIgnoreCase(st2);//判断比较不区分大小写
		boolean b6=st1.equalsIgnoreCase(st3);//判断比较不区分大小写
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
		System.out.println(b4);
		System.out.println(b5);
		System.out.println(b6);
		System.out.println("下面判断字符串开头与结尾：");
		String num1="2215203";
		String num2="5056998";
		boolean p1=num1.startsWith("22");//判断是否以这个字符开头
		boolean p2=num1.endsWith("03");//判断是否以这个字符结束 布尔类型
		boolean p3=num1.endsWith("54");
		boolean p4=num2.startsWith("50");
		boolean p5=num2.endsWith("98");
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		System.out.println(p4);
		System.out.println(p5);
		System.out.println("下面对字母的大小写的转换：");
		String st=new String("123 abc DBH");
		String s1=st.toLowerCase();//转换为小写的方法
		String s2=st.toUpperCase();//转换为大写的方法
		System.out.println("转换为小写后："+s1);
		System.out.println("转换为大写后："+s2);
		System.out.println("下面进行字符串的分割：：：");
		String b=new String("abc,def,ghi,gkl");
		String[] arr=b.split(",");//分割字符串的要求分割
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
		System.out.println("按分割字符部分分割：");
		String[] arr1=b.split(",", 2);//分割字符串的按部分分割
		for(int i=0;i<arr1.length;i++){
			System.out.println(arr1[i]);
		}
	}

}
