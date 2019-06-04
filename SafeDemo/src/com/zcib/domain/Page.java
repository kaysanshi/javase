package com.zcib.domain;

import java.util.List;

public class Page {
	private int thispage;//当前页
	private int rowperpage;//
	private int countrow;//共多少行
	private int countpage;//多少页
	private int firstpage;//第一页
	private int lastpage;//最后一页
	private int prepage;//前一页
	private int nextpage;//下一页
	private List list;
	public int getThispage() {
		return thispage;
	}
	public void setThispage(int thispage) {
		this.thispage = thispage;
	}
	public int getRowperpage() {
		return rowperpage;
	}
	public void setRowperpage(int rowperpage) {
		this.rowperpage = rowperpage;
	}
	public int getCountrow() {
		return countrow;
	}
	public void setCountrow(int countrow) {
		this.countrow = countrow;
	}
	public int getCountpage() {
		return countpage;
	}
	public void setCountpage(int countpage) {
		this.countpage = countpage;
	}
	public int getFirstpage() {
		return firstpage;
	}
	public void setFirstpage(int firstpage) {
		this.firstpage = firstpage;
	}
	public int getLastpage() {
		return lastpage;
	}
	public void setLastpage(int lastpage) {
		this.lastpage = lastpage;
	}
	public int getPrepage() {
		return prepage;
	}
	public void setPrepage(int prepage) {
		this.prepage = prepage;
	}
	public int getNextpage() {
		return nextpage;
	}
	public void setNextpage(int nextpage) {
		this.nextpage = nextpage;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
}
