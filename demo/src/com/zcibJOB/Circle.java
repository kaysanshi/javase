package com.zcibJOB;

public class Circle {
	double r;
	double s;
	double l;
	static double PI=3.14;
//  周长的方法
	public double perimeter(double r){
	//以下两可以说明再含有参数的方法中可以用以下方式传值；
		this.r=r;
		return l=(2*PI*r);	
	}
//	面积的方法
	public double area(double r){
		this.r=r;
		return s=(PI*r*r);	
	}

}
