package com.zcib.book.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class RByPrintWriter {
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		FileReader fis;
		PrintWriter pw;//�Ӳ����׳��쳣�Ĵ�ӡ��
		BufferedReader br;
			 try {
				 fis=new FileReader("test.txt");
				br=new BufferedReader(fis);
				 pw=new PrintWriter("test_new.txt");
				String s;//���������ַ����Ὺ��16���ֽڽ��ж�ȡ�𣿣���
				while((s=br.readLine())!=null){
					pw.println(s);
					
				}
//		flush()ˢ�´��������ǿ���κλ��������ֽڱ�д����
				pw.close();
				pw.flush();
				br.close();
				fis.close();
			} catch (FileNotFoundException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			 
	}

}
