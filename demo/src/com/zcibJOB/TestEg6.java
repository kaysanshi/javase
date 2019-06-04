package com.zcibJOB;
import java.util.Scanner;
public class TestEg6 {
//如何用这个主函数调用Eg6类中的方法；
	public static void main(String[] args) {
		Scanner scan =new Scanner(System.in);
		int x=scan.nextInt();
		scan.close();
		Eg6 p=new Eg6();
		p.array(x);

	}

}
