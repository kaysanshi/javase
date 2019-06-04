package com.zcibJOB;

import java.util.Scanner;

public class Triangle {
	//	编写一个三角形类，能根据3个实数构造三角形对象，如果三个实数不满足三角形的条件，
//	则自动构造以最小值为边的等边三角形。输入任意三个数，求构造的三角形面积。
	double a;
	double b;
	double c;
	double area;
//	构造方法
	  Triangle(){
		  
	  }
//	  成员方法
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
		 System.out.println("请分别输入ABC的值：");
		 Scanner scan =new Scanner(System.in);
		 double a=scan.nextDouble();
		 double b=scan.nextDouble();
		 double c=scan.nextDouble();
		 scan.close();	
	System.out.println(p.getArea(a,b, c));
	}
}
