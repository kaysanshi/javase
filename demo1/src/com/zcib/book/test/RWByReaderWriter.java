package com.zcib.book.test;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RWByReaderWriter {
//	 �ַ����Ĳ���
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
//			��ָ�����ֽ�����д�� len���ֽڣ���ƫ�� off��ʼ��������������
				fos.write(b,0,a);
			}
			System.out.println(fos.getClass().getName());
			fos.flush();
			fos.close();
			fis.close();
			long end =System.currentTimeMillis();
			System.out.println("��ʱ��"+(end-begin)+"ms");
		} catch (FileNotFoundException e) {
			System.out.println("û������ļ��Ƿ�Ҫ������");
			File f=new File("text.txt");
			if(f.exists()){
				System.out.println(f.getAbsolutePath());
			}
		
			e.printStackTrace();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		

	}

}
