package com.zcib;

public class Testteacher {
//	继承的实现使用子类new处对象，在子类中继承了所有父类的属性，方法的实现；
//	在对子类测试时要用以下形式；

	public static void main(String[] args) {
		Teacher p=new Teacher();
		p.develop ="哈佛";
		System.out.println(p.getDevelop(p.develop) );
		 System.out.println(p.getName("安红妮"));
		System.out.println(p.getDevelop("fast"));
		p.getSex();
		p.add="henan";
		System.out.println(p.getadd(p.add) );
		System.out.println(p.name );
	}

}
