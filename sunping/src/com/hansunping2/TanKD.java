package com.hansunping2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
/*
 * 用于演示坦克大战版本的基础知识
 * 1.画出坦克
 * 2.我的坦克的移动，实现发射子弹
 * 3.敌人击中我方，我方死亡，
 * 5.防止敌人坦克有重叠
 * 6.可以分关，可以暂停，并继续，记录玩家的成绩
 * 7.加入声音文件
 */
public class TanKD extends JFrame implements ActionListener{
	//将	JPanel添加到JFrame;并初始化
	MyPanel mp=null;
	//定义panel
	MyStartPanel msp=null;
	//定义菜单
	JMenuBar jmb=null;
	//开始游戏
	JMenu jm1=null;
	JMenuItem jmi1=null;
	//退出游戏
	JMenuItem jmi2=null;
	//存盘退出并记录出敌人的坐标；
	JMenuItem jmi3=null;
	//继续上局游戏
	JMenuItem jmi4=null;
	public TanKD(){
		msp=new MyStartPanel();
		//创建菜单及选项
		jmb=new JMenuBar();
		jm1=new JMenu("游戏(G)");
		//设置快捷
		jm1.setMnemonic('G');
		jmi1=new JMenuItem("开始游戏(b)");
		jmi2=new JMenuItem("退出游戏(e)");
		jmi3=new JMenuItem("存盘退出(s)");
		jmi4=new JMenuItem("继续上次游戏(c)");
		//对jmi1 jmi2做相应事件监听
		jmi1.addActionListener(this);
		jmi1.setActionCommand("newgame");
		jmi2.addActionListener(this);
		jmi2.setActionCommand("exit");
		jmi3.addActionListener(this);
		jmi3.setActionCommand("saveExit");
		jmi4.addActionListener(this);
		jmi4.setActionCommand("conutine");
		jm1.add(jmi1);
		jmb.add(jm1);
		
		jm1.add(jmi1);
		jm1.add(jmi3);
		jm1.add(jmi4);
		jm1.add(jmi2);
		jmb.add(jm1);
		
		Thread t1=new Thread(msp);
		t1.start();
		this.setJMenuBar(jmb);
		this.add(msp);
		this.setSize(600, 400);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
//		对用户不同的点击进行操作
		if(e.getActionCommand().equals("newgame")){
			mp=new MyPanel("newgame");
			//启动jPanel线程
			Thread t=new Thread(mp);
			t.start();
			//先删除开始面板
			this.remove(msp);
			this.add(mp);
			//注册监听
			this.addKeyListener(mp);
			//显示
			this.setVisible(true);
		}else if(e.getActionCommand().equals("exit")){
			//先记录出数据
			Recorder.keepRecording();
			//进行退出
			System.exit(0);
		}else if(e.getActionCommand().equals("saveExit")){
			 Recorder rd=new Recorder();
			 rd.setAts(mp.ats);
			//记录出击毁敌人的坦克及坐标
			 rd.keepRecodEnyTank();
			//退出
			System.exit(0);
		}else if(e.getActionCommand().equals("conutine")){
			mp=new MyPanel("contine");
		
			//启动jPanel线程
			Thread t=new Thread(mp);
			t.start();
			//先删除开始面板
			this.remove(msp);
			this.add(mp);
			//注册监听
			this.addKeyListener(mp);
			//显示
			this.setVisible(true);
			
			//恢复敌人的坐标
			 Recorder rd=new Recorder();
			 rd.getNodesAndEnNums();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TanKD tk=new TanKD ();
	}

	

}
//提示作用
class MyStartPanel extends JPanel implements Runnable{
	
