package com.hanshunping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
public class Sever2 {
	InputStreamReader isr=null;
	BufferedReader biReader=null;
	PrintWriter pw=null;
	InputStreamReader isr2=null;
	 BufferedReader biReader2=null;
	 
	 public static void main(String[] args) {
		new Sever2();
	}
	public Sever2 (){
		try {
			//��9999�˿ڽ��м���
			ServerSocket ss=new ServerSocket(9999);
			System.out.println("���ڵȴ�����>>>>....");
			//�ȴ�����
			Socket socket=ss.accept();
			//�Ƚ��ܿͻ��˷�������Ϣ
			isr=new InputStreamReader(socket.getInputStream());
			biReader=new BufferedReader(isr);
			//
			 pw=new PrintWriter(socket.getOutputStream(),true);
			 
			 //�ӿ���̨�������Ϣ;
			  isr2=new InputStreamReader(System.in);
			  biReader2=new BufferedReader(isr2);
			 
			 while(true){
				 String  info=biReader.readLine();
				 System.out.println("�ͻ��˷�������Ϣ::"+info);
				 //j���մӿ���̨����Ϣ
				 System.out.println("������Կͻ���˵�Ļ�::");
				 String response=biReader2.readLine();
				 //�Ѵӿ���̨���� 
				 pw.println(response);
				 pw.flush();
			 }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				biReader.close();
				isr.close();
				biReader2.close();
				isr2.close(); 
				pw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
