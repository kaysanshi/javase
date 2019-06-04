package com.zcib.book.test;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RWByReaderWriter {
//	 字符流的操作
	public static void main(String[] args) {
		// 
		FileReader fis;
		FileWriter fos;
		try {
			
			 fis=new FileReader("test.txt");
			 fos=new FileWriter("test_new.txt");
			long begin=System.currentTimeMillis();
			char[] b=new char[1];
			int a=0;
			while((a=fis.read(b))!=-1){
//			write(byte[] b, int off, int len) 
//			从指定的字节数组写入 len个字节，从偏移 off开始输出到此输出流。
				fos.write(b,0,a);
			}
			System.out.println(fos.getClass().getName());
			fos.flush();
			fos.close();
			fis.close();
			long end =System.currentTimeMillis();
			System.out.println("用时："+(end-begin)+"ms");
		} catch (FileNotFoundException e) {
			System.out.println("没有这个文件是否要创建：");
			File f=new File("text.txt");
			if(f.exists()){
				System.out.println(f.getAbsolutePath());
			}
		
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		

	}

}
