package com.hansunping;

public class Sort {

	public static void main(String[] args) {
		int arr[]=new int[]{12,3,4,6,9,15};
		//冒泡排序法；由大到小
		for(int i=0;i<arr.length-1;i++){
			for(int j=0;j<arr.length-i-1;j++){
				if(arr[j+1]>arr[j]){
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		//直接插入排序；
		
		
		for(int i=1;i<arr.length;i++){
			int j;
			int temp;
			temp=arr[i];
			for(  j=i-1;j>=0 && arr[j]>temp;j--){
				arr[j+1]=arr[j];
			}
			arr[j+1]=temp;
		}
		System.out.println();
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
//		选择排序
		int position=0;
		for(int i=0;i<arr.length;i++){
			position=i;
			int temp=arr[i];
			for(int j=i+1;j<arr.length;j++){
				if(arr[j]<temp){
					temp=arr[j];
					position=j;
				}
			}
			arr[position]=arr[i];
			arr[i]=temp;
		}
		System.out.println();
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		//快速排序法；
		
	}

}
