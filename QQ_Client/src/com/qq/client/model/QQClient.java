package com.qq.client.model;
///客户端;传输数据来用交互应用;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import com.qq.client.tools.ClientConServerTh;
import com.qq.client.tools.ManageCLienttoServer;
import com.qq.common.Message;
import com.qq.common.User;



public class QQClient {
	//静态的会出现并发;      
	public  Socket socket;
	//发送第一次请求
	public boolean sendLoginToSrever(Object o) {
		boolean b=false;
		try {
			System.out.println("要开始连");
		   socket=new Socket("127.0.0.1",3033);
			
			ObjectOutputStream os=new ObjectOutputStream(socket.getOutputStream());
			os.writeObject(o);
			System.out.println("要去传输");
			
			ObjectInputStream ois=new ObjectInputStream(socket.getInputStream());
			
			Message ms=(Message)ois.readObject();
			//这是验证用户登录;
			if (ms.getMeType().equals("1")){
//				//创建一个QQ和服务器连接的线程
				ClientConServerTh ccst=new ClientConServerTh (socket);
				//放入到map中
				ManageCLienttoServer.addClientConServerTh(((User)o).getId(),ccst);
				//启动线程
				ccst.start();
				b=true;
				
			}
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
//			try {
//				socket.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
		}
		return b;
	}
	public void sentInfotoServer(){
		
	}
	
	
}
