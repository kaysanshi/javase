package com.zcib.book.test;

import java.io.File;
import java.io.IOException;

public class FileTest {
	public static void main(String[] args) {
		File file=new File("test.txt");
		if(file.exists()){
			if(file.isFile()){
				System.out.println("�ļ�����"+file.getName());
				file.canRead();
			}else{
				System.out.println("·����"+file.getAbsolutePath());
				}
		}else{
			try {
				file.createNewFile();
				System.out.println("�ļ��ѱ�����");
				file.mkdir();
				System.out.println("�ļ����ѱ�����");
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}

	}

}
