package com.java1995;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class MYJFrame_t extends JFrame{
	/**
	 * 监听事件的演示，
	 */
	private static final long serialVersionUID = 1L;
	public MYJFrame_t(){
		this.setTitle("监听窗口的测试");
		this.setSize(500, 300);
		this.setVisible(true);
//		this.addWindowListener(new MyWindowListener());
//		//注册窗口监听事件
		this.addWindowListener(new myWindowListener());
//		//注册焦点监听事件
		this.addWindowFocusListener(new myWindowListener());
	}
	public static void main(String[] args) {
		new MYJFrame_t();
	}

}
//class MyWindowListener extends WindowAdapter{
////实现事件适配器类但是是继承WindowAdapter这个类而这个类又实现了WindowListener这个接口；
//	public void windowClosing(WindowEvent e){
//		System.out.println("第一种关闭");
//		System.exit(0);
//	}
//}
class myWindowListener implements WindowListener,WindowFocusListener{
//这个实现自己的监听器方法使用太复杂一般不这样实现；接口中的方法都要实现；
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("窗口正在打开");
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("窗体将要关闭");
		System.exit(0);
		}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("窗口已经关闭");
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("最小化监听");
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("窗口被非图标化");
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("窗口被激活");
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("窗口不在处于激活状态");
	}

	@Override
	public void windowGainedFocus(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("窗体获得焦点");
	}

	@Override
	public void windowLostFocus(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("窗体失去焦点");
	}
	
}