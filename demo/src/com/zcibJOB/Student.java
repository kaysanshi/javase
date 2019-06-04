package com.zcibJOB;

public class Student {
	 	int num;
	    int age;
	    String name;
//	 toString方法是在原有的字符串中增加新的内容并把原有(新串)的字符串返回出来
	    public String toString( ) {
	       String s = "学号:" + num + "，";
	       s += "姓名:" + name + "，";
	       s += "年龄:" + age;
	       return s;
	    }
//	 构造有参的构造方法
	    public Student(int Num,int Age,String Name) {
	    	this. num = Num;
	        this.age = Age;
	        this.name = Name;
	    }
	 
	   public static void main(String args[]) {
	       Student s1 = new Student(3,18,"张三");
	       Student s2 = new Student(1,21,"小路");
	       Student s3 = new Student(33,20,"John");
	       Student s4 = new Student(13,20,"Lucy");
	       Student s5 = new Student(8,17,"Jack");
	       Student s[] = {s1,s2,s3,s4,s5};
	       System.out.println("班级学生名单如下：");
	       output(s);  //第1次调用output方法输出数组
	 
	       /* 将学生按学号排序 */  
	       for (int i=0;i<s.length-1;i++)
	         for (int j=i+1;j<s.length;j++)
	           if (s[i].num>s[j].num) {
	               Student tmp=s[i];
	               s[i]=s[j];
	               s[j]=tmp;
	            }  
	       System.out.println("按学号由小到大排序...");
	       output(s);   //第2次调用output方法输出数组
	      
	for (int i=0;i<s.length;i++) //将所有学生年龄加1
	            s[i].age++;  
	       System.out.println("所有学生年龄加1后...");
	       output(s);  //第3次调用output方法输出数组
	 
	       /* 以下统计大于20岁的学生个数 */
	       int count=0;
	       for (int i=0;i<s.length;i++) 
	          if (s[i].age>=20) 
	        	  count++;
	       System.out.println("大于20岁人数是：" + count);
	}
	 
	
		/* 以下方法输出学生数组的所有元素  output(Student s[])静态方法括号中的是要操作的对象属性
	  * 在此应用，在此运用静态方法好处此方法是可以共享的*/
	     static void  output(Student s[]) {
	        for (int i=0;i<s.length;i++) 
	    System.out.println(s[i]);
	      }


}
