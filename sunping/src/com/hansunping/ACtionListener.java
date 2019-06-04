package com.hansunping;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ACtionListener extends JFrame{
	JPanel jp;
	JButton jb1,jb2;
	public ACtionListener(){
		jp=new JPanel();
		jb1=new JButton("黑色");
		jb2=new JButton("红色");
		
		jb1.addActionListener(new myActionListener());
		jb1.setActionCommand("黑色");
		jb2.addActionListener(new myActionListener());
		jb2.setActionCommand("红色");
		
		jp.setBackground(Color.BLUE);
		this.add(jp);
		this.add(jb1,BorderLayout.SOUTH);
		this.add(jb2, BorderLayout.NORTH);
		this.setTitle("监听");
		this.setSize(300, 400);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		this.setVisible(true);
	}
//其实监听这个类应方到JPanel中，让按下按钮的方法中传入监听的对象
class myActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getActionCommand().equals("黑色")){
				System.out.println("黑色按钮触发");
				jp.setBackground(Color.BLACK);
			}else if(e.getActionCommand().equals("红色")){
				System.out.println("红色按钮触发");
				jp.setBackground(Color.RED);
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ACtionListener();
	}

}


