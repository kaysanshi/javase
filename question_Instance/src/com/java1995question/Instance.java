package com.java1995question;
/**
 *��Java��дˮ�ɻ���
 *�ر�ע�����λ�ϵ����ļ���
 * ��λʱȡ����ʮλʱ����ȡ������λ��ȡ�ࣻ 
 */
public class Instance {
	public static void main(String[] args){
		int a,b,c;
		System.out.println("���100��1000�е�ˮ�ɻ���");
		for( int i=100;i<1000;i++)
		{
			a=i/100;//ȡ����λ��
			b=i%100/10;//ȡ��ʮλ��
			c=i%10;//ȡ����λ��
		if((a*a*a)+(b*b*b)+(c*c*c)==i)
			System.out.println(i+"\t");
		}
	}

}
