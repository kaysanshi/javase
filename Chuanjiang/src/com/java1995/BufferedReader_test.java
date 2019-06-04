package com.java1995;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BufferedReader_test {
	public static void main(String[] args) {
		FileInputStream fis=null;
		BufferedInputStream bis=null;
		try {
			fis=new FileInputStream("E:\\IoDemoforJava\\String");
			bis=new BufferedInputStream(fis);
			
			int i=0;
			while((i=bis.read())!=-1){
				System.out.print((char)i);
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
