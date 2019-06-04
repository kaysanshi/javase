package com.kaysanshi;
/*
 * 节点类
 */
public class Node {
	private Object data;//数据域
	private Node next;//指针域，引用
	public Node() {
		super();
	}
	public Node(Object data, Node next) {
		super();
		this.data = data;
		this.next = next;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}

}
