package com.qq.client.model;
///�ͻ���;�����������ý���Ӧ��;
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
	//��̬�Ļ���ֲ���;      
	public  Socket socket;
	//���͵�һ������
	public boolean sendLoginToSrever(Object o) {
		boolean b=false;
		try {
			System.out.println("Ҫ��ʼ��");
		   socket=new Socket("127.0.0.1",3033);
			
			ObjectOutputStream os=new ObjectOutputStream(socket.getOutputStream());
			os.writeObject(o);
			System.out.println("Ҫȥ����");
			
			ObjectInputStream ois=new ObjectInputStream(socket.getInputStream());
			
			Message ms=(Message)ois.readObject();
			//������֤�û���¼;
			if (ms.getMeType().equals("1")){
//				//����һ��QQ�ͷ��������ӵ��߳�
				ClientConServerTh ccst=new ClientConServerTh (socket);
				//���뵽map��
				ManageCLienttoServer.addClientConServerTh(((User)o).getId(),ccst);
				//�����߳�
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
