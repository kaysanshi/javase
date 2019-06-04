package com.mhl.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.Timer;

//import com.mhl.tools.MediaHelp;

import Tools.ImagePanel;
import Tools.Tools;
//三大可以进去;经理,管理员,收银员,
//顺序:从上到下,从左到右;
public class Window1 extends JFrame implements ActionListener,MouseListener{
	//组件
	Image titleIcon,p1_bg,p3Icon,chart;
	ImagePanel p1_bgImage,jp3Image,ct;
	JMenuBar jmb;
	//一级菜单
	JMenu jm1,jm2,jm3,jm4,jm5,jm6;
	//二级菜案
	JMenuItem jmm1,jmm2,jmm3,jmm4,jmm5;
	//图标
	ImageIcon jmm1_image,jmm2_image,jmm3_image,jmm4_image,jmm5_image;
	//
	ImageIcon timeimage;
	//可才分窗格;
	JSplitPane jsp;
	//工具栏
	JToolBar jtb;
	JButton jb1,jb2,jb3,jb4,jb5,jb6,jb7,jb8,jb9,jb10;
	//定义面板
	JPanel jp1,jp2,jp3,jp4,jp5;
	//放时间来用
	JLabel Jtime;
	JLabel p1_jl1,p1_jl2,p1_jl3,p1_jl4,p1_jl5,p1_jl6,p1_jl7,p1_jl8;
	CardLayout myCard;
	JLabel p2_jl1,p2_jl2;
	//这个类中可以触发Action事件可以做一些事件
	Timer t;
	public static void main(String[] args) {
		Window1 w1=new Window1();
	}
	//菜单栏
	public void setJMenu(){
		//创建一级菜单
				jm1=new JMenu("系统管理");
				//创建图标
				jmm1_image=new ImageIcon("image\\jm1_icon1.jpg");
				jmm2_image=new ImageIcon("image\\jm1_icon2.jpg");
				jmm3_image=new ImageIcon("image\\jm1_icon3.jpg");
				jmm4_image=new ImageIcon("image\\jm1_icon4.jpg");
				jmm5_image=new ImageIcon("image\\jm1_icon5.jpg");
				//创建二级菜单并加入图标;
				jmm1=new JMenuItem("切换用户",jmm1_image);
				jmm2=new JMenuItem("切换到收款界面",jmm2_image);
				jmm3=new JMenuItem("登录管理",jmm3_image);
				jmm4=new JMenuItem("万年历",jmm4_image);
				jmm5=new JMenuItem("退出",jmm5_image);
				//
				jmm1.setFont(Tools.f2);
				jmm2.setFont(Tools.f2);
				jmm3.setFont(Tools.f2);
				jmm4.setFont(Tools.f2);
				jmm5.setFont(Tools.f2);
				//加入到一级菜单中;
				jm1.add(jmm1);
				jm1.add(jmm2);
				jm1.add(jmm3);
				jm1.add(jmm4);
				jm1.add(jmm5);
			
				jm2=new JMenu("人事管理");
				jm3=new JMenu("菜单服务");
				jm4=new JMenu("报表统计");
				jm5=new JMenu("成本及库房");
				jm6=new JMenu("帮助");
				//设置字体
				jm1.setFont(Tools.f1);
				jm2.setFont(Tools.f1);
				jm3.setFont(Tools.f1);
				jm4.setFont(Tools.f1);
				jm5.setFont(Tools.f1);
				jm6.setFont(Tools.f1);
				
				jmb=new JMenuBar();
				jmb.add(jm1);
				jmb.add(jm2);
				jmb.add(jm3);
				jmb.add(jm4);
				jmb.add(jm5);
				jmb.add(jm6);
				//添加到JFrame中;
				this.setJMenuBar(jmb);
	}
	//工具栏;
	public void setTools(){
		
		//工具栏的主键
		jtb=new JToolBar();
		//设置不可以浮动
		jtb.setFloatable(false);
		jb1=new JButton(new ImageIcon("image\\toolBar_image\\jb1.jpg"));
		jb2=new JButton(new ImageIcon("image\\toolBar_image\\jb2.jpg"));
		jb3=new JButton(new ImageIcon("image\\toolBar_image\\jb3.jpg"));
		jb4=new JButton(new ImageIcon("image\\toolBar_image\\jb4.jpg"));
		jb5=new JButton(new ImageIcon("image\\toolBar_image\\jb5.jpg"));
		jb6=new JButton(new ImageIcon("image\\toolBar_image\\jb6.jpg"));
		jb7=new JButton(new ImageIcon("image\\toolBar_image\\jb7.jpg"));
		jb8=new JButton(new ImageIcon("image\\toolBar_image\\jb8.jpg"));
		jb9=new JButton(new ImageIcon("image\\toolBar_image\\jb9.jpg"));
		jb10=new JButton(new ImageIcon("image\\toolBar_image\\jb10.jpg"));
		jtb.add(jb1);jtb.add(jb2);
		jtb.add(jb3);jtb.add(jb4);
		jtb.add(jb5);jtb.add(jb6);
		jtb.add(jb7);jtb.add(jb8);
		jtb.add(jb9);jtb.add(jb10);
	}
	//底部;
	public void setEnd(){
		//面板的添加;
				jp5=new JPanel(new BorderLayout());
				t=new Timer(1000,this);
				//
			
				//把时间的背景图加入到窗体中;
				timeimage=new ImageIcon("image\\time_bg.jpg");
				//获得当前时间
				Jtime=new JLabel("当前时间:"+Calendar.getInstance().getTime().toString(),timeimage,0);
					t.start();
				jp5.add(Jtime,"East");
	}
	//中间卡片布局;
	public void setMiddle(){
		//jp1
				jp1=new JPanel(new BorderLayout());
				try {
					p1_bg=ImageIO.read(new File("image/center_image/jp1_bg.jpg"));
				} catch (IOException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
				//定义一个手形光标;
				Cursor myCursor=new Cursor(Cursor.HAND_CURSOR);
				p1_bgImage=new ImagePanel(p1_bg);
				p1_bgImage.setLayout(new GridLayout(8,1));
				p1_jl1=new JLabel(new ImageIcon("image/center_image/label_1.gif"));
				p1_bgImage.add(p1_jl1);
				p1_jl2=new JLabel("人  事  管  理",new ImageIcon("image/center_image/label_2.jpg"),0);
				p1_jl2.setFont(Tools.f4);
				//让label 初始不可用
				p1_jl2.setCursor(myCursor);
				p1_jl2.setEnabled(false);
				p1_jl2.addMouseListener(this);
				p1_bgImage.add(p1_jl2);
				p1_jl3=new JLabel("登  陆  管  理",new ImageIcon("image/center_image/label_3.jpg"),0);
				p1_jl3.setFont(Tools.f4);
				p1_jl3.setCursor(myCursor);
				p1_jl3.setEnabled(false);
				p1_jl3.addMouseListener(this);
				p1_bgImage.add(p1_jl3);
				p1_jl4=new JLabel("菜  谱  价  格",new ImageIcon("image/center_image/label_4.jpg"),0);
				p1_jl4.setFont(Tools.f4);
				p1_jl4.setCursor(myCursor);
				p1_jl4.setEnabled(false);
				p1_jl4.addMouseListener(this);
				p1_bgImage.add(p1_jl4);
				p1_jl5=new JLabel("报  表  统  计",new ImageIcon("image/center_image/label_5.jpg"),0);
				p1_jl5.setFont(Tools.f4);
				p1_jl5.setCursor(myCursor);
				p1_jl5.setEnabled(false);
				p1_jl5.addMouseListener(this);
				p1_bgImage.add(p1_jl5);
				p1_jl6=new JLabel("成  本  库  房",new ImageIcon("image/center_image/label_6.jpg"),0);
				p1_jl6.setFont(Tools.f4);
				p1_jl6.setCursor(myCursor);
				p1_jl6.setEnabled(false);
				p1_jl6.addMouseListener(this);
				p1_bgImage.add(p1_jl6);
				p1_jl7=new JLabel("系  统  设  置",new ImageIcon("image/center_image/label_7.jpg"),0);
				p1_jl7.setFont(Tools.f4);
				p1_jl7.setCursor(myCursor);
				p1_jl7.setEnabled(false);
				p1_jl7.addMouseListener(this);
				p1_bgImage.add(p1_jl7);
				p1_jl8=new JLabel("媒 体 播 放",new ImageIcon("image/center_image/label_8.jpg"),0);
				p1_jl8.setFont(Tools.f4);
				//设置光标图像;
				p1_jl8.setCursor(myCursor);
				p1_jl8.setEnabled(false);
				p1_jl8.addMouseListener(this);
				p1_bgImage.add(p1_jl8);
				jp1.add(p1_bgImage);
				
				//jp4,jp2,jp3
				myCard=new CardLayout();
				jp4=new JPanel(new BorderLayout());
				jp2=new JPanel(new CardLayout());
				p2_jl1=new JLabel(new ImageIcon("image/center_image/jp2_left.jpg"));
				//图标切换
				p2_jl1.addMouseListener(this);
				p2_jl2=new JLabel(new ImageIcon("image/center_image/jp2_right.jpg"));
				p2_jl2.addMouseListener(this);
				jp2.add(p2_jl1,"0");
				jp2.add(p2_jl2,"1");
				
				jp3=new JPanel();
				jp3.setLayout(myCard);
				//先给jp3加入主界面卡片
				try {
					p3Icon=ImageIO.read(new File("image/center_image/jp1_bg.jpg"));
				} catch (IOException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
				jp3Image=new ImagePanel(p3Icon);
				
				jp3.add(jp3Image,"0");
				//人事管理
				 EmpInfo ei=new EmpInfo();
				 jp3.add(ei,"1");
				
				 //登录界面
				 EmpLogin el=new EmpLogin();
				 jp3.add(el,"2");
				
				 //菜单价格
				 MenuInfo mi=new MenuInfo();
				 jp3.add(mi,"3");
				 
				 //报表统计
				 try {
					 chart=ImageIO.read(new File("image/chart.jpg"));
					} catch (IOException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
					ct=new ImagePanel(chart);
					//ct.setBounds(0, 0, this.getWidth()-50, this.getHeight()-10);
					jp3.add(ct,"4");
				 //成本及库房
				 CostNum cn=new CostNum();
				 jp3.add(cn,"5");
				 
				 
				 //系统设置
				 OperatChoose oc=new OperatChoose();
				 jp3.add(oc,"6");
				 
				 //动画音乐
				jp4.add(jp2,"West");
				jp4.add(jp3,"Center");
				jsp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true,jp1,jp4);
				jsp.setDividerLocation(150);
				jsp.setDividerSize(0);
	}
	
	public Window1(){
		try {
			titleIcon=ImageIO.read(new File("image\\title.gif"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		//菜单项
		this.setJMenu();
		//工具栏项
		this.setTools();
		//中间的CardLayout界面
		this.setMiddle();
		//状态栏
		this.setEnd();
		//
		//重JFrame获得Container;以便添加;
		Container con=this.getContentPane();
		con.add(jtb, "North");
		con.add(jp5,"South");
		con.add(jsp,"Center");
		//设置大小
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		//设置窗口的图片
		this.setIconImage(titleIcon);
		this.setFont(Tools.f1);
		this.setTitle("满汉楼餐饮管理系统");

		this.setSize(width, height-45);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		this.setVisible(true);
	}
	//
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.Jtime.setText(Calendar.getInstance().getTime().toString());
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==p1_jl2)
		{
			((CardLayout)this.jp3.getLayout()).show(jp3,"1");
		}
		else if(arg0.getSource()==p1_jl3)
		{
			((CardLayout)jp3.getLayout()).show(jp3,"2");
		}
		else if(arg0.getSource()==p1_jl4)
		{
			((CardLayout)jp3.getLayout()).show(jp3,"3");
		}
		else if(arg0.getSource()==p1_jl5)
		{
			((CardLayout)jp3.getLayout()).show(jp3,"4");
		}
		else if(arg0.getSource()==p1_jl6)
		{
			((CardLayout)jp3.getLayout()).show(jp3,"5");
		}
		else if(arg0.getSource()==p1_jl7)
		{
			((CardLayout)jp3.getLayout()).show(jp3,"6");
		}
		else if(arg0.getSource()==p1_jl8)
		{
//			MediaHelp mh=new MediaHelp();
		}
		else if(arg0.getSource()==p2_jl1)
		{
			this.jsp.setDividerLocation(0);
		}
		else if(arg0.getSource()==p2_jl2)
		{
			this.jsp.setDividerLocation(Toolkit.getDefaultToolkit().getScreenSize().width);
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==p1_jl2)
		{
			//高亮,有选中的感觉;
			this.p1_jl2.setEnabled(true);
		}else if(arg0.getSource()==p1_jl3)
		{
			this.p1_jl3.setEnabled(true);
		}
		else if(arg0.getSource()==p1_jl4)
		{
			this.p1_jl4.setEnabled(true);
		}
		else if(arg0.getSource()==p1_jl5)
		{
			this.p1_jl5.setEnabled(true);
		}
		else if(arg0.getSource()==p1_jl6)
		{
			this.p1_jl6.setEnabled(true);
		}
		else if(arg0.getSource()==p1_jl7)
		{
			this.p1_jl7.setEnabled(true);
		}
		else if(arg0.getSource()==p1_jl8)
		{
			this.p1_jl8.setEnabled(true);
		}
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==p1_jl2)
		{
		this.p1_jl2.setEnabled(false);
		}else if(arg0.getSource()==p1_jl3)
		{
			this.p1_jl3.setEnabled(false);
		}else if(arg0.getSource()==p1_jl4)
		{
			this.p1_jl4.setEnabled(false);
		}
		else if(arg0.getSource()==p1_jl5)
		{
			this.p1_jl5.setEnabled(false);
		}
		else if(arg0.getSource()==p1_jl6)
		{
			this.p1_jl6.setEnabled(false);
		}
		else if(arg0.getSource()==p1_jl7)
		{
			this.p1_jl7.setEnabled(false);
		}
		else if(arg0.getSource()==p1_jl8)
		{
			this.p1_jl8.setEnabled(false);
		}
	}

}
