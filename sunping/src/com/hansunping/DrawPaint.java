package com.hansunping;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
/*
 * Graphics�����ʾ�����ʵ�ʹ��
 * 
 */
public class DrawPaint extends JFrame{
	jMyPanel mp=null;
	public DrawPaint(){
		mp=new jMyPanel();
		this.add(mp);
		this.setTitle("���ʵ���ʾ");
		this.setSize(300, 400);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new DrawPaint();
	}
}
class jMyPanel extends JPanel{
	
	public void jMypanel(){
		
	}
	//��ͼ��
	public void paint(Graphics g){
		super.paint(g);
		//�����������ɫ
		g.setColor(Color.RED);
		//�����������д��ʽ
		g.setFont(new Font("����",Font.ITALIC,50));
		g.drawString("�л�", 20, 30);
		//������
		g.drawLine(21, 31,51, 61);
		//��Բ
		g.drawOval(30, 30, 30, 30);
		//������
		g.drawRect(50, 50, 50,60);
		//ָ��ͼ���С���յ�ǰ���õķ�ʽ����ָ��ͼ���ָ������Ĵ�С����ʱ���ţ�����ӦĿ��ɻ��Ʊ����ָ�������ڡ� 
//		w3 g.drawImage(img, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, observer);
		//����������(x,y,���곤���ߣ���ʼ�Ƕȣ��սǶ�)
		g.fillArc(50, 40, 20,40, 30,30);
		//������.����������
		g.drawArc(20, 46, 300, 400, 30, -75);
		//
	}
}
