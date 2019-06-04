package com.zcib.dao;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.zcib.domain.User;
/**
 * 
 * @author 555
 *
 */
public interface UserDao {
	/**
	 * 查找name
	 * @param name 
	 * @return 
	 */
	User findUserByName(String username, Connection conn);
	/**
	 * ͨ和对
	 * @param username
	 * @param password
	 * @return
	 */
	User finUserByNameAndPsw(String username, String password);
	/**
	 * 增加
	 * @param user
	 */
	
	void addUser(User user, Connection conn);
	/**
	 * 删除批量
	 * @param conn
	 * @param id
	 * @throws SQLException 
	 */
	void delUserByIDWithTrans(Connection conn, String id) throws SQLException;
	/**
	 * 获得行
	 * @return
	 */
	int getCountRow();
	/**
	 * 获取user
	 * @return
	 */
	List<User> getAllUser();
	/**
	 * 查找
	 * @return
	 */
	List<User> findUserByCond(User user);
	/**
	 *删除
	 * @param user
	 * @return 
	 */
	boolean deleteUser(User user);
	/**
	 * 查找
	 * @param id
	 * @return
	 */
	User findUserByid(String id);
	/**
	 * 修改
	 * @param user
	 */
	void updateUser(User user);
	/**
	 * 获得分页列表
	 * @param i
	 * @param rowperpage
	 * @return
	 */
	List<User> getPageUser(int i, int rowperpage);
	/**
	 *获取user信息
	 * @param user
	 * @return
	 */
	User getUser(User user);
	/**
	 * 获取查询的行数
	 * @param user 
	 * @return
	 */
	int getCountRowbysearch(User user);
	/**
	 * 查询
	 * @param i
	 * @param rowperpage
	 * @param user
	 * @return
	 */
	List<User> getSearchPageUser(int i, int rowperpage, User user);
	
}
