package com.zcib.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import com.zcib.domain.User;
import com.zcib.utils.DaoUtils;
/**
 * 
 * @author 555
 *
 */
public class UserDaoImpl implements UserDao {
	@Override
	public void addUser(User user, Connection conn) {
		// TODO Auto-generated method stub
		String sql = "insert into user values(null,?,?,null,null,null,null,null,null)";
		try{
			QueryRunner runner = new QueryRunner();
			runner.update(conn,sql,user.getUsername(),user.getPassword());
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public User findUserByName(String username, Connection conn) {
		// TODO Auto-generated method stub
		String sql = "select * from user where username = ?";
		try{
			QueryRunner runner = new QueryRunner();
			return runner.query(conn,sql, new BeanHandler<User>(User.class),username);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}


	@Override
	public User finUserByNameAndPsw(String username, String password) {
		// TODO Auto-generated method stub
		String sql = "select * from user where username = ? and password = ?";
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			return runner.query(sql, new BeanHandler<User>(User.class) ,username ,password);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void delUserByIDWithTrans(Connection conn, String id) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "delete from user where userid = ?";
		QueryRunner runner = new QueryRunner();
		runner.update(conn,sql,id);
	}
	@Override
	public int getCountRow() {
		// TODO Auto-generated method stub
		String sql = "select count(*) from user";
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			return ((Long)runner.query(sql, new ScalarHandler())).intValue();
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		String sql="select * from user ";
		try {
			QueryRunner runner=new QueryRunner(DaoUtils.getSource());
			return runner.query(sql, new BeanListHandler<User>(User.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public List<User> findUserByCond(User user) {
		// TODO Auto-generated method stub
		String sql = "select * from user where 1=1 ";
		List<Object> list = new ArrayList<Object>();
		if(user.getUsername()!=null && !"".equals(user.getUsername())){
			sql += " and username like ? ";
			list.add("%"+user.getUsername()+"%");
		}
		if(user.getGender()!=null && !"".equals(user.getGender())){
			sql += " and gender = ? ";
			list.add(user.getGender());
		}
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			if(list.size()<=0){
				return runner.query(sql, new BeanListHandler<User>(User.class));
			}else{
				return runner.query(sql, new BeanListHandler<User>(User.class),list.toArray());
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public boolean  deleteUser(User user) {
		// TODO Auto-generated method stub
		String sql="delete from user where userid=?";
		try {
			QueryRunner runner=new QueryRunner(DaoUtils.getSource());
			int i=runner.update(sql,user.getUserid());
			if (i>0) {
				return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@Override
	public User findUserByid(String id) {
		// TODO Auto-generated method stub
				String sql="select * from user where userid=?";
				try {
					QueryRunner runner=new QueryRunner(DaoUtils.getSource());
					return runner.query(sql, new BeanHandler<User>(User.class),id);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new RuntimeException("未找到");
				}
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		String sql="update user set username=?,nicknmame=?,gender=?,cellphone=?,email=? where id=?";
		try {
			QueryRunner runner=new QueryRunner(DaoUtils.getSource());
			runner.update(sql,user.getUsername(),user.getNickname(),user.getGender(),user.getCellphone(),user.getEmail(),user.getUserid());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public List<User> getPageUser(int i, int rowperpage) {
		// TODO Auto-generated method stub
		String sql = "select * from user limit ?,?";
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			return runner.query(sql, new BeanListHandler<User>(User.class),i,rowperpage);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public User getUser(User user) {
		// TODO Auto-generated method stub
		String sql="select * from user where userid=?";
		try {
			QueryRunner runner=new QueryRunner(DaoUtils.getSource());
			return runner.query(sql, new BeanHandler<User>(User.class),user.getUserid());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("未找到");
		}
	}

	@Override
	public int getCountRowbysearch(User user) {
		// TODO Auto-generated method stub
		String sql = "select count(*) from user where username=?";
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			return ((Long)runner.query(sql, new ScalarHandler(),user.getUsername())).intValue();
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public List<User> getSearchPageUser(int i, int rowperpage, User user) {
		// TODO Auto-generated method stub
		String sql = "select * from user limit ?,? where username=?";
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			return runner.query(sql, new BeanListHandler<User>(User.class),i,rowperpage,user.getUsername());
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}


	
}
