package com.java1995;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedInOutputStream_test {
//用fis对象操作read的方法时：每一次就要对文件进行读取一个字节一个字节的读；
//bis对象操作read的时第一次访问时就会读很多默认的字节储存在buf数组的缓冲区中，这样就缩少了与文件交互时的次数；读的是在
//	缓冲区的内容并不需要与文件交互太多的io操作；
	public static void main(String[] args) {
		FileInputStream fis=null;
		BufferedInputStream bis=null;
		
		FileOutputStream fos=null;
		BufferedOutputStream bos=null;
		try {
			fis=new FileInputStream("E:\\javaString");
			bis=new BufferedInputStream(fis);
			fos=new FileOutputStream("E:\\subString");
			bos=new BufferedOutputStream(fos);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i=0;
		while(i!=-1){
			try {
				bis.read();
				System.out.print((char)i);
				bos.write(i);
				i=bis.read();
				bos.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
//			}finally{
//				try {
//					
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				
			}
		}
		

	}

}
