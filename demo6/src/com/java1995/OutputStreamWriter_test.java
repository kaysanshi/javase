package com.java1995;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class OutputStreamWriter_test {
//字符输出流；是字符转换为字节的方式是字符流转换为字节流的方式；
//	转换时也是但根据编辑器的字符集的编码的方式来转换；
	public static void main(String[] args) {
		FileOutputStream fis=null;
		OutputStreamWriter osw=null;
		try {
			fis=new FileOutputStream("E:\\IoDemoforJava\\String");
			osw=new OutputStreamWriter(fis);
			String s="java is my loved 语言";
			for(int i=0;i<s.length();i++){
				osw.write(s.charAt(i));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				osw.flush();
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}

}
