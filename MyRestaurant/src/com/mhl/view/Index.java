package com.mhl.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;

public class Index extends JWindow implements Runnable {
	/**
	 * 
	 */
	JProgressBar jpb;//���������
	JLabel jl1;//�����ڴ���ı�����һ��ͼƬ���ϲ��ǽ�����
	int width,height;//���ڻ�ȡ��ʾ���ֱ��ʴ�С
	public static void main(String[] args) {
		Index index=new Index();
		Thread t=new Thread(index);
		t.start();
	}
	public Index(){
		jl1=new JLabel(new ImageIcon("image\\index\\index.gif"));
		
		//����������
				jpb=new JProgressBar();
				//���ý���������
				jpb.setStringPainted(true);//��ʾ��ǰ����ֵ��Ϣ
				jpb.setString("<<<<ϵͳ���ڼ���<<<<");
				jpb.setIndeterminate(false);//ȷ��������ִ����ɺ����ع���
				jpb.setBorderPainted(false);//���ý������߿���ʾ
				jpb.setBackground(Color.DARK_GRAY);//���ý������ı���ɫ
				
				//������
				this.add(jl1,BorderLayout.NORTH);
				this.add(jpb,BorderLayout.SOUTH);
				
		this.setSize(400, 263);
		//ȷ��JWindow��λ��
		int weight=Toolkit.getDefaultToolkit().getScreenSize().width;//��ȡ��Ļ�ĳ�
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;//��ȡ��Ļ�ĸߣ�
		//��ʼλ�ã�
		this.setLocation(weight/2-200, height/2-150);
		this.setVisible(true);//��ʾ�����صķ�����
	}
	@Override
	public void run() {
		// �������治������
		//����һ�����飬��Ž�������ʾʱ��Ҫ������
		int []progressValue={0,1,5,8,14,17,26,35,38,43,49,56,65,71,75,78,86,94,98,99,100};
		for(int i=0;i<progressValue.length;i++)
		{
			try {
				//����1�룬��ִ��
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			jpb.setValue(progressValue[i]);//ȡ�������еĽ���ֵ
		}
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//��������ɺ�ִ����Ӧ�Ĳ��������л��������Ĵ��ڣ�ͬʱ�رս��������ڵ�
		new UserLogin();
		this.dispose();
		break;
		}
	}
}

//������
//class paint extends JPanel implements Runnable{
//	public static final int PLAIN = 0;
//	public static final int Font = 0;
//		//�������������ص����
//	
//	
//	
//	Thread t;
//	int x=10;
//	int i=0,j=40,u=10;
//	String gg[]={"ϵ","ͳ","��","��","��","��","��","��","��"};
//	int k=0,tt=0;
//	String shi[]={"��","��","¥","��","��","��","��","��","��","��","��","��","��","ζ"};
//	Font f=new Font("����", Font,PLAIN);
//		boolean ifok=true;
//		int weight=100;
//		int height=0;
//		int dian=0;
//	paint(){
//		
//		
//		t=new Thread();
//		t.start();
//	}
//	@Override
//	public void run() {
//			
//}
