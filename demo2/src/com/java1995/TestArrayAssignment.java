package com.java1995;

public class TestArrayAssignment {
	//��������ĳ�ʼ����ʽ�͸���
	public static void main(String[] args) {
		int[] array1={1,2,5};
		int[] array2={7,8,9};
		System.out.println("�����ʼ��Ϊ��");
		//(������+.length)���Լ������ĳ��ȣ�
		for(int i=0;i<array1.length;i++){
			System.out.println("array1["+i+"]="+array1[i]);
			}
			for(int j=0;j<array2.length;j++){
				System.out.println("array2["+j+"]="+array2[j]);
		}
		//��array2��ֵ��array1�������ƣ� 
			array1=array2;//��ʵ�ǰ�array1���׵�ַָ����array2���׵�ַ
			System.out.println("���鸳ֵ���������һ�Ͷ�");
			for(int i=0;i<array1.length;i++){
				System.out.println("array1["+i+"]="+array1[i]);
				}
			for(int j=0;j<array2.length;j++){
				System.out.println("array2["+j+"]="+array2[j]);
			}
			//�Ķ������ֵ���ٽ��в�������ǰ������鸴���� ���Ҹ��ƺ����۸ı��ĸ�����
			//�е�ֵ��ԭ�ȸ��ƹ��������е�ֵ����ı�
			array1[0]=100;
			array1[1]=200;
			array2[1]=130;
			System.out.println("array���¸��ƺ�����飺");
			for(int i=0;i<array1.length;i++){
				System.out.println("array1["+i+"]="+array1[i]);
				}
			for(int j=0;j<array2.length;j++){
				System.out.println("array2["+j+"]="+array2[j]);
			}
	}
}
