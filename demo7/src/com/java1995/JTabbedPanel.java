package com.java1995;
import java.awt.Label;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
//ѡ���������Ϳ���ʹ��
//ѡ����;
public class JTabbedPanel {
	public static void main(String[] args) {
		new MyJFame();
	}
}
class 	MyJFame extends JFrame{
	JPanel jp1;
	JTabbedPane jtp;//ѡ�����
	public MyJFame() {
		// TODO Auto-generated constructor stub
		JPanel buttonjp=new JPanel();//�Ű�ť�����
		buttonjp.add(new JLabel("��ť1"));
		buttonjp.add(new JLabel("��ť2"));
		buttonjp.add(new JLabel("��ť3"));
		buttonjp.add(new JLabel("��ť4"));
		///
		JPanel labeljp=new JPanel();//�ű�ǩ�����;
		labeljp.add(new Label("��ǩ1"));
		labeljp.add(new Label("��ǩ2"));
		labeljp.add(new Label("��ǩ3"));
		labeljp.add(new Label("��ǩ4"));
		//ѡ�����;�����й����⼸��jpanel;
		jtp=new JTabbedPane();
		jtp.add("jbutton",buttonjp);
		jtp.add("jlable",labeljp);
		jtp.add("����", null);
		
		//
		jp1=new JPanel();
		jp1.add(jtp);
		
		this.add(jp1);
		this.setTitle("ѡ�ʹ��");
		this.setSize(500, 400);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		this.setVisible(true);
		
	}
}