package com.zcibJOB;

public class Eg3 {
//	≈≈–Ú¡∑œ∞Ã‚
	public static void main(String[] args){
		int a[]=new int[]{25,24,12,76,101,96,28};
		for(int i=1;i<a.length;i++){
			for(int j=0;j<a.length-i;j++){
				if(a[j]>a[j+1]){
					 int temp=a[j];
					 a[j]=a[j+1];
					 a[j+1]=temp;
				}
			}
		}
		for(int i=0;i<a.length ;i++){
			System.out.print(a[i]+" ");
		}
	}

}
