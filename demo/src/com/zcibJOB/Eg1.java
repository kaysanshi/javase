package com.zcibJOB;

import java.util.Scanner;

public class Eg1 {
	//�˳���Ϊ��ʵ��2n/(n+m)���㷨��
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
		System.out.println("����������m��n��ֵ��");
		Scanner scan=new Scanner(System.in);
		double m=scan.nextDouble();
		double n=scan.nextDouble();
		scan.close();
			Eg1 p=new Eg1();
			p.m=m;
			p.n=n;
			p.Test(n, m);
			System.out.println(p.Test(p.m,p.n));
			System.out.println("��".equals("��"));
		}
}
