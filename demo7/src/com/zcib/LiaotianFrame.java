package com.zcib;

import java.awt.BorderLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class LiaotianFrame extends JFrame {
	JButton sendbtn;
	JTextField inputField;
	JTextArea chatContent;

	public LiaotianFrame() {
		this.setLayout(new BorderLayout());//设置布局管理器

		chatContent=new JTextArea(12,34);//创建文本域
		chatContent.setEditable(false);//设置文本域为不可编辑
		JScrollPane showPanel = new JScrollPane(chatContent);//创建一个滚动面板，将文本域作为显示组件
		
		JPanel inputPanel = new JPanel();//创建一个JPanel面板
		Label label = new Label("my chat");//创建一个标签
		inputField = new JTextField(20);//创建一个文本框
		sendbtn = new JButton("发送");//创建一个发送按钮
		
		// 为按钮添加监听事件
		sendbtn.addActionListener(new MyActionListener());
		
		inputPanel.add(label);//将标签添加到面板
		inputPanel.add(inputField);
		inputPanel.add(sendbtn);

		this.add(showPanel, BorderLayout.CENTER);//将滚动面板和JPanel面板添加到JFrame窗口
		this.add(inputPanel, BorderLayout.SOUTH);
		
		this.setTitle("聊天窗口");
		this.setSize(400, 300);
		// 设置单击关闭按钮的默认操作
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	class MyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {//重写actionPerformed方法
			String content = inputField.getText();//获取输入文本信息
			if (content != null && !content.trim().equals("")) {
				chatContent.append("本人：" + content + "\n");
			} else {
				chatContent.append("聊天信息不能为空\n");
			}
			inputField.setText("");//设置文本域内容为空
		}

	}

}
