package com.zcib.book.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RWByBufferedChar {
//使用 buffered 缓冲字符流来输入读取
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FileReader fis;
		//把mp4的对象传到bufferedReader中
		BufferedReader br;//用于读取字符数据
		FileWriter fos;
		BufferedWriter bw;
		try {
			long begin=System.currentTimeMillis();
			fis=new FileReader("test.txt");
			br=new BufferedReader(fis);
			fos = new FileWriter("test_new1.txt");
			bw=new BufferedWriter(fos);
			String s;
			while((s=br.readLine())!=null){
//				readLine()方法：读取一个文本行，并将返回为字符串；
				bw.write(s+"\n");
			}
			long end =System.currentTimeMillis();
			System.out.println("用时："+(end-begin)+"ms");
//			flush()刷新此输出流并强制任何缓冲的输出字节被写出。
			bw.flush();
			bw.close();
			fos.close();
			br.close();
			fis.close();
			
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		

	}

}
