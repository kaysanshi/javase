package com.Mingribook;

import java.io.FileInputStream;
import java.io.IOException;

public class Exception4 {
	private FileInputStream in=null;
	public void readinfo(){
		try{
			in=new FileInputStream ("src/com/mingribook/CloseIo.java");
			System.out.println("����IO���������ڴ���Դ��");
		}catch(IOException io){
			io.printStackTrace();
			System.out.println("����IO�����쳣��");
		}finally{
			if(in!=null){
				try{
					in.close();
					System.out.println("�ر�Io�����ͷ��ڴ�");
				}catch(IOException ioe){
					ioe.printStackTrace();
					System.out.println("�ر�IO�������쳣");
				}
			}
		}
	}
	public static void main(String[] args) {
		Exception4 r=new Exception4();
		r.readinfo();
	}
}
