package com.java1995;

public class test {

	public static void main(String[] args) {
			Tiger p=new Tiger();
			p.breath();
			p.eat();
			p.run();
			p.setName("�ϻ�");
			p.setSkin("���ɫ");
			p.setLeghtcount(4);
			System.out.println(p.getName()+","+p.getSkin()+","+p.getLeghtcount()+"����");
			Sheep s=new Sheep();
			s.breath();
			s.eat();
			s.clamp();
			s.setName("ɽ��");
			s.setSkin("��ɫ");
			s.setLeghtcount(4);
			System.out.println(s.getName()+","+s.getSkin()+","+s.getLeghtcount()+"����");
	}
}
