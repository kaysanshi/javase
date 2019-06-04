package Tools;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

//可以动态加载图片做背景的JPanel
public class ImagePanel extends JPanel {
	Image img;
	//构造函数获取JPanel的大小;
	public ImagePanel(Image img){
		this.img=img;
		//自适应状态
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setSize(width, height);
//		this.setVisible(true);
	}
	//画背景图
	public void paintComponent(Graphics g){
		//清屏
		super.paintComponent(g);
		g.drawImage(img, 0, 0,this.getHeight(),this.getWidth(), this);
	}

}
