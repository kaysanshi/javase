package com.hansunping;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

public class NotePad extends JFrame implements ActionListener{
	
	//定义组件
	JTextArea jta=null;
	//菜单条
	JMenuBar jmb=null;
	//第一个JMenu
	JMenu jm=null;
	JMenu jm2=null;
	//JMenuItem
	JMenuItem jmi=null;
	JMenuItem jmi1=null;
	//定义按钮

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NotePad np=new NotePad();
	}
	
	public NotePad(){
		jta=new JTextArea();
		jmb=new JMenuBar();
		jm=new JMenu("文件");
		jm2=new JMenu("目录");
		
		//设置助记符
		jm.setMnemonic('F');
		jmi=new JMenuItem("打开");
		jmi1=new JMenuItem("保存");
		//注册监听
		jmi.addActionListener(this);
		jmi.setActionCommand("open");
		
		jmi1.addActionListener(this);
		jmi1.setActionCommand("save");
		//加入
		this.setJMenuBar(jmb);
		//把jm放到jmb
		jmb.add(jm);
		jmb.add(jm2);
		//把item放到menu
		jm.add(jmi);
		jm.add(jmi1);
		
		this.add(jta);
		this.setTitle("记事本");
		this.setSize(400, 300);
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
		if(e.getActionCommand().equals("open")){
			//JFileChooser;文件选择
			JFileChooser jfc1=new JFileChooser();
			//设置名
			jfc1.setDialogTitle("请选择文件...");
			
			jfc1.showOpenDialog(null);
			//显示
			jfc1.setVisible(true);
			//得到用户选择的绝对路径
			String filename=jfc1.getSelectedFile().getAbsolutePath();
			//System.out.println(filename);
			FileReader fr=null;
			BufferedReader br=null;
			try {
				
				fr=new FileReader(filename);
				br=new BufferedReader(fr);
				//显示到框
				String s;
				String allcon = null;
				s=br.readLine();
				while(s!=null){
					allcon+=s+"\t\n";
					s=br.readLine();
					
				}
				//放置到Jta中
				jta.setText(allcon);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally{
				try {
					br.close();
					fr.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		}
		if(e.getActionCommand().equals("save")){
			//出现保存对话框
			JFileChooser jfc=new JFileChooser();
			jfc.setDialogTitle("另存为");
			//
			jfc.showSaveDialog(null);
			jfc.setVisible(true);
			//得到用户的群路径
			String file=jfc.getSelectedFile().getAbsolutePath();
			//写入到指点文件夹
			FileWriter fw=null;
			BufferedWriter bw=null;
			try {
				fw=new FileWriter(file);
				bw=new BufferedWriter(fw);
				
				bw.write(this.jta.getText());
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally{
				try {
					bw.close();
					fw.close();
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}

}
