package com.zcib;
//����һ������ӿ�
public interface ICalculate {
//	�ڽӿ��з��������η���Ϊpublic abstract
	final float PI=3.14159f;//��ʵ�ڸ��ӿ��еı���ʱfinal static���͵Ĳ���Ҫ�ӹؼ����ˣ�
	float getArea(float r);//��������ķ�����
	float getCircumference(float r);//����Բ�ܵķ���
	double getArea(double a,double b);//����
	double getl(double a,double b);
}
