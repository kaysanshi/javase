package com.zcib2.job2;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ResultView extends JDialog{
	JTextArea jTextArea;
	JPanel jp=null;
	public ResultView(View view) {
		// TODO Auto-generated constructor stub
		super(view);
		jp=new JPanel();
		jTextArea=new JTextArea(20,30);
		jTextArea.append("姓名"+view.jtf1.getText());
		jTextArea.append("生日"+view.jtf2.getText()+"\n");
		jTextArea.append("爱好"+view.jcb.getItemAt(1)+"\n");
		jTextArea.append("爱好"+view.jcb2.getText());
		jTextArea.append("爱好"+view.jcb3.getText()+"\n");
		jTextArea.append("邮件"+view.jtf3.getText()+"\n");
		jTextArea.append("学历"+view.jl5.getText()+"\n");
		jTextArea.append("附录"+view.jTextArea.getText());
		jp.add(jTextArea);
		this.add(jp);
		this.setTitle("你的信息是：");
		this.setSize(300, 500);
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosing(e);
				System.exit(0);
			}
		});
	}
}
