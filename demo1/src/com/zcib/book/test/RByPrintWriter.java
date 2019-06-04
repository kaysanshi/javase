package com.zcib.book.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class RByPrintWriter {
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		FileReader fis;
		PrintWriter pw;//从不会抛出异常的打印流
		BufferedReader br;
			 try {
				 fis=new FileReader("test.txt");
				br=new BufferedReader(fis);
				 pw=new PrintWriter("test_new.txt");
				String s;//这是声明字符创会开辟16个字节进行读取吗？？？
				while((s=br.readLine())!=null){
					pw.println(s);
					
				}
//		flush()刷新此输出流并强制任何缓冲的输出字节被写出。
				pw.close();
				pw.flush();
				br.close();
				fis.close();
			} catch (FileNotFoundException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			 
	}

}
