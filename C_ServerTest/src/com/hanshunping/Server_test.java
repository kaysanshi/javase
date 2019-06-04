package com.hanshunping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

//我是服務器端
public class Server_test {
	
	public static void main(String[] args) {
		new Server_test();
	}
	
	public Server_test(){
		InputStreamReader ir=null;
		BufferedReader br=null;
		try {
			//在999端口進行監聽;
			ServerSocket  ss=new ServerSocket(9999);
			System.out.println("9999端口已被監聽服務器在等待....");
			//等待 連接
			Socket s=ss.accept();
			System.out.println("已經練級開始接收信息");
			//接收庫福端發來的信息
			ir=new InputStreamReader(s.getInputStream());
			br=new BufferedReader(ir);
		
			int infom=0;
			infom=br.read();
			//接收控制臺輸入的信息;
			while(infom!=-1){
				System.out.print((char)infom);
				infom=br.read();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				br.close();
				ir.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