	int times=0;
	public void paint(Graphics g){
		super.paint(g);
		g.fillRect(0, 0,400, 300);
		
		//提示信息
		if(times%2==0){
		g.setColor(Color.YELLOW);
		Font myFont=new Font("华文新魏",Font.BOLD,30);
		g.setFont(myFont);
		g.drawString("stage: 1", 150,150);
		}
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
		try {
			Thread.sleep(700);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		times++;
		//
			this.repaint();
		}
	}
}
//定义自己的面板，实现监听
class MyPanel extends JPanel implements KeyListener,Runnable{
	//定义一个坦克
	MyTanK myt=null;
	//判断是新游戏还是继续上级
	String flag="newgame"; 
	//定义敌人的坦克
	Vector<EnemyTanK> ats=new Vector<EnemyTanK>();
	//定义node
	Vector<Node> nodes=new Vector<Node>();
	int size=5;
	//构造函数初始化
	public MyPanel(String flag){
		
		//恢复记录
		Recorder.getRecording();
		myt=new MyTanK(150,200); 
		
		if(flag.equals("newgame")){
		for(int i=0;i<size;i++){
			EnemyTanK at=new EnemyTanK((i+1)*50,0);
			//at.setColor(1);
			at.setDirect(2);
			//将mypandel的敌人坦克交给敌人坦克
			at.setEts(ats);
			//启动 
			Thread t=new Thread(at);
			t.start();
			//给敌人添加一颗子弹；
			Shot s=new Shot(at.x+10,at.y+30,2);
			//添加到敌人中
			at.ss.add(s);
			Thread t2=new Thread(s);
			t2.start();
			ats.add(at);
			}
		}else{
			
			nodes=new Recorder().getNodesAndEnNums();
			
			for(int i=0;i<nodes.size();i++){
				
				Node node=nodes.get(i);
				EnemyTanK at=new EnemyTanK(node.x,node.y);
				//at.setColor(1);
				at.setDirect(node.direct);
				//将mypandel的敌人坦克交给敌人坦克
				at.setEts(ats);
				//启动 
				Thread t=new Thread(at);
				t.start();
				//给敌人添加一颗子弹；
				Shot s=new Shot(at.x+10,at.y+30,2);
				//添加到敌人中
				at.ss.add(s);
				Thread t2=new Thread(s);
				t2.start();
				ats.add(at);
				}
		}
		//播放开站声音
		 PlaySounds ap=new PlaySounds("C:\\Users\\PC\\Music\\宋禹辰 - 速度与激情坦克大战版.mp3");
		 Thread t=new Thread(ap);
		 t.start();
	}
	//画出提示信息
	public void showInfo(Graphics g){
		//调出提示信息坦克，这个坦克不参与战斗
				this.drawTank(70, 330, g, 0, 1);
				g.setColor(Color.BLACK);
				g.drawString(Recorder.getEnNum()+"", 90, 340);
				//我的坦克
				this.drawTank(130, 330, g, 0, 0);
				g.setColor(Color.BLACK);
				g.drawString(Recorder.getMylife()+"",160,340);
				//画出玩家得总成绩
				g.setColor(Color.BLACK);
				Font f=new Font("宋体",Font.BOLD,20);
				g.setFont(f);
				g.drawString("你的成绩", 410, 30);
				this.drawTank(420, 60, g, 0, 1);
				g.setColor(Color.BLACK);
				g.drawString(Recorder.getAllEnNum()+" ",460, 80);
	}
	//所有的绘图都在这里，主要就是重写其中的方法；
	public void paint(Graphics g){
		super.paint(g);
		//设置活动区域
		g.fillRect(0, 0, 400, 300);
		this.showInfo(g);
		//调用画坦克的函数
		if(myt.isLive){
			this.drawTank(myt.getX(), myt.getY(), g, myt.getDirect(), 0);
		}
		
		//重vector中取出子弹并画出子弹；
		for(int i=0;i<myt.ss.size();i++){
			Shot myShot=myt.ss.get(i);
		//画一个子弹
			if(myShot!=null&& myShot.isLive==true){
				g.draw3DRect(myShot.x,myShot.y, 1, 1, false);
			}
			if(myShot.isLive==false){
				//消除子弹
				myt.ss.remove(myShot);
			}
		}
		
		//画敌人的坦克和子弹
		for(int i=0;i<ats.size();i++){
			EnemyTanK at=ats.get(i);
		if(at.isLive){
		this.drawTank(at.getX(), at.getY(), g, at.getDirect(),1);
			//画子弹
		for(int j=0;j<at.ss.size();j++){
			Shot enmyShot=at.ss.get(j);
			if(enmyShot.isLive){
				g.draw3DRect(enmyShot.x,enmyShot.y, 1, 1, false);
					}else{
						//如果敌人的子弹死亡
						at.ss.remove(enmyShot);
					}
				}
			}
		}
			
	}
	//判断敌人的子弹是否击中我的坦克
	public void hitMeTanK(){
		for(int i=0;i<this.ats.size();i++){
			//取出敌人坦克
			EnemyTanK at=ats.get(i);
			//取出每一子弹
			for(int j=0;j<at.ss.size();j++){
				Shot enemyShot=at.ss.get(j);
				if(myt.isLive){
					if(this.hitTank(enemyShot, myt)){
						Recorder.reduceMylife();
					}
				}
				
			}
		}
	}
	//判断我的子弹击中敌人的坦克
	public void hitEnemyTanK(){
		//是否击中敌人的坦克
		for(int i=0;i<myt.ss.size();i++){
			//取出子弹
			Shot myShot=myt.ss.get(i);
			if(myShot.isLive){
				//子弹活着，取出坦克与他判断
				for(int j=0;j<ats.size();j++){
					//取出坦克
					EnemyTanK at=ats.get(j);
					if(at.isLive){
						if(this.hitTank(myShot, at)){
							//减少敌人的数量，增加成绩；
							Recorder.reduceEnNum();
							Recorder.addEnNum();
						}
						
					}
				}
			}
		}
	}
	//
	//击中函数
	public boolean hitTank(Shot s,TanK at){
		//默认为未击中
		boolean b=false;
		//判断坦克的方向
		switch(at.direct){
		case 0:
		case 2:
			if(s.x>at.x&&s.x<at.x+20&&s.y>at.y&&s.y<at.y+30){
				//击中子弹死亡
				s.isLive=false;
				//敌人死
				b=true;
				at.isLive=false;
				
			}
			break;
		case 1:
		case 3:
			if(s.x>at.x&&s.x<at.x+30&&s.y>at.y&&s.y<at.y+20){
				//击中子弹死亡
				s.isLive=false;	
				b=true;
				//敌人死
				at.isLive=false;
				
			}
		}
		return b;
	}
	//
	//画出坦克的函数
	public void drawTank(int x,int y,Graphics g,int direct,int type){
		switch(type){
		//自己的坦克
		case 0:
			g.setColor(Color.RED);
			break;
		//敌人的坦克
		case 1:
			g.setColor(Color.CYAN);
			break;
		}
		//判断方向
		switch(direct){
		//向上
		case 0:
			//设置画笔颜色
			//g.setColor(Color.BLUE);
			//画出左边的矩形
			g.fill3DRect(x, y,5,30, false);
			//画出右面的矩形；
			g.fill3DRect(x+15, y,5,30,false);
			//画出中间是矩形；
			g.fill3DRect(x+5, y+5,10,20, false);
			//画出圆形；
			g.fillOval(x+5, y+10, 10, 10);
			//画线
			g.drawLine(x+10,  y+16,x+10, y);
			break;
		case 1://向右
			g.fill3DRect(x, y,30,5, false);
			//画出右面的矩形；
			g.fill3DRect(x, y+15,30,5,false);
			//画出中间是矩形；
			g.fill3DRect(x+5, y+5,20,10, false);
			//画出圆形；
			g.fillOval(x+10, y+5, 10, 10);
			//画线
			g.drawLine(x+16,  y+10,x+30, y+10);
			break;
		case 2://向下
			g.fill3DRect(x, y,5,30, false);
			//画出右面的矩形；
			g.fill3DRect(x+15, y,5,30,false);
			//画出中间是矩形；
			g.fill3DRect(x+5, y+5,10,20, false);
			//画出圆形；
			g.fillOval(x+5, y+10, 10, 10);
			//画线
			g.drawLine(x+10,  y+16,x+10, y+30);
			break;
		case 3://向左
			g.fill3DRect(x, y,30,5, false);
			//画出右面的矩形；
			g.fill3DRect(x, y+15,30,5,false);
			//画出中间是矩形；
			g.fill3DRect(x+5, y+5,20,10, false);
			//画出圆形；
			g.fillOval(x+10, y+5, 10, 10);
			//画线
			g.drawLine(x+16,  y+10,x, y+10);
			break;
		}
	}
	//控制其移动的监听
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode()==KeyEvent.VK_W){
			//设置我的坦克的方向
			this.myt.setDirect(0);
				this.myt.moveUp();
		}else if(e.getKeyCode()==KeyEvent.VK_D){
			// 向右
			this.myt.setDirect(1);
			this.myt.moveRight();
		}else if(e.getKeyCode()==KeyEvent.VK_S){
			// 向下
			this.myt.setDirect(2);
			this.myt.moveDown();
		}else if(e.getKeyCode()==KeyEvent.VK_A){
			//  向左
			this.myt.setDirect(3);
			this.myt.movelight();
		}else if(e.getKeyCode()==KeyEvent.VK_SPACE){
			for(int i=0;i<ats.size();i++){
				EnemyTanK at=ats.get(i);
				this.ats.get(i).setSpeed(0);
				this.ats.get(i).setDirect(at.direct);
				for(int j=0;j<at.ss.size();j++){
					Shot enemyShot=at.ss.get(j);
					if(enemyShot.isLive){
						enemyShot.speed=0;	
					}
					
				}
			}
			this.myt.setSpeed(0);
			this.myt.setDirect(this.myt.direct);
		}
		
		//开火
		if(e.getKeyCode()==KeyEvent.VK_J){
			if(this.myt.ss.size()<5){
			this.myt.ShotEnemy();
			} 
		}
		//必须重绘
		this.repaint();
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//掉用
			this.hitEnemyTanK();
			this.hitMeTanK();

			//重绘
			this.repaint();
		}
	}
}

