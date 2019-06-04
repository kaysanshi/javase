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
 * ������ʾ̹�˴�ս�汾�Ļ���֪ʶ
 * 1.����̹��
 * 2.�ҵ�̹�˵��ƶ���ʵ�ַ����ӵ�
 * 3.���˻����ҷ����ҷ�������
 * 5.��ֹ����̹�����ص�
 * 6.���Էֹأ�������ͣ������������¼��ҵĳɼ�
 * 7.���������ļ�
 */
public class TanKD extends JFrame implements ActionListener{
	//��	JPanel��ӵ�JFrame;����ʼ��
	MyPanel mp=null;
	//����panel
	MyStartPanel msp=null;
	//����˵�
	JMenuBar jmb=null;
	//��ʼ��Ϸ
	JMenu jm1=null;
	JMenuItem jmi1=null;
	//�˳���Ϸ
	JMenuItem jmi2=null;
	//�����˳�����¼�����˵����ꣻ
	JMenuItem jmi3=null;
	//�����Ͼ���Ϸ
	JMenuItem jmi4=null;
	public TanKD(){
		msp=new MyStartPanel();
		//�����˵���ѡ��
		jmb=new JMenuBar();
		jm1=new JMenu("��Ϸ(G)");
		//���ÿ��
		jm1.setMnemonic('G');
		jmi1=new JMenuItem("��ʼ��Ϸ(b)");
		jmi2=new JMenuItem("�˳���Ϸ(e)");
		jmi3=new JMenuItem("�����˳�(s)");
		jmi4=new JMenuItem("�����ϴ���Ϸ(c)");
		//��jmi1 jmi2����Ӧ�¼�����
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
//		���û���ͬ�ĵ�����в���
		if(e.getActionCommand().equals("newgame")){
			mp=new MyPanel("newgame");
			//����jPanel�߳�
			Thread t=new Thread(mp);
			t.start();
			//��ɾ����ʼ���
			this.remove(msp);
			this.add(mp);
			//ע�����
			this.addKeyListener(mp);
			//��ʾ
			this.setVisible(true);
		}else if(e.getActionCommand().equals("exit")){
			//�ȼ�¼������
			Recorder.keepRecording();
			//�����˳�
			System.exit(0);
		}else if(e.getActionCommand().equals("saveExit")){
			 Recorder rd=new Recorder();
			 rd.setAts(mp.ats);
			//��¼�����ٵ��˵�̹�˼�����
			 rd.keepRecodEnyTank();
			//�˳�
			System.exit(0);
		}else if(e.getActionCommand().equals("conutine")){
			mp=new MyPanel("contine");
		
			//����jPanel�߳�
			Thread t=new Thread(mp);
			t.start();
			//��ɾ����ʼ���
			this.remove(msp);
			this.add(mp);
			//ע�����
			this.addKeyListener(mp);
			//��ʾ
			this.setVisible(true);
			
			//�ָ����˵�����
			 Recorder rd=new Recorder();
			 rd.getNodesAndEnNums();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TanKD tk=new TanKD ();
	}

	

}
//��ʾ����
class MyStartPanel extends JPanel implements Runnable{
	
