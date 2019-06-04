package Tools;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

//���Զ�̬����ͼƬ��������JPanel
public class ImagePanel extends JPanel {
	Image img;
	//���캯����ȡJPanel�Ĵ�С;
	public ImagePanel(Image img){
		this.img=img;
		//����Ӧ״̬
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setSize(width, height);
//		this.setVisible(true);
	}
	//������ͼ
	public void paintComponent(Graphics g){
		//����
		super.paintComponent(g);
		g.drawImage(img, 0, 0,this.getHeight(),this.getWidth(), this);
	}

}
