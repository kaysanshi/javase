package com.zcibJOB;
public class Eg4 {
//���ʵ����������ֵ���˳����޷���
	public static void main(String[] args) {
		int a[]=new int[]{6,8,9,10,12,13,59};
		int MAX=a[0];
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a.length-1;j++){
				if(MAX<a[j+1]){
					MAX=a[j+1];
				}
			}
			//System.out.println(MAX);	
		}
		System.out.println(MAX);
	}

}
