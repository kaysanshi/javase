package com.wangluo.question;

import java.util.Scanner;

public class Score_test {
//	˼ά������
//��ί���֣�ʮ����ίȥ��һ����߷�һ����ͷ��������յ÷�
//	��ȡ���ֵ���Ƚ�������ȡֵ�÷�����
	public int getMax(int[] score){
		int Max ;
		Max=score[0];//��score[0]=max;���ֲ�һ���ķ�ʽ������
		for(int i=0;i<score.length;i++){
			for(int j=0;j<score.length-i;j++){
				if(score[j]>Max){
					Max=score[j];
				}	
			}
		}
		return Max;
	}
//	��ȡ��Сֵ
	public int getMin(int[] score){
		int Min ;
		Min=score[0];
		for(int i=0;i<score.length;i++){
			for(int j=0;j<i;j++){
				if(score[j]<Min){
					Min=score[j];
			}
		}
		}
		return Min;
	}
	public int getSum(int[] score){
		int sum=0;
		for(int i=0;i<score.length;i++){
			sum+=score[i];
		}
		return sum;
	}
	/*
	 * 
	 */
	public static void main(String[] args) {
		Score_test st=new Score_test();
		int score[]=new int[10];
		for(int i=0;i<score.length;i++){
			Scanner scan=new Scanner(System.in);
			System.out.println("�������"+(i+1)+"λ��ί�Ĵ�֣�");
			score[i]=scan.nextInt();
		}
		System.out.println("��ʼ�÷�Ϊ��");
		for(int x:score){
			System.out.print(x+" ");
		}
		System.out.println("��ʼ�ܵķ֣�");
		System.out.println(st.getSum(score));
		double getscore=0;
		int max=st.getMax(score);
		System.out.println(max);
		int min=st.getMin(score);
		System.out.println(min);
		int sum=st.getSum(score);
		System.out.println(sum-max-min);
		getscore=(sum-max-min)/(double)(score.length-2);
		System.out.println("���ѡ�ֵ����յ÷�Ϊ��"+getscore);
	}
}
