package com.mingribook;

import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
//Ҫ�̳�JFrame�ࣻ
public class JFrame_test extends JFrame{
	public void CreateJFrame(String title){
		JFrame jf=new JFrame(title);//ʵ����һ��JFrame�Ķ���
		Container container=jf.getContentPane();//��ȡ������
		JLabel jl=new JLabel("����һ��JFrame����");//����һ����ǩ��
		jl.setHorizontalAlignment(SwingConstants.CENTER);//ʹ��ǩ�ϵ����־��У�
		container.add(jl);//����ǩ��ӵ������У�
		container.setBackground(Color.BLUE);//���ô�����ɫ��
		container.setLayout(null);
		jf.setVisible(true);//�Ǵ�����ӣ�
		jf.setSize(800, 800);//���ô����С
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//���ô���رշ�ʽ��
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JFrame_test().CreateJFrame("�����ҵ�һ��������JFrame����");
	}

}
