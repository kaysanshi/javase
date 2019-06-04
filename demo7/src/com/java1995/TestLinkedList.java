package com.java1995;

public class TestLinkedList {

	public static void main(String[] args) {
		LinkedList ll=new LinkedList();
		ll.add("s");
		ll.add("m");
		ll.add("n");
		System.out.println(ll);
		ll.remove(2);
		System.out.println(ll);
		ll.insert( 2, "s");
		System.out.println(ll);
		ll.modify(0, "m");
		System.out.println(ll);
		ll.get(2);
		ll.get("s");
		
	}

}
