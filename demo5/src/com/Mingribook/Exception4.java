package com.Mingribook;

import java.io.FileInputStream;
import java.io.IOException;

public class Exception4 {
	private FileInputStream in=null;
	public void readinfo(){
		try{
			in=new FileInputStream ("src/com/mingribook/CloseIo.java");
			System.out.println("创建IO流，分配内存资源。");
		}catch(IOException io){
			io.printStackTrace();
			System.out.println("创建IO对象异常。");
		}finally{
			if(in!=null){
				try{
					in.close();
					System.out.println("关闭Io流，释放内存");
				}catch(IOException ioe){
					ioe.printStackTrace();
					System.out.println("关闭IO对象发生异常");
				}
			}
		}
	}
	public static void main(String[] args) {
		Exception4 r=new Exception4();
		r.readinfo();
	}
}
