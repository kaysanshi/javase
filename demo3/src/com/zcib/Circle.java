package com.zcib;

public  class Circle implements ICalculate {
	public float getArea(float r){
		float area= PI*r*r;
		return area;
	}
	public float getCircumference(float r){
	  float	circumference=PI*r*2;
	  return circumference;
	}
	@Override
	public double getArea(double a, double b) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public double getl(double a, double b) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
