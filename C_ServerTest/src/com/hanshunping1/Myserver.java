package com.hanshunping1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Myserver {
	ServerSocket s;
	public Myserver() {
		// TODO Auto-generated constructor stub
		
		try {
			s = new ServerSocket(3033);
			System.out.println("�ȴ�����");
			Socket socket=s.accept();
			//һ����������ʽ��ȡ
			ObjectInputStream ois1=new ObjectInputStream(socket.getInputStream());
			User user=(User)ois1.readObject();
			System.out.println("�ӿͻ��˵Ľ��յ�"+user.getName()+";"+user.getPass());
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				s.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	public static void main(String[] args) {
		new Myserver();
	}
}
