package com.java1995;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class MYJFrame_t extends JFrame{
	/**
	 * �����¼�����ʾ��
	 */
	private static final long serialVersionUID = 1L;
	public MYJFrame_t(){
		this.setTitle("�������ڵĲ���");
		this.setSize(500, 300);
		this.setVisible(true);
//		this.addWindowListener(new MyWindowListener());
//		//ע�ᴰ�ڼ����¼�
		this.addWindowListener(new myWindowListener());
//		//ע�ό������¼�
		this.addWindowFocusListener(new myWindowListener());
	}
	public static void main(String[] args) {
		new MYJFrame_t();
	}

}
//class MyWindowListener extends WindowAdapter{
////ʵ���¼��������൫���Ǽ̳�WindowAdapter�������������ʵ����WindowListener����ӿڣ�
//	public void windowClosing(WindowEvent e){
//		System.out.println("��һ�ֹر�");
//		System.exit(0);
//	}
//}
class myWindowListener implements WindowListener,WindowFocusListener{
//���ʵ���Լ��ļ���������ʹ��̫����һ�㲻����ʵ�֣��ӿ��еķ�����Ҫʵ�֣�
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("�������ڴ�");
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("���彫Ҫ�ر�");
		System.exit(0);
		}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("�����Ѿ��ر�");
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("��С������");
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("���ڱ���ͼ�껯");
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("���ڱ�����");
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("���ڲ��ڴ��ڼ���״̬");
	}

	@Override
	public void windowGainedFocus(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("�����ý���");
	}

	@Override
	public void windowLostFocus(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("����ʧȥ����");
	}
	
}