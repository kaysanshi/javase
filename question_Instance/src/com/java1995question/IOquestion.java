package com.java1995question;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOquestion {
//����һ�������ַ���Ȼ������д�뵽�ļ������������������
	public static void main(String[] args) {
		String s="�й�����";
		FileOutputStream fos=null;
		FileInputStream fis=null;
				try {
					fos=new FileOutputStream("E:\\String");
					fis=new FileInputStream("E:\\String");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				byte []b=s.getBytes();
				try {
					fos.write(b);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				int a=0;
				try {
					a=fis.read();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				while(a!=-1){
					try {
						fis.read();
						System.out.print(a);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

	}

}
