package com.leoi555.javaTest;

public class test04 {

	/*
	 * 1、（if 语句）定义一个整数，表示一个人的年龄。如果小于6 岁，则输出“儿童”，6 岁到13 岁，输出“少儿 ”；14
	 * 岁到17岁，输出“青少年”；18 岁到35 岁，输出“青年”；36岁到50 岁，输出“中年”；50 岁 以上输出“中老年”。编码实现
	 * 在Demo1.java文件编写
	 * 2、输入一个数字，判断该数字是偶数还是奇数信息
	 * 在Demo2.java文件编写
	 * 3、输入一个数字，判断该数字是否为3和5的倍数
	 * 在Demo3.java文件编写
	 * 4:流程控制语句有几种?
	 * 答案：
	 * 
	 * 5:if语句的格式有几种?注意事项是什么?分别在什么时候使用? 三种。
	 * 答案：
	 * 
	 * 
	 * 6:看程序写结果：请自己独立分析，先不要编译运行。
	 * 
	 * 第一题 int x = 1,y = 1;
	 * 
	 * if(x++==2 & ++y==2) //false & true =false; x=2,y=2 { x =7; }
	 * System.out.println("x="+x+",y="+y);
	 * 
	 * 答案：
	 * --------------------------------------------------- 
	 * 第二题 int x = 1,y = 1;
	 * 
	 * if(x++==2 && ++y==2) { x =7; } System.out.println("x="+x+",y="+y);
	 * 
	 * 答案：
	 * --------------------------------------------------- 
	 * 第三题 int x = 1,y = 1;
	 * 
	 * if(x++==1 | ++y==1) //true | false = true; x=2,y=2 { x =7; //x=7,y=2 }
	 * System.out.println("x="+x+",y="+y);
	 * 
	 * 答案：
	 * --------------------------------------------------- 
	 * 第四题 int x = 1,y = 1;
	 * 
	 * if(x++==1 || ++y==1) { x =7; } System.out.println("x="+x+",y="+y);
	 * 
	 * 
	 * 9:switch语句的格式?针对格式的解释?以及注意事项?
	 * 答案：
	 * 
	 * 10:看程序，分析下面程序的结果： 
	 * int x = 2,y=3;
	 * 
	 * switch(x) { default: y++; case 3: y++; break; case 4: y++; }
	 * 
	 * System.out.println("y="+y);
	 * 
	 * 答案：
	 * 
	 * 11:根据输入的值，判断是星期几。(分别用if语句和switch语句实现) 
	 * 输入：1 输出：星期1
	 * 在Demo4.java文件编写
	 * 
	 * 12、预习流程控制-循环结构
	 * 
	 */
	public static void main(String[] args) {
		int x = 1,y = 1;
		System.out.println(x++);//x++=1,先运算再+1
		System.out.println(++y);//++y,先+1再运算
		//&第一个都为false所以不会执行if内语句
		if(x++==2 & ++y==2){ 
		  System.out.println("x="+x+",y="+y);  
		}
		
		 int m = 1,n = 1; 
		 if(m++==2 && ++n==2) { m =7; } 
		 //m++=1,++n=2
		 //&&：短路与，第一个我false则执行了else语句
		 System.out.println("x="+m+",y="+n);//x=2,y=1
		 
		 int x1 = 1,y1 = 1;
		  //|：对所有的条件都判断
		 if(x1++==1 | ++y1==1) //true | false = true; x++=1,++y1=2
			 { x1 =7;}
		 System.out.println("x="+x1+",y="+y1);//x=7,y=2
		 
		 int x2 = 1,y2 = 1;
		 //:||如果第一个条件为真不再判断后面的，如果第一个条件为假再判断后面的
		 if(x2++==1 || ++y2==1) //x2++=1:true,++y2==1:false==>++y2=2;
		 { x2 =7; }
		 System.out.println("x="+x2+",y="+y2);//x=7,y=1
	}
}
