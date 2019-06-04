package com.zcib.service;

import java.util.List;

import com.zcib.domain.Page;
import com.zcib.domain.User;
/**
 * 
 * @author 555
 *
 */
public interface UserService {
	
	/**
	 * 注册
	 * @param user
	 */
	void regist(User user);
	/**
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	User getUserByNameAndPsw(String username, String password);
	/**
	 * 批量删除
	 * @param ids
	 */
	
	void batchdel(String[] ids);
	/**
	 * 获得所有
	 * @return
	 */
	List<User> getAllUser();
	/**
	 * ͨ查找
	 * @param user
	 * @return
	 */
	List<User> findUserByCond(User user);
	
	/**
	 * 删除
	 * @param user
	 * @return 
	 */
	boolean deleteUser(User user);
	/**
	 *更新
	 * @param user
	 */
	void updateUser(User user);
	/**]
	 * 朝赵用户
	 * @param id
	 * @return
	 */
	User findUserByid(String id);
	/**
	 * 获得分页用户列表
	 * @param thispage
	 * @param rowperpage
	 * @return
	 */
	Page getPageUser(int thispage, int rowperpage);
	/**
	 * 获取一条记录
	 * @param user
	 * @return
	 */
	User getUser(User user);
	/**
	 * 分页查询
	 * @param thispage
	 * @param rowperpage
	 * @param user
	 * @return
	 */
	Page getSearchPageUser(int thispage, int rowperpage, User user);
}
