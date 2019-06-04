package com.java1995;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArrayOutputStream_test {
//将数据写入到这个字节数组输出流
	public static void main(String[] args) {
		ByteArrayOutputStream bos=new ByteArrayOutputStream();
//		当创建这个对象时：其实就有了：byte[] buff=new byte[size]size默认为32；
		String s="hello my phione";
		byte [] b=s.getBytes();
		try {
			bos.write(b);//其实就是写到buff中了；写到了内存中了，
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(bos);
//		创建一个新分配的字节数组。 其大小是此输出流的当前大小，缓冲区的有效内容已被复制到其中。
		byte [] b1=bos.toByteArray();
		for(int i=0;i<bos.size();i++){
			System.out.print((char)b1[i]);
		}
		try {
			bos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
