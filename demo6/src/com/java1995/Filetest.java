package com.java1995;
import java.io.*;

public class Filetest {
	
	public static void main(String[] args) {
		File file=new File("c://javam.text");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			System.out.println("Å­ÄÜ");
		}
	}
}
