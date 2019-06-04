package com.java1995;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ByteArraysInputStream {
//	
	public static void main(String[] args) {
		String s="qwertyuiop";
		byte [] b=s.getBytes();
//		将b的数组作为缓冲区数组， ByteArray就是一个缓冲区；
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
//			reset的放法是将缓冲区重置到标记得位置；如果为进行标记那么就会返回到缓冲数组的开始位置
//			标记是要用mark()方法进行标记要标记得位置
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
