package com.zcib.service;

import java.util.List;
import java.util.Map;

import com.zcib.dao.ExchangeDao;
import com.zcib.domain.Exchangearea;
import com.zcib.utils.PageBean;

/**
 * 
 * @author 555
 *@date 2018年5月20日
 */
public class ExchangeService {
	 private ExchangeDao dao=new ExchangeDao();
	/**
	 * 获取消息列表
	 * @param id 
	 * @return
	 */
	public List<Map<String, Object>> getMessageList(String id) {
		// TODO Auto-generated method stub
		return dao.getMessageList(id);
	}
	/**
	 * 获得单个
	 * @param msid
	 * @return
	 */
	public List<Map<String, Object>> getMessagebyid(String msid) {
		// TODO Auto-generated method stub
		return dao.getMessagebyid(msid);
	}
	public boolean replyMessage(String message, String id) {
		// TODO Auto-generated method stub
		return dao.replyMessage(message,id);
	}
	/**
	 * 删除
	 * @param mssageid
	 * @return
	 */
	public boolean DelMessage(String mssageid) {
		// TODO Auto-generated method stub
		return dao.DelMessage(mssageid);
	}
	/**
	 * 获得分页
	 * @param curPage
	 * @return
	 */
	public PageBean getListPage(int curPage ,String id) {
		// TODO Auto-generated method stub
	 return dao.getPageBean(curPage,id);
	}
	/**
	 * 添加
	 * @param exchangearea
	 * @return
	 */
	public boolean addMessage(Exchangearea exchangearea) {
		// TODO Auto-generated method stub
		return dao.addMessage(exchangearea);
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	public List<Map<String, Object>> getMessageMyList(String id) {
		// TODO Auto-generated method stub
		return dao.getMessageMyList(id);
	}
	/**
	 * 获得个人的
	 * @param curPage
	 * @param stuid
	 * @return
	 */
	public PageBean getMyListMessagePage(int curPage, String stuid) {
		// TODO Auto-generated method stub
		return dao.getMyPageBean(curPage,stuid);
	}
	/**
	 * 搜索
	 * @param curPage
	 * @param messagename
	 * @return
	 */
	public PageBean SearchMessagePageBean(int curPage, String messagename) {
		// TODO Auto-generated method stub
		return dao.SearchMessagePageBean(curPage,messagename);
	}
	/**
	 * 教师端的搜索
	 * @param messagetitle
	 * @param curPage
	 * @param teacherid
	 * @return
	 */
	public PageBean searchMessByTid(String messagetitle, int curPage, String teacherid) {
		// TODO Auto-generated method stub
		
		
		return dao.seachMessByid(messagetitle,curPage,teacherid);
	}

}
