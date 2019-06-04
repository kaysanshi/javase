package com.zcib.book.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class RWByBufferedStream {
//提高速度的方法字节流的读取
	public static void main(String[] args) {
		try {
			FileInputStream fis=new FileInputStream("a.mp4");
			//把mp4的对象传到bufferedRead进行读取中
			BufferedInputStream bis=new BufferedInputStream(fis,1024*100);
			FileOutputStream fos=new FileOutputStream("a_new.mp4");
			BufferedOutputStream bos=new BufferedOutputStream(fos,1024*100);
			byte[] b=new byte[100];
			int a=0;
			long Star=System.currentTimeMillis();
			while((a=bis.read(b))!=-1){
//				write(byte[] b, int off, int len) 
//				从指定的字节数组写入 len个字节，从偏移 off开始输出到此输出流。
				bos.write(b,0,a);
			}
//			flush()刷新此输出流并强制任何缓冲的输出字节被写出。
			bos.flush();
			bos.close();
			fos.close();
			bis.close();
			fis.close();
			long stop=System.currentTimeMillis();
			System.out.println("所用时间："+(stop-Star)+"ms");
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		

	}

}
