package com.java1995;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriter_test {
//�ַ��Ĵ���ͨ��������ַ�д�뵽�ļ���
//	�������Ҳ���ܵ����Ƶı༭�뼯�����ƣ����ǲ��ܽ���ָ�����뼯�ķ�ʽ��
	public static void main(String[] args) {
		FileWriter fw=null;
		try {
			fw=new FileWriter("E:\\IoDemoforJava\\text.txt");
			String s="qwerty123���";
			for(int i=0;i<s.length();i++){
				fw.write(s.charAt(i));
			}
			fw.flush();//����ˢ����������
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
