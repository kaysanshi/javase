package com.java1995;

public class Print {
	public void getPrint(String name,int MathScore,int EnglishScore,int ChineseScore ){
		System.out.println(name+"的数学成绩："+MathScore);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(name+"的英语成绩："+EnglishScore);
		System.out.println(name+"的语文成绩："+ChineseScore);
	}

}
