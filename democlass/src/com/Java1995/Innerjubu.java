package com.Java1995;

public class Innerjubu {
//�ֲ��ڲ����ʵ��
	public static void main(String[] args) {
		Outer out=new Outer();
		OutI oi=out.Way(3);
		System.out.println(oi);
	}
}
class Outer{
	private String name;
//	�ֲ��ڲ���ı���������final�ģ�
	public OutI Way(final int i){
		final int count = 0;
//	����һ�����ڲ��ࣻ
		class Inner implements OutI{
			public void innerWay(){
				System.out.println(name);
				System.out.println(i);
				System.out.println(count);
				}
			}
		return new Inner();
		}
	}
interface OutI{
	
}