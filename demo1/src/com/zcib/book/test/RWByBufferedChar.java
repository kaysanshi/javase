package com.zcib.book.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RWByBufferedChar {
//ʹ�� buffered �����ַ����������ȡ
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FileReader fis;
		//��mp4�Ķ��󴫵�bufferedReader��
		BufferedReader br;//���ڶ�ȡ�ַ�����
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
//				readLine()��������ȡһ���ı��У���������Ϊ�ַ�����
				bw.write(s+"\n");
			}
			long end =System.currentTimeMillis();
			System.out.println("��ʱ��"+(end-begin)+"ms");
//			flush()ˢ�´��������ǿ���κλ��������ֽڱ�д����
			bw.flush();
			bw.close();
			fos.close();
			br.close();
			fis.close();
			
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		

	}

}
