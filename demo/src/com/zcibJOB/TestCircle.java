package com.zcibJOB;

public class TestCircle {

	public static void main(String[] args) {
		Circle p=new Circle();
		// ��this�ؼ��ַ�����
		p.r =6;
		System.out.println(p.area(p.r));//���
		System.out.println(p.perimeter(p.r));//�ܳ���
		//��ֱ�Ӵ��εķ�������������ֱ��return����ֱ�Ӵ��Σ�
		System.out.println(p.area(5));
		System.out.println(p.perimeter(5));
		//�ٴ�new��һ������Ȼ��ֵ����this�ؼ��ֵķ���;
		Circle p1=new Circle();
		p1.r=6;
		System.out.println(p1.area(p1.r));

	}

}
