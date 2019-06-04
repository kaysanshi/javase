package com.mhl.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;

public class Index extends JWindow implements Runnable {
	/**
	 * 
	 */
	JProgressBar jpb;//定义进度条
	JLabel jl1;//用于在窗体的北部放一张图片，南部是进度条
	int width,height;//用于获取显示屏分辨率大小
	public static void main(String[] args) {
		Index index=new Index();
		Thread t=new Thread(index);
		t.start();
	}
	public Index(){
		jl1=new JLabel(new ImageIcon("image\\index\\index.gif"));
		
		//创建进度条
				jpb=new JProgressBar();
				//设置进度条属性
				jpb.setStringPainted(true);//显示当前进度值信息
				jpb.setString("<<<<系统正在加载<<<<");
				jpb.setIndeterminate(false);//确定进度条执行完成后不来回滚动
				jpb.setBorderPainted(false);//设置进度条边框不显示
				jpb.setBackground(Color.DARK_GRAY);//设置进度条的背景色
				
				//添加组件
				this.add(jl1,BorderLayout.NORTH);
				this.add(jpb,BorderLayout.SOUTH);
				
		this.setSize(400, 263);
		//确定JWindow的位置
		int weight=Toolkit.getDefaultToolkit().getScreenSize().width;//获取屏幕的长
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;//获取屏幕的高；
		//初始位置；
		this.setLocation(weight/2-200, height/2-150);
		this.setVisible(true);//显示或隐藏的方法；
	}
	@Override
	public void run() {
		// 让主界面不死亡；
		//定义一个数组，存放进度条显示时需要的数据
		int []progressValue={0,1,5,8,14,17,26,35,38,43,49,56,65,71,75,78,86,94,98,99,100};
		for(int i=0;i<progressValue.length;i++)
		{
			try {
				//休眠1秒，再执行
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			jpb.setValue(progressValue[i]);//取得数组中的进度值
		}
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//当进度完成后，执行相应的操作，如切换到其他的窗口，同时关闭进度条窗口等
		new UserLogin();
		this.dispose();
		break;
		}
	}
}

//闪屏类
//class paint extends JPanel implements Runnable{
//	public static final int PLAIN = 0;
//	public static final int Font = 0;
//		//定义与进度条相关的组件
//	
//	
//	
//	Thread t;
//	int x=10;
//	int i=0,j=40,u=10;
//	String gg[]={"系","统","正","在","加","载","请","稍","候"};
//	int k=0,tt=0;
//	String shi[]={"满","汉","楼","融","满","汉","精","华","做","做","天","下","美","味"};
//	Font f=new Font("隶书", Font,PLAIN);
//		boolean ifok=true;
//		int weight=100;
//		int height=0;
//		int dian=0;
//	paint(){
//		
//		
//		t=new Thread();
//		t.start();
//	}
//	@Override
//	public void run() {
//			
//}
