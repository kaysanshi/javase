package com.zcibJOB;

public class Student {
	 	int num;
	    int age;
	    String name;
//	 toString��������ԭ�е��ַ����������µ����ݲ���ԭ��(�´�)���ַ������س���
	    public String toString( ) {
	       String s = "ѧ��:" + num + "��";
	       s += "����:" + name + "��";
	       s += "����:" + age;
	       return s;
	    }
//	 �����вεĹ��췽��
	    public Student(int Num,int Age,String Name) {
	    	this. num = Num;
	        this.age = Age;
	        this.name = Name;
	    }
	 
	   public static void main(String args[]) {
	       Student s1 = new Student(3,18,"����");
	       Student s2 = new Student(1,21,"С·");
	       Student s3 = new Student(33,20,"John");
	       Student s4 = new Student(13,20,"Lucy");
	       Student s5 = new Student(8,17,"Jack");
	       Student s[] = {s1,s2,s3,s4,s5};
	       System.out.println("�༶ѧ���������£�");
	       output(s);  //��1�ε���output�����������
	 
	       /* ��ѧ����ѧ������ */  
	       for (int i=0;i<s.length-1;i++)
	         for (int j=i+1;j<s.length;j++)
	           if (s[i].num>s[j].num) {
	               Student tmp=s[i];
	               s[i]=s[j];
	               s[j]=tmp;
	            }  
	       System.out.println("��ѧ����С��������...");
	       output(s);   //��2�ε���output�����������
	      
	for (int i=0;i<s.length;i++) //������ѧ�������1
	            s[i].age++;  
	       System.out.println("����ѧ�������1��...");
	       output(s);  //��3�ε���output�����������
	 
	       /* ����ͳ�ƴ���20���ѧ������ */
	       int count=0;
	       for (int i=0;i<s.length;i++) 
	          if (s[i].age>=20) 
	        	  count++;
	       System.out.println("����20�������ǣ�" + count);
	}
	 
	
		/* ���·������ѧ�����������Ԫ��  output(Student s[])��̬���������е���Ҫ�����Ķ�������
	  * �ڴ�Ӧ�ã��ڴ����þ�̬�����ô��˷����ǿ��Թ����*/
	     static void  output(Student s[]) {
	        for (int i=0;i<s.length;i++) 
	    System.out.println(s[i]);
	      }


}
