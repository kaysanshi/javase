package com.java1995;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedRead_Writer_test {
//bufferedReader����һ����������ַ�������������
//	�����ڲ���һ����һ��char[]�����һ�����ļ��н��ж�ȡָ�����ֽڣ�
	public static void main(String[] args) {
		FileReader fis=null;
		FileWriter fos=null;
		BufferedReader br=null;
		BufferedWriter bw=null;
		try {
			fis=new FileReader("E:\\IoDemoforJava\\File.txt");
			fos=new FileWriter("E:\\IoDemoforJava\\text.txt");
			br=new BufferedReader   (fis);
			bw=new BufferedWriter(fos);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int c=0;
		try {
			br.mark(5000);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			while(c!=-1){
				System.out.print((char)c);
				c=br.read();
				bw.write(c);
			}
			bw.flush();
			//��ȡ�ĵڶ��ַ������ж�ȡ�����ж�ȡ
			System.out.println();
			String s;
			br.reset();
			s=br.readLine();
			while(s!=null){
				System.out.print(s);
				s=br.readLine();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		finally{
			try {
				fis.close();
				fos.close();
				br.close();
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}

}
