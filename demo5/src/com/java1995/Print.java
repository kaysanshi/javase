package com.java1995;

public class Print {
	public void getPrint(String name,int MathScore,int EnglishScore,int ChineseScore ){
		System.out.println(name+"����ѧ�ɼ���"+MathScore);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(name+"��Ӣ��ɼ���"+EnglishScore);
		System.out.println(name+"�����ĳɼ���"+ChineseScore);
	}

}
