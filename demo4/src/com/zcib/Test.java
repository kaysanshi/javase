package com.zcib;

public class Test {

	public static void main(String[] args) {
		Henan p=new Henan();
		p.eat();
		p.henanplace();
		p.placeChiese();
		p.speakChinese();
		p.henanSpeak();
		p.setName("С��");
		p.setAge("20");
		p.setSex("��");
		System.out.println(p.getName()+p.getAge()+p.getSex());
		p.placeChiese();
		p.henanSpeak();
	}

}
