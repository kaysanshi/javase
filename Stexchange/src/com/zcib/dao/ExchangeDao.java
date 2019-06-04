package com.zcib.dao;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.List;
import java.util.Map;

import com.zcib.domain.Exchangearea;
import com.zcib.domain.Student;
import com.zcib.utils.DBUtils;
import com.zcib.utils.PageBean;
import com.zcib.utils.SimpleDate;

/**
 * 消息
 * @author 555
 *@date 2018年5月20日
 */
public class ExchangeDao {
	private DBUtils db=new DBUtils();
	/**
	 * 获取消息列表
	 * @param id 
	 * @return
	 */
	public List<Map<String, Object>> getMessageList(String id) {
		List<Map<String, Object>> list=null;
		// TODO Auto-generated method stub
		String sql="select * from exchangearea where teacherid=?";
		String[] params={id};
		list=db.getList(sql,params);
		return list;
	}
	/**
	 * 获得单个消息
	 * @param msid
	 * @return
	 */
	public List<Map<String, Object>> getMessagebyid(String msid) {
		// TODO Auto-generated method stub
		String sql="select * from exchangearea where id=?";
		String[] params={msid};
		List<Map<String, Object>> list=db.getList(sql, params);
		return list;
	}
	/**
	 * 回复消息
	 * @param message
	 * @return
	 */
	public boolean replyMessage(String message, String id) {
		// TODO Auto-generated method stub
		String sql="update exchangearea set reply=?,replydate=? where id=? ";
		String[] params={message,new SimpleDate().getdate(),id};
		int statu=db.update(sql, params);
		if (statu>0) {
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 删除消息
	 * @param mssageid
	 * @return
	 */
	public boolean DelMessage(String mssageid) {
		// TODO Auto-generated method stub
		String sql="delete from exchangearea where id=?";
		String[] params={mssageid};
		int statu=db.update(sql, params);
		if (statu>0) {
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 获取分页
	 * @param curPage
	 * @return
	 */
	public PageBean getPageBean(int curPage,String id) {
		// TODO Auto-generated method stub
		String sql="select id,title,content,reply,replydate,teacherid,studentid from exchangearea where teacherid=?";
		System.out.println();
		String[] teacherid={id};
		return db.getPageBean(sql,teacherid, curPage);
		
	}
	/**
	 * 
	 * @param exchangearea
	 * @return
	 */
	public boolean addMessage(Exchangearea exchangearea) {
		// TODO Auto-generated method stub
		String sql="insert into exchangearea values(?,?,?,?,?,?,?)";
		String[] params={null,exchangearea.getTitle(),exchangearea.getContent(),null,null,String.valueOf(exchangearea.getTeacherid()),null};
		int i=db.update(sql, params);
		if (i>0){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 学生获取自己发送的个人信息列表
	 * 无用
	 * @param id
	 * @return
	 */
	public List<Map<String, Object>> getMessageMyList(String id) {
		System.out.println("Student::::"+ id);
		// TODO Auto-generated method stub
		List<Map<String, Object>> list=null;
		String sql="select * from exchangearea where studentid=?";
		String[] params={id};
		list=db.getList(sql,params);
		return list;
	}
	/**
	 * 
	 * @param curPage
	 * @param stuid
	 * @return
	 */
	public PageBean getMyPageBean(int curPage, String stuid) {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("student+"+stuid);
		String sql="select id,title,content,reply,replydate,teacherid,studentid from exchangearea where studentid= ?";
		
		String[] id={stuid};
		return db.getPageBean(sql,id, curPage);
	}
	/**
	 * 查询
	 * @param curPage
	 * @param messagename
	 * @return
	 */
	public PageBean SearchMessagePageBean(int curPage, String messagename) {
		// TODO Auto-generated method stub
			// TODO Auto-generated method stub
			String sql="select * from exchangearea where title like ?";
			String[] name={"%"+messagename+"%"};
			return db.getPageBean(sql,name, curPage);
	}
	/**
	 * 
	 * @param messagetitle
	 * @param curPage
	 * @param teacherid
	 * @return
	 */
	public PageBean seachMessByid(String messagetitle, int curPage, String teacherid) {
		// TODO Auto-generated method stub
		String sql="select * from exchangearea where title like ? && teacherid=?";
		String[] params={"%"+messagetitle+"%",teacherid};
		return db.getPageBean(sql,params, curPage);
	}
		

}
