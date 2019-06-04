package com.hansunping;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ActionListener3 extends JFrame{
	mJPanel mp=null;
	public ActionListener3 (){
		mp=new mJPanel();
		this.add(mp);
		this.setTitle("鼠标事件");
		this.setSize(300, 400);
		this.addMouseListener(new myAction());
		this.addKeyListener(new myAction());
		this.addMouseMotionListener(new myAction());
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		this.setVisible(true);
	
	}
	public static void main(String[] args) {
		new ActionListener3 ();
	}
}
class mJPanel extends JPanel{
	myAction ma=null;
	public void mJPanel(){
		ma=new myAction();
	}
	public void paint(Graphics g){
		super.paint(g);
	}
	
}
//鼠标事件
class myAction implements MouseListener,KeyListener,MouseMotionListener{
	//单击时触发
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("单击"+e.getX()+","+e.getY());
	}
	//被按下式触发
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("键按下");
	}
	//释放时触发
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("键释放");
	}
	//移入组件时触发
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("移入里面");
	}
	//移出时触发
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("键移出");
	}
	
	//KeyListener,
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("");
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("按键"+(char)e.getKeyCode());
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	//	拖拽
	//MouseMotionListener
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("tuo");
	}
	//移动
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("移动");
	}
	
}
