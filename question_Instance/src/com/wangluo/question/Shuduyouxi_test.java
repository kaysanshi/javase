package com.wangluo.question;

import java.util.Scanner;

/*
 * ��������Ϸ
 */
public class Shuduyouxi_test {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("������һ������");
		int n=scan.nextInt();
		int [][] arr= new int [n][n];
		int k=1;//ÿ�������ֵ��1��ʼ��
		int row=0;//����
		int col=(n-1)/2;//������
		arr[row][col]=k;
		while(k<n*n){//��������ֵ
			if(k%n==0){//���k��n�ı���ʱ
				row+=1;
			}else{
				if(row==0){//��������ڵ�һ�е�ʱ����һ���������һ��
					row=n-1;
				}else{//����������ڵ�һ��ʱ������������Ϸ�����λ�õ�ʱ��
					row-=1;
				}
				if(col==n-1){//������������һ��ʱ����һ�����ڵ�һ��
					col=0;
				}else{//��������������һ��ʱ����������Ϸ�����λ�õ�ʱ��
					col+=1;
				}
			}
			arr[row][col]=++k;
		}
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}

}
