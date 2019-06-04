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
		this.setTitle("����¼�");
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
//����¼�
class myAction implements MouseListener,KeyListener,MouseMotionListener{
	//����ʱ����
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("����"+e.getX()+","+e.getY());
	}
	//������ʽ����
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("������");
	}
	//�ͷ�ʱ����
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("���ͷ�");
	}
	//�������ʱ����
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("��������");
	}
	//�Ƴ�ʱ����
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("���Ƴ�");
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
		System.out.println("����"+(char)e.getKeyCode());
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	//	��ק
	//MouseMotionListener
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("tuo");
	}
	//�ƶ�
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("�ƶ�");
	}
	
}
