package com.hanshunping;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

//�ҵ�һ���͑���;�B�ӵ�������
public class MyClient {
	public static void main(String[] args) {
		new MyClient();
	}
	public MyClient() {
		PrintWriter pw=null;
		try {
			//Socket��������ȥ�B��ĳһ����������;
			//���� ip ���Ƕ˿�̖;
			Socket socket=new Socket("127.0.0.1", 9999);
			//���Ҫ�l����;
			pw=new PrintWriter(socket.getOutputStream(),true);
			pw.println("���ն�������ǿ͑���");
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
