package com.zcib2.job3;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ball 
{ 
public static void main(String args[]) 
{ 
new frame(); 
} 
} 
class frame extends JFrame implements ActionListener,ChangeListener 
{ 
JPanel jp_HuaBan; 
JPanel jp_YuLan; 
JSlider js_red; 
JSlider js_green; 
JSlider js_blue; 
JSlider js_size; 
int x=45,y=45; 
int ball_size=30; 

public frame() 
{ 
super("ball"); 

//创建画板 
jp_HuaBan=new JPanel(); 
jp_HuaBan.setBounds(20,0,450,200); 
jp_HuaBan.setBackground(Color.white); 

//创建球的予览框 
jp_YuLan=new JPanel(); 
jp_YuLan.setBounds(350,220,120,120); 
jp_YuLan.setBackground(Color.white); 

//创建一个文本框作为状态栏 
JTextField jt_status=new JTextField("请选择球的颜色、大小然后点击按钮"); 
jt_status.setBounds(1,404,492,20); 
jt_status.setEditable(false); 

//创建红、绿、蓝三个标签 
JLabel jl_red=new JLabel("红"); 
jl_red.setBounds(20,215,30,20); 
JLabel jl_green=new JLabel("绿"); 
jl_green.setBounds(20,260,30,20); 
JLabel jl_blue=new JLabel("蓝"); 
jl_blue.setBounds(20,305,30,20); 
JLabel jl_size=new JLabel("大小"); 
jl_size.setBounds(20,350,30,20); 

//创建红、绿、蓝三个滑块 
js_red=new JSlider(SwingConstants.HORIZONTAL,0,255,127); 
js_red.setBounds(50,210,250,45); 
//填充滑块 
js_red.putClientProperty("JSlider.isFilled",Boolean.TRUE); 
//绘制勾号标记 
js_red.setPaintTicks(true); 
//主要的勾号标记大小 
js_red.setMajorTickSpacing(50); 
//次要的勾号标记大小 
js_red.setMinorTickSpacing(25); 
//显示主要刻度的数字标记 
js_red.setPaintLabels(true); 
//添加监听者 
js_red.addChangeListener(this); 

js_green=new JSlider(SwingConstants.HORIZONTAL,0,255,127); 
js_green.setBounds(50,255,250,45); 
js_green.putClientProperty("JSlider.isFilled",Boolean.TRUE); 
js_green.setPaintTicks(true); 
js_green.setMajorTickSpacing(50); 
js_green.setMinorTickSpacing(25); 
js_green.setPaintLabels(true); 
js_green.addChangeListener(this); 
js_blue=new JSlider(SwingConstants.HORIZONTAL,0,255,127); 
js_blue.setBounds(50,300,250,45); 
js_blue.putClientProperty("JSlider.isFilled",Boolean.TRUE); 
js_blue.setPaintTicks(true); 
js_blue.setMajorTickSpacing(50); 
js_blue.setMinorTickSpacing(25); 
js_blue.setPaintLabels(true); 
js_blue.addChangeListener(this); 
//创建球的大小的滑块 
js_size=new JSlider(SwingConstants.HORIZONTAL,10,50,30); 
js_size.setBounds(50,345,250,45); 
js_size.putClientProperty("JSlider.isFilled",Boolean.TRUE); 
js_size.setPaintTicks(true); 
js_size.setMajorTickSpacing(10); 
js_size.setMinorTickSpacing(5); 
js_size.setPaintLabels(true); 
js_size.addChangeListener(this); 

//创建按钮 
JButton jb=new JButton("ball"); 
jb.setBounds(350,360,120,30); 
jb.addActionListener(this); 

//将所有对象添加到窗体 
Container c=this.getContentPane(); 
c.setLayout(null); 
c.add(jp_HuaBan); 
c.add(jp_YuLan); 
c.add(jl_red); 
c.add(jl_green); 
c.add(jl_blue); 
c.add(jl_size); 
c.add(js_red); 
c.add(js_green); 
c.add(js_blue); 
c.add(js_size); 
c.add(jb); 
c.add(jt_status); 
//设置窗体的位置和大小 
this.setBounds(100,50,500,450); 
this.setResizable(false); 
this.setVisible(true); 
this.addWindowListener(new WindowAdapter() 
{ 
public void windowClosing(WindowEvent e) 
{ 
System.exit(0); 
} 
}); 
} 

public void actionPerformed(ActionEvent e) 
{ 
Color ball_color=new Color(js_red.getValue(), 
js_green.getValue(),js_blue.getValue()); 
rball r=new rball(jp_HuaBan,js_size.getValue(),ball_color); 
r.start(); 
lball l=new lball(jp_HuaBan,js_size.getValue(),ball_color); 
l.start(); 
} 

public void stateChanged(ChangeEvent e) 
{ 
//获得jp_YuLan的画笔并在jp_YuLan的中心画个圆 
Graphics g=jp_YuLan.getGraphics(); 
g.setColor(Color.white); 
g.fillOval(x,y,ball_size,ball_size); 
x=60-js_size.getValue()/2; 
y=60-js_size.getValue()/2; 
ball_size=js_size.getValue(); 
g.setColor(new Color(js_red.getValue(), 
js_green.getValue(),js_blue.getValue())); 
g.fillOval(x,y,ball_size,ball_size); 
g.dispose(); 
} 
} 

