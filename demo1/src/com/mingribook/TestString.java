package com.mingribook;

public abstract class TestString {

	public static void main(String[] args) {
		System.out.println("�ַ������滻��ʵ�֣�");
		String s="bad bad study";
		String str=s.replace("bad", "good");
		System.out.println("�ַ������滻��"+str);
		String str1=s.replaceFirst("bad", "good");
		System.out.println("�滻��һ���ַ�����"+str1);
		System.out.println("������е����ж��ַ����Ƿ���ȣ���");
		String st1=new String("I am a student");
		String st2=new String("I am a student");
		String st3=new String("I AM A STUDENT");
		String st4=st1;
		boolean b1=(st1==st2);//�ڴ�λ�õıȽ�
		boolean b2=(st1==st4);
		boolean b3=st1.equals(st2);
		boolean b4=st1.equals(st3);//�жϱȽ����ִ�Сд
		boolean b5=st1.equalsIgnoreCase(st2);//�жϱȽϲ����ִ�Сд
		boolean b6=st1.equalsIgnoreCase(st3);//�жϱȽϲ����ִ�Сд
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
		System.out.println(b4);
		System.out.println(b5);
		System.out.println(b6);
		System.out.println("�����ж��ַ�����ͷ���β��");
		String num1="2215203";
		String num2="5056998";
		boolean p1=num1.startsWith("22");//�ж��Ƿ�������ַ���ͷ
		boolean p2=num1.endsWith("03");//�ж��Ƿ�������ַ����� ��������
		boolean p3=num1.endsWith("54");
		boolean p4=num2.startsWith("50");
		boolean p5=num2.endsWith("98");
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		System.out.println(p4);
		System.out.println(p5);
		System.out.println("�������ĸ�Ĵ�Сд��ת����");
		String st=new String("123 abc DBH");
		String s1=st.toLowerCase();//ת��ΪСд�ķ���
		String s2=st.toUpperCase();//ת��Ϊ��д�ķ���
		System.out.println("ת��ΪСд��"+s1);
		System.out.println("ת��Ϊ��д��"+s2);
		System.out.println("��������ַ����ķָ����");
		String b=new String("abc,def,ghi,gkl");
		String[] arr=b.split(",");//�ָ��ַ�����Ҫ��ָ�
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
		System.out.println("���ָ��ַ����ַָ");
		String[] arr1=b.split(",", 2);//�ָ��ַ����İ����ַָ�
		for(int i=0;i<arr1.length;i++){
			System.out.println(arr1[i]);
		}
	}

}
