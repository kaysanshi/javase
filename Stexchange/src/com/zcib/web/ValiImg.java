package com.zcib.web;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 */
/**
 * Servlet implementation class ValiImg
 */
@WebServlet("/ValiImg")
public class ValiImg extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Random r = new Random();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValiImg() {
        super();
        // TODO Auto-generated constructor stub
    }
  //
  	private Color randomColor () {
  		int red = r.nextInt(256);
  		int green = r.nextInt(256);
  		int blue = r.nextInt(256);
  		return new Color(red, green, blue);
  	}	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setDateHeader("Expires", -1);
		response.setHeader("Cache-Control", "no-Cache");
		response.setHeader("pragma", "no-Cache");
		
		int height = 45;
		int width = 30*4;
		BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		Graphics2D g =  (Graphics2D) image.getGraphics();
		
		//1.设置颜色
		g.setColor(Color.white);
		g.fillRect(0, 0, width, height);
		
		//2.
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, width-1, height-1);
		
		//3.
		g.setColor(randomColor ());
		for(int i = 0;i<5;i++){
			g.drawLine(getRandInt(0,width), getRandInt(0,height), getRandInt(0,width), getRandInt(0,height));
		}
		//4.
		 String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890*";
		g.setFont(new Font("宋体",Font.BOLD,25));
		g.setColor(randomColor ());
		StringBuffer buffer = new StringBuffer();
		for(int i=0;i<4;i++){
			double c = getRandInt(-45, 45)/180F*Math.PI;
		//
			g.rotate(c, 5+width/4*i, 22);
			String s = base.charAt(getRandInt(0,base.length()-1))+"";
			buffer.append(s);
			g.drawString(s, 5+width/4*i, 22);
			g.rotate(-c, 5+width/4*i, 22);
		}
		System.out.println(buffer.toString());
		request.getSession().setAttribute("valistrt", buffer.toString());
		//5.
		g.dispose();
		//6
		ImageIO.write(image, "jpg", response.getOutputStream());
	
	}
	
	Random random = new Random();
	public int getRandInt(int begin,int end){
		return random.nextInt(end-begin)+begin;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
