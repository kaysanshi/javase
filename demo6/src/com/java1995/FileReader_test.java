package com.java1995;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReader_test {
//FilerReader �Ƕ��ַ��Ĳ������ļ�д������̨�ϣ�
//	���ܵ����뼯��Ӱ�죻�������Ҳ���ܵ����Ƶı༭�뼯�����ƣ����ǲ��ܽ���ָ�����뼯�ķ�ʽ��
	public static void main(String[] args) {
		FileReader fr=null;
//		����ƽ̨�ı��뼯��ʽ��getProperty(String key) 
//		��ȡָ����ָʾ��ϵͳ���ԡ�
		System.out.println(System.getProperty("file.encoding"));
		try {
			fr=new FileReader("E:\\IoDemoforJava\\text.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i=0;
		try {
			i=fr.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
		while(i!=-1){
			System.out.print((char)i);
				i=fr.read();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}

}
