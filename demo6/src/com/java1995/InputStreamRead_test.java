package com.java1995;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamRead_test {
//�ֽ���ͨ���ַ����ĵ����������԰��ֽڽ������ӷ��У�
//	fis ��read����ÿ�ζ�ȡһ���ֽڣ���fr�ַ����ǰ��ձ��뼯����ʽ��ȡ�������ɳ���ָ�����뼯��ʽ��
	public static void main(String[] args) {
		FileInputStream fis=null;
		InputStreamReader fr=null;
		try {
			fis=new FileInputStream("E:\\IoDemoforJava\\javaString");
//			��������Խ����ַ������ת��( ,"UTF-8")֮��ı��뼯��
			fr=new InputStreamReader(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int m=0;
		try {
			m=fr.read();
			while(m!=-1){
				System.out.print((char)m);
				m=fr.read();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				fis.close();
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	
}
