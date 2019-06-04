package com.zcib.book.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class RWByStreamOne {
//字节流和缓冲字节
//	复制形式
	public static void main(String[] args) {
		try {
			FileInputStream fis=new FileInputStream("test.txt");
			FileOutputStream fos=new FileOutputStream("text_new.txt");
			byte[] b=new byte[1];
			int  a=0;
			long begin=System.currentTimeMillis();
			while((a=fis.read(b))!=-1){
//				write(byte[] b, int off, int len) 
//				从指定的字节数组写入 len个字节，从偏移 off开始输出到此输出流。
				fos.write(b,0,a);
			}		 
//			flush()刷新此输出流并强制任何缓冲的输出字节被写出。 
			fos.flush();
			fos.close();
			fis.close();
			long end=System.currentTimeMillis();
			System.out.println("所用的时间："+(end-begin)+"ms");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		

	}

}
