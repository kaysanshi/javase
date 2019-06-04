package com.java1995;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInPutStream_Test {
	//文件的输入输出流前提是这个文件是存在的
//	fileInputStream 是文件的输入流，字节输入流的实现类
	public static void main(String[] args) {
		FileInputStream fip=null;
		try {
			fip=new FileInputStream("E:\\IoDemoforJava\\String");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int i=0;
		try {
			//读取的时候是一个字节一个读的
			i=fip.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		i=-1是文件读到结束
		while(i!=-1){
			System.out.print((char)i);
			try {
				i=fip.read();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
