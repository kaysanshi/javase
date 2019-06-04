package com.zcib.dao;


import java.util.List;
import java.util.Map;

import com.zcib.domain.Student;
import com.zcib.utils.DBUtils;
import com.zcib.utils.PageBean;

/**
 * student用于操作数据层
 * @author 555
 *@date 2018年5月8日
 */
public class StudentDao {
	/**
	 * 注册学生
	 * @param student
	 * @return
	 */
	public boolean registStudent(Student student) {
		// TODO Auto-generated method stub
		String sql="insert into student(id,username,password) values(?,?,?)";
		String[] params={
				null,student.getUsername(),student.getPassword()
		};
		DBUtils db=new DBUtils();
		int status=db.update(sql, params);
		if (status!=0) {
			return true;
		}else{
			return false;
		}
		
	}
	/**
	 * 核对用户用于登录
	 * @param username
	 * @param password
	 * @return
	 */
	public Student checkUser(String username, String password) {
		// TODO Auto-generated method stub
		Student student=new Student();
		String sql="select id,username,password from student where username=? && password=?";
		String[] params={username,password};
		DBUtils dbUtils=new DBUtils();
		Map map=dbUtils.getMap(sql, params);
		if (map==null) {
			return student;
		}
		student.setUsername(map.get("username").toString());
		student.setPassword(map.get("password").toString());
		student.setId((int)(map.get("id")));
		return student;
	}
	public List<Map<String, Object>> getInfoById(Student student) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> list=null;
		String sql="select * from student where id=?";
		String[] params={String.valueOf(student.getId())};
		list=new DBUtils().getList(sql, params);
		return list;
	}
	/**
	 * 
	 * @param student
	 * @return
	 */
	public boolean saveInfo(Student student) {
		// TODO Auto-generated method stub
		String sql="update student set realname=?,sex=?,age=?,address=?,email=?,addtime=? where id=?";
		System.out.println(student.getId());
		String[] params={student.getRealname(),student.getSex(),String.valueOf(student.getAge()),student.getAddress(),student.getEmail(),student.getAddtime(),String.valueOf(student.getId())};
		DBUtils db=new DBUtils();
		int i=db.update(sql, params);
		System.out.println(i);
		if (i>0) {
			return true;
		}else{
			System.out.println("未能成功添加");
			return false;
		}
	}
	/**
	 * 修改信息
	 * @param student
	 * @return
	 */
	public boolean updateInfo(Student student) {
		// TODO Auto-generated method stub
		String sql="update student set password=?,realname=?,sex=?,age=?,address=?,email=?,addtime=? where id=?";
		System.out.println(student.getId());
		String[] params={student.getPassword(),student.getRealname(),student.getSex(),String.valueOf(student.getAge()),student.getAddress(),student.getEmail(),student.getAddtime(),String.valueOf(student.getId())};
		DBUtils db=new DBUtils();
		int i=db.update(sql, params);
		System.out.println(i);
		if (i>0) {
			return true;
		}else{
			System.out.println("未能够修改");
			return false;
		}
	}
	/**
	 * 
	 * @return
	 */
	public List<Map<String, Object>> getAllStudent() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 
	 * @param curPage
	 * @return
	 */
	public PageBean getAllStudentPageBean(int curPage) {
		// TODO Auto-generated method stub
		String sql="select id,username,password,realname,sex,age,address,email,addtime from student";
		DBUtils db=new DBUtils();
		return db.getPageBean(sql,new String[]{}, curPage);
	}
	/**
	 * 
	 * @param student
	 * @return
	 */
	public int deletStudent(Student student) {
		// TODO Auto-generated method stub
		String sql="delete from student where id=?";
		DBUtils dbUtils=new DBUtils();
		String[] params={String.valueOf(student.getId())};
		int i=dbUtils.update(sql, params);	
		return i;
	}

}
