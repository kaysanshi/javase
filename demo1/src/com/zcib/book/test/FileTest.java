package com.zcib.book.test;

import java.io.File;
import java.io.IOException;

public class FileTest {
	public static void main(String[] args) {
		File file=new File("test.txt");
		if(file.exists()){
			if(file.isFile()){
				System.out.println("文件名："+file.getName());
				file.canRead();
			}else{
				System.out.println("路径："+file.getAbsolutePath());
				}
		}else{
			try {
				file.createNewFile();
				System.out.println("文件已被创建");
				file.mkdir();
				System.out.println("文件夹已被创建");
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}

	}

}
