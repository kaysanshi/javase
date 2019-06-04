package com.zcib;
//此类实现接口的方法；
public class Rectangle implements ICalculate {

	public double getArea(double a,double b){
		double area=a*b;
		return area;
	}
	public double getl(double a,double b){
		double l=2*(a+b);
		return l;
	}

	@Override
	public float getArea(float r) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getCircumference(float r) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
