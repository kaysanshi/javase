package com.hansunping;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ACtionListener2 extends JFrame{
	MyPanel mp=null;
	public ACtionListener2(){
		mp=new MyPanel();
		this.add(mp);
		this.setSize(300, 400);
		this.addKeyListener(mp);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		this.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ACtionListener2();
	}

}
class MyPanel extends JPanel implements KeyListener{
	public MyPanel(){
		
	}
	int x=10;
	int y=10;
	//paint方法的调用有：窗口的改变，以及repaint()的方法调用时；
	public void paint(Graphics g){
		super.paint(g);
		g.fillOval(x, y, 30, 30);
	}
	//一个具体的值
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("键按下"+e.getKeyCode());
	}
	//键压下
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("键按下"+e.getKeyCode());
		if(e.getKeyCode()==KeyEvent.VK_DOWN){
			y+=10;
		}else if(e.getKeyCode()==KeyEvent.VK_LEFT){
			x-=10;
		}else if(e.getKeyCode()==KeyEvent.VK_UP){
			y-=10;
		}else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			x+=10;
		}else if (x==200 || y==400){
			System.out.println("到达边界");
		}
		//必须调用这个方法
		this.repaint();
	}
	//放下
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
