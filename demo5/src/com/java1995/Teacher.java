package com.java1995;

public class Teacher implements Runnable {
//	在这里掉用了getPrint方法但是实现了一个多线程；
	Print p=new Print();
	private String name;
	private	int MathScore,EnglishScore,ChineseScore;
//	含参构造方法：
	Teacher(Print p,String name,int MathScore,int EnglishScore,int ChineseScore){
		this.p=p;
		this.name=name;
		this.MathScore=MathScore;
		this.EnglishScore=MathScore;
		this.ChineseScore=ChineseScore;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMathScore() {
		return MathScore;
	}
	public void setMathScore(int mathScore) {
		MathScore = mathScore;
	}
	public int getEnglishScore() {
		return EnglishScore;
	}
	public void setEnglishScore(int englishScore) {
		EnglishScore = englishScore;
	}
	public int getChineseScore() {
		return ChineseScore;
	}
	public void setChineseScore(int chineseScore) {
		ChineseScore = chineseScore;
	}
	@Override
	public void run() {
		p.getPrint(name, MathScore, EnglishScore, ChineseScore);
		
	}

}
