package com.zcib.job;

public class TestGoodMan {

	public static void main(String[] args) {
		String s="abcd";
		for(int i=1;i<=3;i++){
			int count=0;
			char goodman=s.charAt(i);
			if(goodman!='a') count++;
			if(goodman=='c')count++;
			if(goodman=='d')count++;
			if(!(goodman=='d'))count++;
			if(count==3){
				System.out.println(goodman);
			}
		}

	}

}
