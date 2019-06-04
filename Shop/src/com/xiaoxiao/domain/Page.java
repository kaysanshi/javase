package com.xiaoxiao.domain;

import java.util.List;
import java.util.Map;

public class Page {
	private int pageSize = 4;//页面显示多少条记录
	private int totalSize;//共有多少条记录
	private int currentPage;//当前页码
//	private int totalPage;//共多少页
	private List<Map<String,Object>> list;//当前页面显示记录集
//	private int startIndex;//要读取记录的起始值
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
		if(currentPage > totalPage)
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
	public int getTotalSize() {
		return totalSize;
	}
	public int getTotalPage() {
		
		return (totalSize%pageSize == 0)?(totalSize/pageSize):(totalSize/pageSize+1);
	}
	public int getStartIndex() {
		int startIndex = (currentPage-1)*pageSize ;
		return startIndex;
	}
	public int getStart() {
		int start = currentPage-num/2+1;
		if(start < 1)
			start = 1;
		return start;
	}
	public int getEnd() {
		int end =  getStart() + num - 1;
		int totalPage = getTotalPage();
		if(end > totalPage)
			end = totalPage;
		return end;
	}
	
	

}
