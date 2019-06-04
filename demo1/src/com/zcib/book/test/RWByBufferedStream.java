package com.zcib.book.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class RWByBufferedStream {
//����ٶȵķ����ֽ����Ķ�ȡ
	public static void main(String[] args) {
		try {
			FileInputStream fis=new FileInputStream("a.mp4");
			//��mp4�Ķ��󴫵�bufferedRead���ж�ȡ��
			BufferedInputStream bis=new BufferedInputStream(fis,1024*100);
			FileOutputStream fos=new FileOutputStream("a_new.mp4");
			BufferedOutputStream bos=new BufferedOutputStream(fos,1024*100);
			byte[] b=new byte[100];
			int a=0;
			long Star=System.currentTimeMillis();
			while((a=bis.read(b))!=-1){
//				write(byte[] b, int off, int len) 
//				��ָ�����ֽ�����д�� len���ֽڣ���ƫ�� off��ʼ��������������
				bos.write(b,0,a);
			}
//			flush()ˢ�´��������ǿ���κλ��������ֽڱ�д����
			bos.flush();
			bos.close();
			fos.close();
			bis.close();
			fis.close();
			long stop=System.currentTimeMillis();
			System.out.println("����ʱ�䣺"+(stop-Star)+"ms");
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		

	}

}
