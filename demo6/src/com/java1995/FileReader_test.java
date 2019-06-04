package com.java1995;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReader_test {
//FilerReader 是对字符的操作，文件写到控制台上；
//	会受到编码集的影响；这个方法也是受到限制的编辑码集的限制；但是不能进行指定编码集的方式；
	public static void main(String[] args) {
		FileReader fr=null;
//		测试平台的编码集方式；getProperty(String key) 
//		获取指定键指示的系统属性。
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
