package com.hansunping;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/*
 * �����ı��������ʹ��
 */
public class JTextArea_test extends JFrame{
	JPanel jp;//���
	JTextArea jta;//�����ı���
	JScrollPane jsp,jsp1;
	JButton jb1;//��ť
	JComboBox jcb;//������
	JTextField jtf;//�ı���
	public JTextArea_test(){
		//���ö����ı���Ӧ�ù����������
		jta=new JTextArea();
		jsp=new JScrollPane(jta);
		jp=new JPanel();
		String[] s={"����","����","����","�˱�"};
		jcb=new JComboBox(s);
		
		jtf=new JTextField(10);//�ı���
		jb1=new JButton("����");
		//��ӵ����
		jp.add(jcb);
		jp.add(jtf);
		jp.add(jb1);
		//��ӵ�JFrame;
		this.add(jsp);
		this.add(jp,BorderLayout.SOUTH);
		//���ô��ڣ�
		this.setTitle("qq");
		this.setIconImage((new ImageIcon("Image\\qq.jpg")).getImage());
		this.setSize(400, 350);
		this.setLocation(300, 350);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		this.setVisible(true);
	}
public static void main(String[] args) {
	new JTextArea_test();
}
}
