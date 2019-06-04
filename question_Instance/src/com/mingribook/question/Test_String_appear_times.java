package com.mingribook.question;

public class Test_String_appear_times {
//判断字符串“mingrikejijavabu”中i字符出现的次数：
//	在这个问题中主要用charAt(int Index);方法来获取指定位置的字符；
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
		System.out.println("字符j出现的次数"+count1);
	}

}
