package com.java1995;

public class test {

	public static void main(String[] args) {
			Tiger p=new Tiger();
			p.breath();
			p.eat();
			p.run();
			p.setName("老虎");
			p.setSkin("金黄色");
			p.setLeghtcount(4);
			System.out.println(p.getName()+","+p.getSkin()+","+p.getLeghtcount()+"条腿");
			Sheep s=new Sheep();
			s.breath();
			s.eat();
			s.clamp();
			s.setName("山羊");
			s.setSkin("白色");
			s.setLeghtcount(4);
			System.out.println(s.getName()+","+s.getSkin()+","+s.getLeghtcount()+"条腿");
	}
}
