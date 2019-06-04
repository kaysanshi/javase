package com.mhl.tools;
import javax.swing.*;
import javax.imageio.*;
import java.awt.*;
public class ImagePanel extends JPanel{
Image img;
public ImagePanel(Image img)
{
	this.img=img;
	int width=Toolkit.getDefaultToolkit().getScreenSize().width;
	int height=Toolkit.getDefaultToolkit().getScreenSize().height;
	this.setSize(width,height);
}
public void paintComponent(Graphics g)
{
	super.paintComponent(g);
	g.drawImage(img, 0,0, this.getWidth(), this.getHeight(),this);
}
}
