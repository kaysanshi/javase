package com.java1995;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArrayOutputStream_test {
//������д�뵽����ֽ����������
	public static void main(String[] args) {
		ByteArrayOutputStream bos=new ByteArrayOutputStream();
//		�������������ʱ����ʵ�����ˣ�byte[] buff=new byte[size]sizeĬ��Ϊ32��
		String s="hello my phione";
		byte [] b=s.getBytes();
		try {
			bos.write(b);//��ʵ����д��buff���ˣ�д�����ڴ����ˣ�
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(bos);
//		����һ���·�����ֽ����顣 ���С�Ǵ�������ĵ�ǰ��С������������Ч�����ѱ����Ƶ����С�
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
