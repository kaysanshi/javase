package com.lixinghua;


public class Demotest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PetShop pShop=new PetShop(3);
		pShop.add(new Cat("��è", "��ɫ", 2));
		pShop.add(new Dog("�ڹ�", "��ɫ", 1));
		pShop.add(new Cat("��è", "�ڻ�", 3));
		Print(pShop.search("��"));

	}

	private static void Print(Pet []p) {
		// TODO Auto-generated method stub
		for (int i = 0; i < p.length; i++) {
			if (p[i]!=null) {
				System.out.println(p[i].getName()+","+p[i].getColor()+","+p[i].getAge());
			}
		}
	}

}
