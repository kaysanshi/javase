package com.java1995;
import java.awt.Label;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
//选项卡无需监听就可以使用
//选项卡组件;
public class JTabbedPanel {
	public static void main(String[] args) {
		new MyJFame();
	}
}
class 	MyJFame extends JFrame{
	JPanel jp1;
	JTabbedPane jtp;//选项卡对象
	public MyJFame() {
		// TODO Auto-generated constructor stub
		JPanel buttonjp=new JPanel();//放按钮的面板
		buttonjp.add(new JLabel("按钮1"));
		buttonjp.add(new JLabel("按钮2"));
		buttonjp.add(new JLabel("按钮3"));
		buttonjp.add(new JLabel("按钮4"));
		///
		JPanel labeljp=new JPanel();//放表签的面板;
		labeljp.add(new Label("标签1"));
		labeljp.add(new Label("标签2"));
		labeljp.add(new Label("标签3"));
		labeljp.add(new Label("标签4"));
		//选项卡对象;来进行管理这几个jpanel;
		jtp=new JTabbedPane();
		jtp.add("jbutton",buttonjp);
		jtp.add("jlable",labeljp);
		jtp.add("其他", null);
		
		//
		jp1=new JPanel();
		jp1.add(jtp);
		
		this.add(jp1);
		this.setTitle("选项卡使用");
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