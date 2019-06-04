package com.java1995;

import java.io.File;
import java.io.IOException;

public class File_Test {

	public static void main(String[] args) throws IOException {
		File file=new File("F:\\MicrosoftWord");
		File[] f=file.listFiles();
		for(File x:f){
//			��ȡ�ļ��е�����
			System.out.println(x.getName());
//			��ȡ�ļ���·��
			System.out.println(x.getPath());
//			�ж��Ƿ����ļ�
			System.out.println(x.isFile());
//			�ж��Ƿ��ǲ��Դ˳���·������ʾ���ļ��Ƿ�ΪĿ¼�� 
			System.out.println(x.isDirectory());
//			���Դ˳���·������ʾ���ļ���Ŀ¼�Ƿ���ڡ� 
			System.out.println(x.exists());
//			���ش˳���·�����Ĺ淶��ʽ�� 
			System.out.println(x.getCanonicalFile());
		}
		/**
		 *  mkdir() �����ɴ˳���·����������Ŀ¼��  
			boolean mkdirs() �����ɴ˳���·����������Ŀ¼��
			�����κα��赫�����ڵĸ�Ŀ¼ 
		 */
		File f1=new File("F:\\MicrosoftWord\\name.txt");
		f1.mkdirs();
//		f1.delete();//����ɾ����Ŀ¼qq
		//�������������ֹʱɾ���ɴ˳���·������ʾ���ļ���Ŀ¼��
		f1.deleteOnExit();
	}

}
