package com.zcibJOB;

public class Sum {
//	й╣ож1+3+5+...+99
	public static void main(String[] args){
		int sum=0;
		for(int i=0;i<100;i++){
			
			if(i%2==0){
				i+=1;
			//System.out.println(i);
			}
			sum+=i;
		}
		System.out.println(sum);
	}

}
