package com.java1995;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedInOutputStream_test {
//��fis�������read�ķ���ʱ��ÿһ�ξ�Ҫ���ļ����ж�ȡһ���ֽ�һ���ֽڵĶ���
//bis�������read��ʱ��һ�η���ʱ�ͻ���ܶ�Ĭ�ϵ��ֽڴ�����buf����Ļ������У����������������ļ�����ʱ�Ĵ�������������
//	�����������ݲ�����Ҫ���ļ�����̫���io������
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
