package com.java1995;

public class TestArrayOfTwo1 {
	//�ö�ά����ʵ�־Ź�������
	//ʹÿһ�У��У��Խ����ϵ����ֺ�Ϊ15��
	public static void main(String[] args) {
		int arr[][]=new int[3][3];
		int a=2,b=3/2;
		for(int i=1;i<=9;i++){
			arr[a++][b++]=i;// ?
			if(i%3==0){
				a-=2;
				b-=1;
			}else{
				a%=3;
				b%=3;
			}
		}
		System.out.println("�Ź���:");
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.print("\n");
		}
	}

}
