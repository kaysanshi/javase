package com.java1995;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class OutputStreamWriter_test {
//�ַ�����������ַ�ת��Ϊ�ֽڵķ�ʽ���ַ���ת��Ϊ�ֽ����ķ�ʽ��
//	ת��ʱҲ�ǵ����ݱ༭�����ַ����ı���ķ�ʽ��ת����
	public static void main(String[] args) {
		FileOutputStream fis=null;
		OutputStreamWriter osw=null;
		try {
			fis=new FileOutputStream("E:\\IoDemoforJava\\String");
			osw=new OutputStreamWriter(fis);
			String s="java is my loved ����";
			for(int i=0;i<s.length();i++){
				osw.write(s.charAt(i));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				osw.flush();
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}

}
