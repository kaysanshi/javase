package com.java1995;

import java.util.HashSet;

public class Hashset {

	public static void main(String[] args) {
		HashSet<String> hs=new HashSet<String>();
		hs.add("a");
		hs.add("b");
		hs.add("c");
		hs.add("d");
		System.out.print(hs);
		String [] s=new String[hs.size()];
		hs.toArray(s);
		System.out.println();
		for(String x:s){
			System.out.print(x+" ");
		}
		
	}

}
