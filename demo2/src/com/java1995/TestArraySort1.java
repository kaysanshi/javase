package com.java1995;

public class TestArraySort1 {
	//һά����ð�ݷ�����
	public static void main(String[] args) {
		int[] array=new int[]{25,63,45,98,102,56,75};
		System.out.println("ð�����򷨵���ʾ:");
		//���ð�ݷ�����Ĺ���
		for(int i=1;i<array.length;i++){
			for(int j=0;j<array.length-i;j++){
				if(array[j]>array[j+1]){
					int temp=array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
				}
				System.out.print(array[j]+" ");
			}
			System.out.print("��");
			for(int j=array.length-i;j<array.length;j++){
				System.out.print(array[j]+" ");
			}
			System.out.println("��");
			
		}
		//����������������
		System.out.println("ð�ݷ�������");
		for( int i=0;i<array.length;i++){

				System.out.print(array[i]+" ");
		}
	}
}
