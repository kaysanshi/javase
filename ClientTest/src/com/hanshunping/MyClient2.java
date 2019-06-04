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
			//Socket函數就是去連接某一個服務器端;
			//先是 ip 后是端口號;
			Socket socket1=new Socket("127.0.0.1", 9999);
			//
			pw=new PrintWriter(socket1.getOutputStream(),true);
			//控制台的输入:
			 isr=new InputStreamReader(System.in);
			 biReader=new BufferedReader(isr);
			 //接收的服务器发来的信息;
			 isr2=new InputStreamReader(socket1.getInputStream());
			 biReader2=new BufferedReader(isr2);
			while (true) {
				System.out.println("你好服务器我是客户端::");
				//客户断先从控制台接收
				String info =biReader.readLine();
				//然后发送给服务器;
				pw.println(info);
				
				//接收
				String res =biReader2.readLine();
				System.out.println("服务器发来的信息:");
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
