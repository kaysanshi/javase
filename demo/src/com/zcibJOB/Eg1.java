package com.zcibJOB;

import java.util.Scanner;

public class Eg1 {
	//此程序为了实现2n/(n+m)的算法；
	private double n;
	private double m;
	public double Test(double n,double m){
		this.setN(n);
		this.setM(m);
		return 2*n/(n+m);
	}
	public double getN() {
		return n;
	}
	public void setN(double n) {
		this.n = n;
	}
	public double getM() {
		return m;
	}
	public void setM(double m) {
		this.m = m;
	}
	public static void main(String[] args) {
		System.out.println("请依次输入m和n的值：");
		Scanner scan=new Scanner(System.in);
		double m=scan.nextDouble();
		double n=scan.nextDouble();
		scan.close();
			Eg1 p=new Eg1();
			p.m=m;
			p.n=n;
			p.Test(n, m);
			System.out.println(p.Test(p.m,p.n));
			System.out.println("大海".equals("大海"));
		}
}
