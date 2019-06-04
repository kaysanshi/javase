package com.zcib;

public class TestPeople {

	public static void main(String[] args) {
		ChinaPeople p=new ChinaPeople();
		AmericanPeople p1=new AmericanPeople();
		System.out.println("///中国人的特性：：");
		p.averageHeight();
		p.averageWeight();
		p.speakHello();
		p.chinaGongfu();
		p.setSkin("黄色皮肤");
		System.out.println("肤色:"+p.getSkin());
		p.setEyecolor("黑色");
		System.out.println("眼睛的颜色："+p.getEyecolor());
		System.out.println("///美国人的特性：：");
		p1.americanBoxing();
		p1.averageHeight();
		p1.averageWeight();
		p1.speakHello();
		p1.setSkin("白色皮肤");
		System.out.println("肤色:"+p1.getSkin());
		p1.setEyecolor("蓝色");
		System.out.println("眼睛的颜色："+p1.getEyecolor());
	}

}
