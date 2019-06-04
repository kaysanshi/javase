package com.java1995;

public class TestStaticVariable {
//声明类变量 测试类变量的默认值
	static boolean aBoolean;
	static char achar;//'\000'unicode编码
	static byte abyte;//00000000
	static short ashort;//00000000 0000000
	static int aint;
	static long along;
	static float afloat;
	static double adouble;
	public static void main(String[] args){
	System.out.println("aBoolean="+aBoolean);
	System.out.println("achar="+achar);
	System.out.println("abyte="+abyte);
	System.out.println("ashort="+ashort);
	System.out.println("aint="+aint);
	System.out.println("along="+along);
	System.out.println("afloat="+afloat);
	System.out.println("adouble="+adouble);
	}
}
