package com.java1995;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStream_test {
	public static void main(String[] args) {
		FileInputStream fis=null;
		try {
			fis=new FileInputStream("E:\\IoDemoforJava\\String");
			int i=0;
			while(i!=-1){
				System.out.print((char)i);
				i=fis.read();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

}
