package com.java1995;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriter_test {
//字符的处理通过程序把字符写入到文件中
//	这个方法也是受到限制的编辑码集的限制；但是不能进行指定编码集的方式；
	public static void main(String[] args) {
		FileWriter fw=null;
		try {
			fw=new FileWriter("E:\\IoDemoforJava\\text.txt");
			String s="qwerty123麦基";
			for(int i=0;i<s.length();i++){
				fw.write(s.charAt(i));
			}
			fw.flush();//进行刷新流操作；
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
