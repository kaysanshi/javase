package com.MindView.net;

import java.util.Random;
public class VowelsAndConsonant {
//�������һЩ��ĸ���ж�����Ԫ��(vowel)���Ǹ���(consonant)�ַ�
	public static void main(String[] args) {
		Random rand=new Random(47);
		for(int i=0;i<100;i++){
			int c=rand.nextInt(26)+'a';
			printnb((char)c+","+c+":");
			switch(c){
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':print("vowel");break;
			case 'y':
			case 'w':print("Sometimes a vowel");break;
			default: print("consonat"); 
			}
		}
	}

	private static void print(String string) {
		System.out.println(string);
		
	}

	private static void printnb(String string) {
		// TODO Auto-generated method stub
		System.out.print(string);
	}
}
