package com.java1995;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ByteArraysInputStream {
//	
	public static void main(String[] args) {
		String s="qwertyuiop";
		byte [] b=s.getBytes();
//		��b��������Ϊ���������飬 ByteArray����һ����������
		ByteArrayInputStream bin=new ByteArrayInputStream(b);
		for(int i=0;i<2;i++){
			int c;
			c=bin.read();
			while(c!=-1){
				if(i==0){
					System.out.print((char)c);
				}else{
					System.out.print(Character.toUpperCase((char)c));
				}
				c=bin.read();
			}
			System.out.println();
//			reset�ķŷ��ǽ����������õ���ǵ�λ�ã����Ϊ���б����ô�ͻ᷵�ص���������Ŀ�ʼλ��
//			�����Ҫ��mark()�������б��Ҫ��ǵ�λ��
			bin.reset();
		}
		try {
			bin.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
