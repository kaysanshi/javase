package com.zcibJOB;

import java.util.Scanner;

public class Triangle {
	//	��дһ���������࣬�ܸ���3��ʵ�����������ζ����������ʵ�������������ε�������
//	���Զ���������СֵΪ�ߵĵȱ������Ρ���������������������������������
	double a;
	double b;
	double c;
	double area;
//	���췽��
	  Triangle(){
		  
	  }
//	  ��Ա����
	 double getArea(double a,double b,double c){
		this.a=a;
		this.b=b;
		this.c=c;
		if(a+b>c && a+c>b && c+b>a){
		double p=(a+b+c)/2;
		 area= Math.sqrt(p*(p-a)*(p-b)*(p-c));
		}else{
			if(a>c){
				a=c=b;
				double p=(a+b+c)/2;
				 area= Math.sqrt(p*(p-a)*(p-b)*(p-c));
			}	
			else if(a>b){
					a=c=b;
					double p=(a+b+c)/2;
					 area= Math.sqrt(p*(p-a)*(p-b)*(p-c));
				}
			else if(b>c){
					a=b=c;
					double p=(a+b+c)/2;
					 area= Math.sqrt(p*(p-a)*(p-b)*(p-c));
				}else{
					b=c=a;
					double p=(a+b+c)/2;
					 area= Math.sqrt(p*(p-a)*(p-b)*(p-c));
				}
			}
		return area; 
		 }
	public static void main(String[]args){
		 Triangle p=new Triangle();
		 System.out.println("��ֱ�����ABC��ֵ��");
		 Scanner scan =new Scanner(System.in);
		 double a=scan.nextDouble();
		 double b=scan.nextDouble();
		 double c=scan.nextDouble();
		 scan.close();	
	System.out.println(p.getArea(a,b, c));
	}
}
