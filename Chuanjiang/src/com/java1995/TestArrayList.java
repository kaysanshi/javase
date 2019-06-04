package com.java1995;

import java.util.ArrayList;

public class TestArrayList {

	public static void main(String[] args) {
		ArrayList a=new ArrayList<>();
		String s="hello world and Java";
		String[] s1=s.split(" ");
		for(int i=0;i<s1.length;i++){
			a.add(s1[i]);
		}
		for(int i=0;i<a.size();i++){
			System.out.println(a.get(i));
		}
	}
}
