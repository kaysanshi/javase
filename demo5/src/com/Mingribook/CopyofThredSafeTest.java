package com.Mingribook;

public class CopyofThredSafeTest implements Runnable {
	int num=50;
	@Override
	public void run() {
		while(true){
			synchronized(""){
				if(num>0){
					try{
						Thread.sleep(1000);
					}catch(Exception e){
						e.printStackTrace();
						}
					System.out.println("tickets��Ʊ����"+num--+"��");
					}
				}
			}
		
		}
	public static void main(String[] args) {
//		��ʹ�ýӿ��߳�ʱ���Ƚ��нӿ�ʵ����Ĵ�������
//		����Thread���½������ڽ��а� 
		CopyofThredSafeTest t=new CopyofThredSafeTest();
		Thread ta=new Thread(t);
		Thread tb=new Thread(t);
		Thread tc=new Thread(t);
		Thread td=new Thread(t);
		ta.start();
		tb.start();
		tc.start();
		td.start();
	}


}
