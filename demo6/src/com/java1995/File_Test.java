package com.java1995;

import java.io.File;
import java.io.IOException;

public class File_Test {

	public static void main(String[] args) throws IOException {
		File file=new File("F:\\MicrosoftWord");
		File[] f=file.listFiles();
		for(File x:f){
//			获取文件中的名字
			System.out.println(x.getName());
//			获取文件的路径
			System.out.println(x.getPath());
//			判断是否是文件
			System.out.println(x.isFile());
//			判断是否是测试此抽象路径名表示的文件是否为目录。 
			System.out.println(x.isDirectory());
//			测试此抽象路径名表示的文件或目录是否存在。 
			System.out.println(x.exists());
//			返回此抽象路径名的规范形式。 
			System.out.println(x.getCanonicalFile());
		}
		/**
		 *  mkdir() 创建由此抽象路径名命名的目录。  
			boolean mkdirs() 创建由此抽象路径名命名的目录，
			包括任何必需但不存在的父目录 
		 */
		File f1=new File("F:\\MicrosoftWord\\name.txt");
		f1.mkdirs();
//		f1.delete();//不会删除父目录qq
		//请求在虚拟机终止时删除由此抽象路径名表示的文件或目录。
		f1.deleteOnExit();
	}

}
