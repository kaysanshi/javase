package com.hanshunping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyClient2 {
	public static void main(String[] args) {
		new MyClient2();
	}
	public  MyClient2(){
		PrintWriter pw=null;
		 InputStreamReader isr=null;
		 BufferedReader biReader=null;
		 InputStreamReader isr2=null;
		 BufferedReader biReader2=null;
		try {
			//Socket��������ȥ�B��ĳһ����������;
			//���� ip ���Ƕ˿�̖;
			Socket socket1=new Socket("127.0.0.1", 9999);
			//
			pw=new PrintWriter(socket1.getOutputStream(),true);
			//����̨������:
			 isr=new InputStreamReader(System.in);
			 biReader=new BufferedReader(isr);
			 //���յķ�������������Ϣ;
			 isr2=new InputStreamReader(socket1.getInputStream());
			 biReader2=new BufferedReader(isr2);
			while (true) {
				System.out.println("��÷��������ǿͻ���::");
				//�ͻ����ȴӿ���̨����
				String info =biReader.readLine();
				//Ȼ���͸�������;
				pw.println(info);
				
				//����
				String res =biReader2.readLine();
				System.out.println("��������������Ϣ:");
				pw.println(res);
				pw.flush();
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			try {
				pw.close();
				biReader.close();
				isr.close();
				biReader2.close();
				isr2.close(); 
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}

}
