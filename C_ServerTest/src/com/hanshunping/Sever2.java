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
			//在9999端口进行监听
			ServerSocket ss=new ServerSocket(9999);
			System.out.println("我在等待连接>>>>....");
			//等待连接
			Socket socket=ss.accept();
			//先接受客户端发来的信息
			isr=new InputStreamReader(socket.getInputStream());
			biReader=new BufferedReader(isr);
			//
			 pw=new PrintWriter(socket.getOutputStream(),true);
			 
			 //从控制台输入的信息;
			  isr2=new InputStreamReader(System.in);
			  biReader2=new BufferedReader(isr2);
			 
			 while(true){
				 String  info=biReader.readLine();
				 System.out.println("客户端发来的信息::"+info);
				 //j接收从控制台的信息
				 System.out.println("输入你对客户端说的话::");
				 String response=biReader2.readLine();
				 //把从控制台接收 
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
