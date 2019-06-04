package com.java1995;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamRead_test {
//字节流通向字符流的的桥梁；可以把字节解析到子符中；
//	fis 的read方法每次读取一个字节；而fr字符流是按照编码集的形式读取；可以由程序指定编码集方式；
	public static void main(String[] args) {
		FileInputStream fis=null;
		InputStreamReader fr=null;
		try {
			fis=new FileInputStream("E:\\IoDemoforJava\\javaString");
//			在这里可以进行字符编码的转换( ,"UTF-8")之类的编码集；
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
