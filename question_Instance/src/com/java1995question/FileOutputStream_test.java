package com.java1995question;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class FileOutputStream_test {
/*
 * ͨ�������ȡ�����Լ�Ҫд�����Ϣд�뵽�ļ��в��Ҷ�ȡ������̨��
 */
	public static void main(String[] args) {
//		fileInputStream �ֽڵ���������
//		FileOutputStream�ֽڵ��������
			String s="���ĺ���д�뵽�����ı���";
			String s2="abcdefasdfgghhhhh";
			FileOutputStream fos=null;
			FileOutputStream fos1=null;
			FileInputStream  fis=null;
			FileReader fir=null;
			File f=new File("E:\\IoDemoforJava\\javaString");
			File f2=new File("E:\\IoDemoforJava\\javaSubString");
			if(!f.exists()){
				try {
					System.out.println("��ʼ�����ļ�");
					f.createNewFile();
					System.out.println("�ļ��Ѵ���");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}if(!f2.exists()){
				try {
					System.out.println("��ʼ�����ļ�");
					f2.createNewFile();
					System.out.println("�ļ��Ѵ���");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				fos=new FileOutputStream(f);
				fos1=new FileOutputStream(f2);
				fir=new FileReader(f);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("���ڽ���д�����");
			byte[] b=s.getBytes();
			byte[] b2=s2.getBytes();
			try {
				fos.write(b);
				fos1.write(b);
//				��fos1�Ķ����м���д��һЩ�ı�
				fos1.write(b, s.length()/2, s.length());
//				��s2�е���ϢҲд�뵽�ı������У�
				fos.write(b2);
				fos1.write(b2);
				System.out.println("д��ɹ�");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					fos.close();
					fos1.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				fis=new FileInputStream("E:\\IoDemoforJava\\javaString");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int i=0;
			try {
				i=fis.read();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("���ڽ��ж�ȡ����");
			while(i!=-1){
				try {
					i=fir.read();
					System.out.print((char)i);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(i==-1){
					System.out.println("��ȡ���");
				}
			}
			

	}

}