	int times=0;
	public void paint(Graphics g){
		super.paint(g);
		g.fillRect(0, 0,400, 300);
		
		//��ʾ��Ϣ
		if(times%2==0){
		g.setColor(Color.YELLOW);
		Font myFont=new Font("������κ",Font.BOLD,30);
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
//�����Լ�����壬ʵ�ּ���
class MyPanel extends JPanel implements KeyListener,Runnable{
	//����һ��̹��
	MyTanK myt=null;
	//�ж�������Ϸ���Ǽ����ϼ�
	String flag="newgame"; 
	//������˵�̹��
	Vector<EnemyTanK> ats=new Vector<EnemyTanK>();
	//����node
	Vector<Node> nodes=new Vector<Node>();
	int size=5;
	//���캯����ʼ��
	public MyPanel(String flag){
		
		//�ָ���¼
		Recorder.getRecording();
		myt=new MyTanK(150,200); 
		
		if(flag.equals("newgame")){
		for(int i=0;i<size;i++){
			EnemyTanK at=new EnemyTanK((i+1)*50,0);
			//at.setColor(1);
			at.setDirect(2);
			//��mypandel�ĵ���̹�˽�������̹��
			at.setEts(ats);
			//���� 
			Thread t=new Thread(at);
			t.start();
			//���������һ���ӵ���
			Shot s=new Shot(at.x+10,at.y+30,2);
			//��ӵ�������
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
				//��mypandel�ĵ���̹�˽�������̹��
				at.setEts(ats);
				//���� 
				Thread t=new Thread(at);
				t.start();
				//���������һ���ӵ���
				Shot s=new Shot(at.x+10,at.y+30,2);
				//��ӵ�������
				at.ss.add(s);
				Thread t2=new Thread(s);
				t2.start();
				ats.add(at);
				}
		}
		//���ſ�վ����
		 PlaySounds ap=new PlaySounds("C:\\Users\\PC\\Music\\���� - �ٶ��뼤��̹�˴�ս��.mp3");
		 Thread t=new Thread(ap);
		 t.start();
	}
	//������ʾ��Ϣ
	public void showInfo(Graphics g){
		//������ʾ��Ϣ̹�ˣ����̹�˲�����ս��
				this.drawTank(70, 330, g, 0, 1);
				g.setColor(Color.BLACK);
				g.drawString(Recorder.getEnNum()+"", 90, 340);
				//�ҵ�̹��
				this.drawTank(130, 330, g, 0, 0);
				g.setColor(Color.BLACK);
				g.drawString(Recorder.getMylife()+"",160,340);
				//������ҵ��ܳɼ�
				g.setColor(Color.BLACK);
				Font f=new Font("����",Font.BOLD,20);
				g.setFont(f);
				g.drawString("��ĳɼ�", 410, 30);
				this.drawTank(420, 60, g, 0, 1);
				g.setColor(Color.BLACK);
				g.drawString(Recorder.getAllEnNum()+" ",460, 80);
	}
	//���еĻ�ͼ���������Ҫ������д���еķ�����
	public void paint(Graphics g){
		super.paint(g);
		//���û����
		g.fillRect(0, 0, 400, 300);
		this.showInfo(g);
		//���û�̹�˵ĺ���
		if(myt.isLive){
			this.drawTank(myt.getX(), myt.getY(), g, myt.getDirect(), 0);
		}
		
		//��vector��ȡ���ӵ��������ӵ���
		for(int i=0;i<myt.ss.size();i++){
			Shot myShot=myt.ss.get(i);
		//��һ���ӵ�
			if(myShot!=null&& myShot.isLive==true){
				g.draw3DRect(myShot.x,myShot.y, 1, 1, false);
			}
			if(myShot.isLive==false){
				//�����ӵ�
				myt.ss.remove(myShot);
			}
		}
		
		//�����˵�̹�˺��ӵ�
		for(int i=0;i<ats.size();i++){
			EnemyTanK at=ats.get(i);
		if(at.isLive){
		this.drawTank(at.getX(), at.getY(), g, at.getDirect(),1);
			//���ӵ�
		for(int j=0;j<at.ss.size();j++){
			Shot enmyShot=at.ss.get(j);
			if(enmyShot.isLive){
				g.draw3DRect(enmyShot.x,enmyShot.y, 1, 1, false);
					}else{
						//������˵��ӵ�����
						at.ss.remove(enmyShot);
					}
				}
			}
		}
			
	}
	//�жϵ��˵��ӵ��Ƿ�����ҵ�̹��
	public void hitMeTanK(){
		for(int i=0;i<this.ats.size();i++){
			//ȡ������̹��
			EnemyTanK at=ats.get(i);
			//ȡ��ÿһ�ӵ�
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
	//�ж��ҵ��ӵ����е��˵�̹��
	public void hitEnemyTanK(){
		//�Ƿ���е��˵�̹��
		for(int i=0;i<myt.ss.size();i++){
			//ȡ���ӵ�
			Shot myShot=myt.ss.get(i);
			if(myShot.isLive){
				//�ӵ����ţ�ȡ��̹�������ж�
				for(int j=0;j<ats.size();j++){
					//ȡ��̹��
					EnemyTanK at=ats.get(j);
					if(at.isLive){
						if(this.hitTank(myShot, at)){
							//���ٵ��˵����������ӳɼ���
							Recorder.reduceEnNum();
							Recorder.addEnNum();
						}
						
					}
				}
			}
		}
	}
	//
	//���к���
	public boolean hitTank(Shot s,TanK at){
		//Ĭ��Ϊδ����
		boolean b=false;
		//�ж�̹�˵ķ���
		switch(at.direct){
		case 0:
		case 2:
			if(s.x>at.x&&s.x<at.x+20&&s.y>at.y&&s.y<at.y+30){
				//�����ӵ�����
				s.isLive=false;
				//������
				b=true;
				at.isLive=false;
				
			}
			break;
		case 1:
		case 3:
			if(s.x>at.x&&s.x<at.x+30&&s.y>at.y&&s.y<at.y+20){
				//�����ӵ�����
				s.isLive=false;	
				b=true;
				//������
				at.isLive=false;
				
			}
		}
		return b;
	}
	//
	//����̹�˵ĺ���
	public void drawTank(int x,int y,Graphics g,int direct,int type){
		switch(type){
		//�Լ���̹��
		case 0:
			g.setColor(Color.RED);
			break;
		//���˵�̹��
		case 1:
			g.setColor(Color.CYAN);
			break;
		}
		//�жϷ���
		switch(direct){
		//����
		case 0:
			//���û�����ɫ
			//g.setColor(Color.BLUE);
			//������ߵľ���
			g.fill3DRect(x, y,5,30, false);
			//��������ľ��Σ�
			g.fill3DRect(x+15, y,5,30,false);
			//�����м��Ǿ��Σ�
			g.fill3DRect(x+5, y+5,10,20, false);
			//����Բ�Σ�
			g.fillOval(x+5, y+10, 10, 10);
			//����
			g.drawLine(x+10,  y+16,x+10, y);
			break;
		case 1://����
			g.fill3DRect(x, y,30,5, false);
			//��������ľ��Σ�
			g.fill3DRect(x, y+15,30,5,false);
			//�����м��Ǿ��Σ�
			g.fill3DRect(x+5, y+5,20,10, false);
			//����Բ�Σ�
			g.fillOval(x+10, y+5, 10, 10);
			//����
			g.drawLine(x+16,  y+10,x+30, y+10);
			break;
		case 2://����
			g.fill3DRect(x, y,5,30, false);
			//��������ľ��Σ�
			g.fill3DRect(x+15, y,5,30,false);
			//�����м��Ǿ��Σ�
			g.fill3DRect(x+5, y+5,10,20, false);
			//����Բ�Σ�
			g.fillOval(x+5, y+10, 10, 10);
			//����
			g.drawLine(x+10,  y+16,x+10, y+30);
			break;
		case 3://����
			g.fill3DRect(x, y,30,5, false);
			//��������ľ��Σ�
			g.fill3DRect(x, y+15,30,5,false);
			//�����м��Ǿ��Σ�
			g.fill3DRect(x+5, y+5,20,10, false);
			//����Բ�Σ�
			g.fillOval(x+10, y+5, 10, 10);
			//����
			g.drawLine(x+16,  y+10,x, y+10);
			break;
		}
	}
	//�������ƶ��ļ���
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode()==KeyEvent.VK_W){
			//�����ҵ�̹�˵ķ���
			this.myt.setDirect(0);
				this.myt.moveUp();
		}else if(e.getKeyCode()==KeyEvent.VK_D){
			// ����
			this.myt.setDirect(1);
			this.myt.moveRight();
		}else if(e.getKeyCode()==KeyEvent.VK_S){
			// ����
			this.myt.setDirect(2);
			this.myt.moveDown();
		}else if(e.getKeyCode()==KeyEvent.VK_A){
			//  ����
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
		
		//����
		if(e.getKeyCode()==KeyEvent.VK_J){
			if(this.myt.ss.size()<5){
			this.myt.ShotEnemy();
			} 
		}
		//�����ػ�
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
			//����
			this.hitEnemyTanK();
			this.hitMeTanK();

			//�ػ�
			this.repaint();
		}
	}
}

