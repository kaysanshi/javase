package com.hanshunping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

//���Ƿ�������
public class Server_test {
	
	public static void main(String[] args) {
		new Server_test();
	}
	
	public Server_test(){
		InputStreamReader ir=null;
		BufferedReader br=null;
		try {
			//��999�˿��M�бO ;
			ServerSocket  ss=new ServerSocket(9999);
			System.out.println("9999�˿��ѱ��O �������ڵȴ�....");
			//�ȴ� �B��
			Socket s=ss.accept();
			System.out.println("�ѽ������_ʼ������Ϣ");
			//���Վ츣�˰l�����Ϣ
			ir=new InputStreamReader(s.getInputStream());
			br=new BufferedReader(ir);
		
			int infom=0;
			infom=br.read();
			//���տ����_ݔ�����Ϣ;
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
