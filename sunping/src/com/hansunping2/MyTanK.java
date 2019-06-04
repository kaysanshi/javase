package com.hansunping2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;
//播放声音的文件
class PlaySounds extends Thread{
	 private String filename;
	 public PlaySounds(String wavfile) {

	  filename = wavfile;
	 }
	 public void run() {

	  File soundFile = new File(filename);

	  AudioInputStream audioInputStream = null;
	  try {
	   audioInputStream = AudioSystem.getAudioInputStream(soundFile);
	  } catch (Exception e1) {
	   e1.printStackTrace();
	   return;
	  }
	  AudioFormat format = audioInputStream.getFormat();
	  SourceDataLine auline = null;
	  DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
	  try {
	   auline = (SourceDataLine) AudioSystem.getLine(info);
	   auline.open(format);
	  } catch (Exception e) {
	   e.printStackTrace();
	   return;
	  }
	  auline.start();
	  int nBytesRead = 0;
	  //这是缓冲
	  byte[] abData = new byte[512];
	  try {
	   while (nBytesRead != -1) {
	    nBytesRead = audioInputStream.read(abData, 0, abData.length);
	    if (nBytesRead >= 0)
	     auline.write(abData, 0, nBytesRead);
	   }
	  } catch (IOException e) {
	   e.printStackTrace();
	   return;
	  } finally {
	   auline.drain();
	   auline.close();
	  }
	 } 	
}
//记录一个恢复点
class Node{
	int x;
	int y;
	int direct;
	public Node(int x,int y,int direct){
		this.x=x;
		this.y=y;
		this.direct=direct;
	}
}
//记录类同时也可以保存玩家的设置
class Recorder{
	//记录每关有多少敌人
	private static int enNum=20;
	//设置我可有的生命
	private static int mylife=3;
	private static int allEnNum=0;
	//恢复记录点
	static Vector<Node> nodes=new Vector<Node>();
	//
	private static FileWriter fw;
	private static BufferedWriter bw;
	private static FileReader fr;
	private static BufferedReader br;
	private  Vector<EnemyTanK> ats=new Vector<EnemyTanK>();
	//恢复完成读取
	public Vector<Node> getNodesAndEnNums(){
		try {
			fr=new FileReader("F:\\myGrameRecoder");
			br=new BufferedReader(fr);
			String n=""; 
			n=br.readLine();
			allEnNum=Integer.parseInt(n);
			while((n=br.readLine())!=null){
				//读取坐标按照有多少空格返回一个字符串数组
				String[] xyz=n.split(" ");
				Node node=new Node(Integer.parseInt(xyz[0]),Integer.parseInt(xyz[1]),Integer.parseInt(xyz[2]));
				nodes.add(node);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return nodes;
	}
	//保存击毁敌人的坐标及方向
	public  void keepRecodEnyTank(){
		try {
			fw=new FileWriter("F:\\myGrameRecoder");
			bw=new BufferedWriter(fw);
			bw.write(allEnNum+"\r\n");
			//保存当前敌人坦克的坐标方向
			for(int i=0;i<ats.size();i++){
				//取出坦克
				EnemyTanK at=ats.get(i);
				if(at.isLive){
					String recorder=at.x+" "+at.y+" "+at.direct;
					//写入文件
					bw.write(recorder+" "+"\r\n");
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				bw.close();
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	//冲文件中读取
	public static void getRecording(){
		try {
			fr=new FileReader("F:\\myGrameRecoder");
			br=new BufferedReader(fr);
			String n=br.readLine();
			allEnNum=Integer.parseInt(n);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}
	public static void keepRecording(){
		try {
			fw=new FileWriter("F:\\myGrameRecoder");
			bw=new BufferedWriter(fw);
			bw.write(allEnNum+"\r\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				bw.close();
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	public static int getEnNum() {
		return enNum;
	}
	public static void setEnNum(int enNum) {
		Recorder.enNum = enNum;
	}
	public static int getMylife() {
		return mylife;
	}
	public static void setMylife(int mylife) {
		Recorder.mylife = mylife;
	}
	public static int getAllEnNum() {
		return allEnNum;
	}
	public static void setAllEnNum(int allEnNum) {
		Recorder.allEnNum = allEnNum;
	}
	//减少敌人
	public static void reduceEnNum(){
		enNum--;
	}
	
	//自己的生命减少
	public static void reduceMylife(){
		mylife--;
	}
	//消灭敌人
	public static void addEnNum(){
		allEnNum++;
	}
	public  Vector<EnemyTanK> getAts() {
		return ats;
	}
	public  void setAts(Vector<EnemyTanK> ats) {
		this.ats = ats;
	}
	
}
//子弹类
class Shot implements Runnable{
	int x;
	int y;
	int direct;
	int speed=1;
	boolean isLive=true;
	public Shot(int x,int y,int direct){
		this.x=x;
		this.y=y;
		this.direct=direct;
	}
	public Shot() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			switch(direct){
			case 0:
				y-=speed;
				break;
			case 1:
				x+=speed;
				break;
			case 2:
				y+=speed;
				break;
			case 3:
				x-=speed;
				break;
			}
			//子弹什么时候死亡
			//System.out.println("子弹坐标"+x+","+y);
			//判断子弹是否喷到边缘
			if(x<0||x>400||y<0||y>300){
				this.isLive=false;
				break;
			}
		}
	}
}
class MyTanK extends TanK{
	
	int speed=4;
	//创建集合把子弹加入到集合
	Vector<Shot> ss=new Vector<Shot>();
	//子弹
	Shot s=null;
	
	public MyTanK(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	//坦克发射子弹
	public void ShotEnemy(){
		switch(this.direct){
		case 0:
			s=new Shot(x+10,y,0);
			ss.add(s);
			break;
		case 1:
			s=new Shot(x+30,y+10,1);
			ss.add(s);
			break;
		case 2:
			s=new Shot(x+10,y+30,2);
			ss.add(s);
			break;
		case 3:
			s=new Shot(x,y+10,3);
			ss.add(s);
			break;	
		}
		//启动子弹线程
		Thread  t=new Thread(s);
		t.start();
	}
	//坦克向上移动
	public void moveUp(){
		if(y>0){
				y-=speed;	
		}
		
	
	}
	//向右
	public void moveRight(){
		if(x<370){
				x+=speed;
		}
		
		
	}
	//向左
	public void movelight(){
		if(x>0){
			x-=speed;
		}
	}
	//向下
	public void moveDown(){
		if(y<270){
			y+=speed;
		} 
				
		
		
	}
}
//敌人的坦克类；
class EnemyTanK extends TanK implements Runnable{
	
	//boolean isLive=true;
	int times=0;
	//定义一个向量可以访问到mypanel上的坦克
	Vector<EnemyTanK> ats=new Vector<EnemyTanK>();
	//定义一个子弹
	Vector<Shot> ss=new Vector<Shot>();
	//敌人添加子弹应在敌人子弹死亡后，和发射后
	public EnemyTanK(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	//得到mypanel的敌人的坦克
	public void setEts(Vector<EnemyTanK> vv){
		this.ats=vv;
	}
	//判断是否碰到了其他的坦克
	public boolean isTouchOther(){
		//
		boolean b=false;
		
		switch(this.direct){
		case 0:
			//我的坦克向上
			//取出敌人的所有的坦克
			for(int i=0;i<ats.size();i++){
				EnemyTanK at=ats.get(i);
				//如果不是自己
				if(at!=this){
					//如果敌人的坦克的方向向下或者向上
					if(at.direct==0||at.direct==2){
						if(this.x>=at.x && this.x<=at.x+20 && this.y>=at.y && this.y<=at.y+30){
							return true;
						}else if(this.x+20>=at.x && this.x+20<=at.x+20 && this.y>=at.y &&this.y<=at.y+30){
							return true;
						}
					}else if(at.direct==1||at.direct==3){
						//如果敌人的坦克方向向左或向右
						if(this.x>=at.x && this.x<=at.x+30 && this.y>=at.y && this.y<=at.y+20){
							return true;
						}else if(this.x+20>=at.x && this.x+20<=at.x+30 && this.y>=at.y &&this.y<=at.y+20){
							return true;
						}
					}
				}
			}
			break;
		case 1:
			//坦克向右
			//取出敌人的所有的坦克
			for(int i=0;i<ats.size();i++){
				EnemyTanK at=ats.get(i);
				//如果不是自己
				if(at!=this){
					//如果敌人的坦克的方向向下或者向上
					if(at.direct==0||at.direct==2){
						if(this.x+30>=at.x && this.x<=at.x+30 && this.y>=at.y && this.y<=at.y+30){
							return true;
						}else if(this.x+30>=at.x && this.x+30<=at.x+20 && this.y+20>=at.y &&this.y+20<=at.y+30){
							return true;
						}
					}else if(at.direct==1||at.direct==3){
						//如果敌人的坦克方向向左或向右
						if(this.x+30>=at.x && this.x+30<=at.x+30 && this.y>=at.y && this.y<=at.y+20){
							return true;
						}else if(this.x+30>=at.x && this.x+30<=at.x+30 && this.y+20>=at.y &&this.y+20<=at.y+20){
							return true;
						}
					}
				}
			}
			break;
		case 2:
			//坦克向下
			//取出敌人的所有的坦克
			for(int i=0;i<ats.size();i++){
				EnemyTanK at=ats.get(i);
				//如果不是自己
				if(at!=this){
					//如果敌人的坦克的方向向下或者向上
					if(at.direct==0||at.direct==2){
						//我的左点
						if(this.x>=at.x && this.x<=at.x+20 && this.y+30>=at.y && this.y+30<=at.y+30){
							return true;
						}else if(this.x+20>=at.x && this.x<=at.x+20 && this.y+30>=at.y &&this.y+30<=at.y+30){
							return true;
						}
					}else if(at.direct==1||at.direct==3){
						//如果敌人的坦克方向向左或向右
						if(this.x>=at.x && this.x<=at.x+30 && this.y+30>=at.y && this.y+30<=at.y+20){
							return true;
						}else if(this.x+20>=at.x && this.x+20<=at.x+30 && this.y+30>=at.y &&this.y+30<=at.y+20){
							return true;
						}
					}
				}
			}
			break;
		case 3:
			//坦克向左
			//取出敌人的所有的坦克
			for(int i=0;i<ats.size();i++){
				EnemyTanK at=ats.get(i);
				//如果不是自己
				if(at!=this){
					//如果敌人的坦克的方向向下或者向上
					if(at.direct==0||at.direct==2){
						//我的上一点
						if(this.x>=at.x && this.x<=at.x+20 && this.y>=at.y && this.y<=at.y+30){
							return true;
						}else if(this.x>=at.x && this.x<=at.x+20 && this.y+20>=at.y &&this.y+20<=at.y+30){
							return true;
						}
					}else if(at.direct==1||at.direct==3){
						//如果敌人的坦克方向向左或向右
						if(this.x>=at.x && this.x<=at.x+30 && this.y>=at.y && this.y+20<=at.y+20){
							return true;
						}else if(this.x>=at.x && this.x<=at.x+30 && this.y+20>=at.y &&this.y+20<=at.y+20){
							return true;
						}
					}
				}
			}
			break;
		}
		
		
		return b;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			
			
			switch(this.direct){
			case 0:
				//坦克向上走
				for(int i=0;i<30;i++){
					if(y>0 && !this.isTouchOther() ){
						y-=speed;
					}
					try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
			}
				break;
			case 1:
				for(int i=0;i<30;i++){
					if(x<370 &&!this.isTouchOther()){
						x+=speed;
					}
				try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
			}
				break;
			case 2:
				for(int i=0;i<30;i++){
					if(y<270&& !this.isTouchOther()){
						y+=speed;
					}
				try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
			}
				break;
			case 3:
				for(int i=0;i<30;i++){
					if(x>0&& !this.isTouchOther()){
						x-=speed;
					}
				try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
			}
				break;
			} 
			//让坦克产生方向
			this.direct=(int)(Math.random()*4);
			//判断敌人坦克是否死亡
			if(this.isLive==false){
				//死亡后退出；
				break;
			}
			this.times++;
			if(times%2==0){
				if(isLive){
					if(ss.size()<5){
						//添加子弹
						Shot s=null;
					switch(direct){
					case 0:
						s=new Shot(x+10,y,0);
						ss.add(s);
						break;
					case 1:
						s=new Shot(x+30,y+10,1);
						ss.add(s);
						break;
					case 2:
						s=new Shot(x+10,y+30,2);
						ss.add(s);
						break;
					case 3:
						s=new Shot(x,y+10,3);
						ss.add(s);
						break;	
						}
						//启动子弹线程
					Thread t=new Thread(s);
					t.start();
					}
				}
			}
		}	
	}
}

//坦克类
class TanK {
	//构建坐标初始化
	 int x=0;
	 int y=0;
	//坦克的速度
	 int speed=2;
	//方向
	 int direct=0;
	 int color;
	 //
	 boolean isLive=true;
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}
	public TanK(int x,int y){
		this.x=x;
		this.y=y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getDirect() {
		return direct;
	}
	public void setDirect(int direct) {
		this.direct = direct;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
}

