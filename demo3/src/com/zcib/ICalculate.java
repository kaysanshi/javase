package com.zcib;
//定义一个计算接口
public interface ICalculate {
//	在接口中方法的修饰符都为public abstract
	final float PI=3.14159f;//其实在父接口中的变量时final static类型的不需要加关键字了；
	float getArea(float r);//计算面积的方法；
	float getCircumference(float r);//计算圆周的方法
	double getArea(double a,double b);//方法
	double getl(double a,double b);
}
