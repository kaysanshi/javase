package com.java1995;

public class Test_P_T {

	public static void main(String[] args) {
//		������Ҳ���ö��߳�ʱ�����̵߳�ʹ�ò������в�Ψһ��Teacherͬʱ����һ��Print������
//		���������ﲢ������ʱ����ͬʱΨһ����ģ��������̲߳��������ԣ�
		Print p=new Print();
		Teacher t1=new Teacher(p,"����",55,44,87);
		Teacher t2=new Teacher(p,"ά��",55,98,44);
		Teacher t3=new Teacher(p,"join",150,48,55);
		Thread p1=new Thread(t1);
		Thread p2=new Thread(t2);
		Thread p3=new Thread(t3);
		p1.start();
		p2.start();
		p3.start();
	}

}
