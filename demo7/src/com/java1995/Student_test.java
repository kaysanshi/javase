package com.java1995;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Student_test {
//������Ҫ����Щѧ����Ϣд���ļ��У�
	public static void main(String[] args) {
		FileInputStream fis=null;
		FileOutputStream fos=null;
		
		ObjectInputStream ois=null;
		ObjectOutputStream oos=null;
		Student s1=new Student();
		s1.setName("lihu");
		s1.setAge("20");
		s1.setSex("Ů");
		s1.setAddress("����");
		Student s2=new Student();
		s2.setAddress("����");
		s2.setAge("19");
		s2.setName("�Ż�");
		s2.setSex("��");
		try {
			fos=new FileOutputStream("E:\\IoDemoforJava\\File.txt");
			oos=new ObjectOutputStream(fos);
			oos.writeObject(s1);
			oos.writeObject(s2);
			fis=new FileInputStream("E:\\IoDemoforJava\\File.txt");
			ois=new ObjectInputStream(fis);
			Student s1_s=(Student)ois.readObject();
			Student s2_s=(Student)ois.readObject();
			System.out.println(s1_s);
			System.out.println(s2_s);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
