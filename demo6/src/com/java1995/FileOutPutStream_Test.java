package com.java1995;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutPutStream_Test {

	public static void main(String[] args) {
//		此演示是将一个字符串写到一个文件夹中
//		字节输出的演示
		String s="qwertyuiopasdfghjkl";
		FileOutputStream fos=null;
		FileOutputStream fos1=null;
		File f=new File("E:\\IoDemoforJava\\String");//定义一个文件夹
		File f1=new File("E:\\IoDemoforJava\\subString");//定义另一个文件夹
		if(!f.exists()){//判断文件是否存在
			try {
				f.createNewFile();//文件不存在时创建一个新的文件
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
			fos=new FileOutputStream(f);//将文件传入到输出流中
			fos1=new FileOutputStream(f1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte b[]=s.getBytes();
		try {
			fos.write(b);//在这里进行写文件
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
