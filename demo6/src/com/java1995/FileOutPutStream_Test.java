package com.java1995;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutPutStream_Test {

	public static void main(String[] args) {
//		����ʾ�ǽ�һ���ַ���д��һ���ļ�����
//		�ֽ��������ʾ
		String s="qwertyuiopasdfghjkl";
		FileOutputStream fos=null;
		FileOutputStream fos1=null;
		File f=new File("E:\\IoDemoforJava\\String");//����һ���ļ���
		File f1=new File("E:\\IoDemoforJava\\subString");//������һ���ļ���
		if(!f.exists()){//�ж��ļ��Ƿ����
			try {
				f.createNewFile();//�ļ�������ʱ����һ���µ��ļ�
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}if(!f1.exists()){
			try {
				f1.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			fos=new FileOutputStream(f);//���ļ����뵽�������
			fos1=new FileOutputStream(f1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte b[]=s.getBytes();
		try {
			fos.write(b);//���������д�ļ�
			fos1.write(b, s.length()/2, s.length()/2);
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
	}

}
