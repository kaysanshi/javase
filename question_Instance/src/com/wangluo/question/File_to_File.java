package com.wangluo.question;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * ���ַ���������ʵ��һ���ı�д�뵽��һ���ı���BufferedInputStream������
 * 1.���Ǵ��ļ��ж�ȡ���ݣ�
 * 2.�Ѷ���������д����һ�ļ���
 * 1(1):�����ļ���(2):������д�뵽�ļ���(3)�����ļ�������̨�ϣ�
 * 2(1):�����ļ�(2):��ȡ�ļ�һ������write()����д�뵽�ļ��У�(3):ͬ�����Ե�����̨�ϣ�
 */
public class File_to_File {

	public static void main(String[] args) {
		File f1=new File("E:\\IoDemoforJava\\text1");
		File f2=new File("E:\\IoDemoforJava\\text2");
		FileInputStream fis=null;
		FileOutputStream fos=null;
		BufferedInputStream bis=null;
		BufferedOutputStream bos=null;
		if(!f1.exists()){
			try {
				f1.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(!f2.exists()){
			try {
				f2.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//	д���ļ��еĲ�����
		try {
			fos=new FileOutputStream(f1);
			bos=new BufferedOutputStream(fos);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String s="hello bufferedReaderInputStream";
		byte b[]=s.getBytes();
		try {
			bos.write(b);
			bos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//д�뵽�ļ�1�����
//��ȡ�ļ�һ�����ݵ�����̨��;
		try {
			fis=new FileInputStream(f1);
			bis=new BufferedInputStream(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i=0;
		try {
			while(i!=-1){
				System.out.print((char)i);
				i=bis.read();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//���ļ�һ������д���ļ����У�
		try {
			fos=new FileOutputStream(f2);
			bos=new BufferedOutputStream(fos);
			fis=new FileInputStream(f1);
			bis=new BufferedInputStream(fis);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int n=0;
		try {
			while(n!=-1){
				n=bis.read();
				bos.write(n);
				bos.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//	���ļ�����������̨�ϣ�
		System.out.println();
		System.out.println(f2.getAbsolutePath()+"������̨���");
		try {
			fis=new FileInputStream(f2);
			bis=new BufferedInputStream(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int m=0;
		while(m!=-1){
			try {
				System.out.print((char)m);
				m=bis.read();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
