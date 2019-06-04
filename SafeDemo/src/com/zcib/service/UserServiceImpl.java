package com.zcib.service;

import com.zcib.factory.BasicFactory;
import com.zcib.utils.DaoUtils;
import com.zcib.utils.PageBean;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import org.apache.commons.dbutils.DbUtils;
import com.zcib.dao.UserDao;
import com.zcib.domain.Page;
import com.zcib.domain.Resource;
import com.zcib.domain.User;

public class UserServiceImpl implements UserService {
	UserDao dao=BasicFactory.getFactory().GetInstance(UserDao.class);

	@Override
	public void regist(User user) {
		// TODO Auto-generated method stub
		Connection conn = DaoUtils.getConnection();
			//1.
			if(dao.findUserByName(user.getUsername(),conn)!=null){
				throw new RuntimeException("已有人!!");
			}
			//2.
			dao.addUser(user,conn);
	}
	@Override
	public User getUserByNameAndPsw(String username, String password) {
		// TODO Auto-generated method stub
		return dao.finUserByNameAndPsw(username,password);
	}
	@Override
	public void batchdel(String[] ids) {
		// TODO Auto-generated method stub
		Connection conn = DaoUtils.getConnection();
		try{
			
			conn.setAutoCommit(false);
			for(String id : ids){
				dao.delUserByIDWithTrans(conn,id);
			}
			//
			DbUtils.commitAndCloseQuietly(conn);
		}catch (Exception e) {
			//
			DbUtils.rollbackAndCloseQuietly(conn);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return dao.getAllUser();
	}
	@Override
	public List<User> findUserByCond(User user) {
		// TODO Auto-generated method stub
		return dao.findUserByCond(user);
	}
	
	@Override
	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		return dao.deleteUser(user);
	}
	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		dao.updateUser(user);
	}
	@Override
	public User findUserByid(String id) {
		// TODO Auto-generated method stub
		return dao.findUserByid(id);
	}
	@Override
	public Page getPageUser(int thispage, int rowperpage) {
		// TODO Auto-generated method stub
		Page page=new Page();
		//--当前页
				page.setThispage(thispage);
				//--每页记录数
				page.setRowperpage(rowperpage);
				//--共有多少行
				int countrow = dao.getCountRow();
				page.setCountrow(countrow);
				//--共有多少页
				int countpage = countrow/rowperpage+(countrow%rowperpage==0?0:1);
				page.setCountpage(countpage);
				//--首页
				page.setFirstpage(1);
				//--尾页
				page.setLastpage(countpage);
				//--上一页
				page.setPrepage(thispage==1?1:thispage-1);
				//--下一页
				page.setNextpage(thispage == countpage ? countpage : thispage+1);
				//--当前页数据
				List<User> list = dao.getPageUser((thispage-1)*rowperpage,rowperpage);
				page.setList(list);
				
				return page;
	}
	@Override
	public User getUser(User user) {
		// TODO Auto-generated method stub
		return dao.getUser(user);
	}
	@Override
	public Page getSearchPageUser(int thispage, int rowperpage, User user) {
		// TODO Auto-generated method stub
		Page page=new Page();
		//--当前页
				page.setThispage(thispage);
				//--每页记录数
				page.setRowperpage(rowperpage);
				//--共有多少行
				int countrow = dao.getCountRowbysearch(user);
				page.setCountrow(countrow);
				//--共有多少页
				int countpage = countrow/rowperpage+(countrow%rowperpage==0?0:1);
				page.setCountpage(countpage);
				//--首页
				page.setFirstpage(1);
				//--尾页
				page.setLastpage(countpage);
				//--上一页
				page.setPrepage(thispage==1?1:thispage-1);
				//--下一页
				page.setNextpage(thispage == countpage ? countpage : thispage+1);
				//--当前页数据
				List<User> list = dao.getSearchPageUser((thispage-1)*rowperpage,rowperpage,user);
				page.setList(list);
				
				return page;
	}

}
