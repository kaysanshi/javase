package com.utils;

import java.util.List;
import java.util.Map;

public class Page {
	private int pageSize = 4;//页面显示多少条记录
	private int totalSize;//总共有多少条记录
	private int currentPage;//当前页码
//	private int totalPage;//共有多少页
	private List<Map<String,Object>> list;//当前页显示的记录集
//	private int startIndex;//要读取记录的起始值；
	private int num = 6;//页码列表的个数
//	private int start;//页码列表的起始值
//	private int end;//页码列表的终止值
	
	public Page(int currentPage,int totalSize){
		this.totalSize = totalSize;
		setCurrentPage(currentPage);
	}
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurrentPage() {
		
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		if(currentPage < 1)
			currentPage = 1;
		int totalPage = getTotalPage();
		if(currentPage > totalPage&&totalPage>0)
			currentPage = totalPage;
			
		this.currentPage = currentPage;
	}
	public List<Map<String, Object>> getList() {
		return list;
	}
	public void setList(List<Map<String, Object>> list) {
		this.list = list;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
//总共有多少条记录
	public int getTotalSize() {
		return totalSize;
	}
	//共有多少页
	public int getTotalPage() {
		
		return (totalSize%pageSize == 0)?(totalSize/pageSize):(totalSize/pageSize+1);
	}
	//要读取记录的起始值；
	public int getStartIndex() {
		int startIndex = (currentPage-1)*pageSize ;
		return startIndex;
	}
	//页码列表的起始值
	public int getStart() {
		int start = currentPage-num/2+1;
		if(start < 1)
			start = 1;
		return start;
	}
	//获取页码列表的终止值
	public int getEnd() {
		int end =  getStart() + num - 1;
		int totalPage = getTotalPage();
		if(end > totalPage)
			end = totalPage;
		return end;
	}
	
	

}
