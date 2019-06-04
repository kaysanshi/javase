package com.zcib.service;

import java.util.List;
import java.util.Map;

import com.zcib.dao.TeacherDao;
import com.zcib.domain.Teacher;
import com.zcib.utils.PageBean;

/**
 * 业务逻辑层
 * @author 555
 *@date 2018年5月12日
 */
public class TeacherService {
		 private TeacherDao dao=new TeacherDao();
		/**
		 * 登录
		 * @param username
		 * @param password
		 * @return
		 */
		public Teacher cherckUser(String username, String password) {
			// TODO Auto-generated method stub
			return dao.cherckUser(username,password);
		}
		/**
		 * 注册用户
		 * @param teacher
		 * @return
		 */
		public boolean registTeacher(Teacher teacher) {
			// TODO Auto-generated method stub
			return dao.registTeacher(teacher);
		}
		/**
		 * 获取所有教师
		 * @return
		 */
		public List<Map<String, Object>> getAllTeacher(){
			// TODO Auto-generated method stub
			return dao.getAllTeacher();
		}
		/**
		 * 获取教师个人信息
		 * @param teacherid
		 * @return
		 */
		public List<Map<String, Object>> getTeacherId(String teacherid) {
			// TODO Auto-generated method stub
			return dao.getTeacherId(teacherid);
		}
		/**
		 * 教师信息完善
		 * @param teacher
		 * @return
		 */
		public boolean saveInfo(Teacher teacher) {
			// TODO Auto-generated method stub
			return dao.saveInfo(teacher);
		}
		/**
		 * 修改
		 * @param teacher
		 * @return
		 */
		public boolean updateInfo(Teacher teacher) {
			// TODO Auto-generated method stub
			return dao.updateInfo(teacher);
		}
		/**
		 * 获取所有教师列表
		 * @param curPage
		 * @return
		 */
		public PageBean getAllTeacherPageBean(int curPage) {
			// TODO Auto-generated method stub
			return dao.getAllTeacherPageBean(curPage);
		}
		public int deletTeacher(Teacher teacher) {
			// TODO Auto-generated method stub
			return dao.deletTeacher(teacher);
		}
}