class lball extends Thread 
{ 
//从窗口左面出现的球 
JPanel jp_HuaBan; 
int ball_size; 
Color ball_color; 

public lball(JPanel j,int i,Color c) 
{ 
//获得画板的句柄 
jp_HuaBan=j; 
//获得球的大小 
ball_size=i; 
//获得球的颜色 
ball_color=c; 
} 

public void run() 
{ 
Graphics g=jp_HuaBan.getGraphics(); 
int x=0, y=0; 
//计算画球时X轴,Y轴的最大坐标 
int HuaBan_x=450-ball_size; 
int HuaBan_y=200-ball_size; 
//球移动的增量 
int x_increase=5,y_increase=5; 
while(true) 
{ 
//将上一次画的球擦掉 
g.setColor(Color.white); 
g.fillOval(x,y,ball_size,ball_size); 
//画球 
g.setColor(ball_color); 
x=x+x_increase; 
y=y+y_increase; 
g.fillOval(x,y,ball_size,ball_size); 
//判断球是否到达了边界,若到达了则转向 
if(x<=0 || x>=HuaBan_x) x_increase=-x_increase; 
if(y<=0 || y>=HuaBan_y) y_increase=-y_increase; 
try 
{ 
//休眠一段时间 
Thread.sleep(60); 
} 
catch(Exception e){} 
} 
} 
} 

class rball extends Thread 
{ 
//从窗口左面出现的球 
JPanel jp_HuaBan; 
int ball_size; 
Color ball_color; 

public rball(JPanel j,int i,Color c) 
{ 
jp_HuaBan=j; 
ball_size=i; 
ball_color=c; 
} 

public void run() 
{ 
Graphics g=jp_HuaBan.getGraphics(); 
int x=450-ball_size,y=0; 
int HuaBan_x=x; 
int HuaBan_y=200-ball_size; 
int x_increase=-5,y_increase=5; 
while(true) 
{ 

g.setColor(Color.white); 
g.fillOval(x,y,ball_size,ball_size); 
g.setColor(ball_color); 
x=x+x_increase; 
y=y+y_increase; 
g.fillOval(x,y,ball_size,ball_size); 
if(x<=0 || x>=HuaBan_x) x_increase=-x_increase; 
if(y<=0 || y>=HuaBan_y) y_increase=-y_increase; 
try 
{ 
Thread.sleep(30); 
} 
catch(Exception e){} 
} 
} 
}
