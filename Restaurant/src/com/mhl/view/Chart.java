package com.mhl.view;
//这是人事管理界面
import java.awt.BorderLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import com.mhl.tools.*;

import javax.imageio.ImageIO;
import javax.swing.*;
public class Chart extends JPanel {
	//定义组件
	JPanel p1;
	Image chart;
	
	public Chart()
	{
		try {
			chart=ImageIO.read(new File("image/chart.jpg"));
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		ImagePanel ip=new ImagePanel(chart);
		p1.add(ip);
		this.setLayout(new BorderLayout());
		this.add(p1,"Center");
		this.setVisible(true);
		
	}
	
}
