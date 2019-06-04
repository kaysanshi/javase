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
	
	//�������
	JTextArea jta=null;
	//�˵���
	JMenuBar jmb=null;
	//��һ��JMenu
	JMenu jm=null;
	JMenu jm2=null;
	//JMenuItem
	JMenuItem jmi=null;
	JMenuItem jmi1=null;
	//���尴ť

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NotePad np=new NotePad();
	}
	
	public NotePad(){
		jta=new JTextArea();
		jmb=new JMenuBar();
		jm=new JMenu("�ļ�");
		jm2=new JMenu("Ŀ¼");
		
		//�������Ƿ�
		jm.setMnemonic('F');
		jmi=new JMenuItem("��");
		jmi1=new JMenuItem("����");
		//ע�����
		jmi.addActionListener(this);
		jmi.setActionCommand("open");
		
		jmi1.addActionListener(this);
		jmi1.setActionCommand("save");
		//����
		this.setJMenuBar(jmb);
		//��jm�ŵ�jmb
		jmb.add(jm);
		jmb.add(jm2);
		//��item�ŵ�menu
		jm.add(jmi);
		jm.add(jmi1);
		
		this.add(jta);
		this.setTitle("���±�");
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
			//JFileChooser;�ļ�ѡ��
			JFileChooser jfc1=new JFileChooser();
			//������
			jfc1.setDialogTitle("��ѡ���ļ�...");
			
			jfc1.showOpenDialog(null);
			//��ʾ
			jfc1.setVisible(true);
			//�õ��û�ѡ��ľ���·��
			String filename=jfc1.getSelectedFile().getAbsolutePath();
			//System.out.println(filename);
			FileReader fr=null;
			BufferedReader br=null;
			try {
				
				fr=new FileReader(filename);
				br=new BufferedReader(fr);
				//��ʾ����
				String s;
				String allcon = null;
				s=br.readLine();
				while(s!=null){
					allcon+=s+"\t\n";
					s=br.readLine();
					
				}
				//���õ�Jta��
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
			//���ֱ���Ի���
			JFileChooser jfc=new JFileChooser();
			jfc.setDialogTitle("���Ϊ");
			//
			jfc.showSaveDialog(null);
			jfc.setVisible(true);
			//�õ��û���Ⱥ·��
			String file=jfc.getSelectedFile().getAbsolutePath();
			//д�뵽ָ���ļ���
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
