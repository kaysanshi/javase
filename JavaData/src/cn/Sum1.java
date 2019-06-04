package cn;

import java.util.Scanner;

import com.sun.org.apache.bcel.internal.generic.NEW;

//�ݹ����;
public class Sum1{
	
	int test(int n){
		if(n==1){
			return 1;
		}else{
			return test(n-1)+n;
		}
	}
	public static void main(String[] args) {
		Sum1 sum1=new Sum1();
		System.out.println("�������������:");
		Scanner scanner=new Scanner(System.in);
		int m=scanner.nextInt();
		int s=sum1.test(m);
		System.out.println(s);
		
	}

}
