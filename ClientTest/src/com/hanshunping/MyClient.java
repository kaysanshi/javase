package com.hanshunping;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

//我的一個客戶端;連接到服務器
public class MyClient {
	public static void main(String[] args) {
		new MyClient();
	}
	public MyClient() {
		PrintWriter pw=null;
		try {
			//Socket函數就是去連接某一個服務器端;
			//先是 ip 后是端口號;
			Socket socket=new Socket("127.0.0.1", 9999);
			//如果要發數據;
			pw=new PrintWriter(socket.getOutputStream(),true);
			pw.println("服務端你好我是客戶端");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			pw.close();
		}
	}
}
