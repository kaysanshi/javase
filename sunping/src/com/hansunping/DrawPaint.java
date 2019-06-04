package com.hansunping;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
/*
 * Graphics类的演示；画笔的使用
 * 
 */
public class DrawPaint extends JFrame{
	jMyPanel mp=null;
	public DrawPaint(){
		mp=new jMyPanel();
		this.add(mp);
		this.setTitle("画笔的演示");
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
	//绘图、
	public void paint(Graphics g){
		super.paint(g);
		//设置字体的颜色
		g.setColor(Color.RED);
		//设置字体的书写形式
		g.setFont(new Font("隶书",Font.ITALIC,50));
		g.drawString("中华", 20, 30);
		//画线条
		g.drawLine(21, 31,51, 61);
		//画圆
		g.drawOval(30, 30, 30, 30);
		//画矩形
		g.drawRect(50, 50, 50,60);
		//指定图像大小按照当前可用的方式绘制指定图像的指定区域的大小，即时缩放，以适应目标可绘制表面的指定区域内。 
//		w3 g.drawImage(img, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, observer);
		//画弧形区域(x,y,坐标长，高，起始角度，终角度)
		g.fillArc(50, 40, 20,40, 30,30);
		//画弧线.正负代表方向；
		g.drawArc(20, 46, 300, 400, 30, -75);
		//
	}
}
