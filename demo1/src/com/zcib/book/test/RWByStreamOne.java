package com.zcib.book.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class RWByStreamOne {
//�ֽ����ͻ����ֽ�
//	������ʽ
	public static void main(String[] args) {
		try {
			FileInputStream fis=new FileInputStream("test.txt");
			FileOutputStream fos=new FileOutputStream("text_new.txt");
			byte[] b=new byte[1];
			int  a=0;
			long begin=System.currentTimeMillis();
			while((a=fis.read(b))!=-1){
//				write(byte[] b, int off, int len) 
//				��ָ�����ֽ�����д�� len���ֽڣ���ƫ�� off��ʼ��������������
				fos.write(b,0,a);
			}		 
//			flush()ˢ�´��������ǿ���κλ��������ֽڱ�д���� 
			fos.flush();
			fos.close();
			fis.close();
			long end=System.currentTimeMillis();
			System.out.println("���õ�ʱ�䣺"+(end-begin)+"ms");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		

	}

}
