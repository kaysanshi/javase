package com.zcibJOB;
import java.util.Scanner;
public class Eg2 {
//	练习题
	public static int sum(int x){
		int y=0;
		if(x>0){
			y=x+3;
		}
		else if(x<0){
			y=x*x-1;
		}
		else{
			y=0;
		}
			
		return y;
	}

	public static void main(String[] args) {
		System.out.println("输入x的值:");
		Scanner scan=new Scanner(System.in);
		int x=scan.nextInt();
		scan.close();
		int y=Eg2.sum(x);
		System.out.println(y);	

	}

}
