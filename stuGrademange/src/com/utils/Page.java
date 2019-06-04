package com.utils;

import java.util.List;
import java.util.Map;

public class Page {
	private int pageSize = 4;//ҳ����ʾ��������¼
	private int totalSize;//�ܹ��ж�������¼
	private int currentPage;//��ǰҳ��
//	private int totalPage;//���ж���ҳ
	private List<Map<String,Object>> list;//��ǰҳ��ʾ�ļ�¼��
//	private int startIndex;//Ҫ��ȡ��¼����ʼֵ��
	private int num = 6;//ҳ���б�ĸ���
//	private int start;//ҳ���б����ʼֵ
//	private int end;//ҳ���б����ֵֹ
	
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
//�ܹ��ж�������¼
	public int getTotalSize() {
		return totalSize;
	}
	//���ж���ҳ
	public int getTotalPage() {
		
		return (totalSize%pageSize == 0)?(totalSize/pageSize):(totalSize/pageSize+1);
	}
	//Ҫ��ȡ��¼����ʼֵ��
	public int getStartIndex() {
		int startIndex = (currentPage-1)*pageSize ;
		return startIndex;
	}
	//ҳ���б����ʼֵ
	public int getStart() {
		int start = currentPage-num/2+1;
		if(start < 1)
			start = 1;
		return start;
	}
	//��ȡҳ���б����ֵֹ
	public int getEnd() {
		int end =  getStart() + num - 1;
		int totalPage = getTotalPage();
		if(end > totalPage)
			end = totalPage;
		return end;
	}
	
	

}
