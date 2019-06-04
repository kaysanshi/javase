package com.lyq.dao;

import java.util.Date;

import org.hibernate.Query;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.lyq.persistence.Category;
import com.lyq.persistence.Medicine;
import com.lyq.persistence.User;
import com.lyq.util.HibernateFilter;
/**
 * 用户数据库操作类
 * 用于查询用户及系统初始化
 * @author Li Yong Qiang
 */
public class UserDao extends SupperDao {
	/**
	 * 查询用户
	 * @param userName
	 * @param password
	 * @return User
	 */
	public User login(String userName,String password){
		User user = null;
		try {
			session = HibernateFilter.getSession();		//获取Session对象
			session.beginTransaction();					//开启事物
			//HQL查询语句
			String hql = "from User u where u.username=? and u.password=?";
			Query query = session.createQuery(hql)		//创建Query对象
								.setParameter(0, userName)//动态赋值
								.setParameter(1, password);//动态赋值
			user = (User)query.uniqueResult();			//返回User对象
			session.getTransaction().commit();			//提交事物
		} catch (Exception e) {
			e.printStackTrace();						//打印异常信息
			session.getTransaction().rollback();		//回滚事物
		}
		return user;
	}
	/**
	 * 根据id查询用户
	 * @param id
	 * @return User
	 */
	public User loadUser(int id){
		User user = null;
		try {
			session = HibernateFilter.getSession();		//获取Session对象
			session.beginTransaction();					//开启事物
			//根据id加载用户
			user = (User)session.load(User.class, new Integer(id));
			session.getTransaction().commit();			//提交事物
		} catch (Exception e) {
			e.printStackTrace();						//打印异常信息
			session.getTransaction().rollback();		//回滚事物
		}
		return user;
	}
	/**
	 * 系统初始化数据
	 */
	public void initialization(){
		try {
			Configuration cfg = new Configuration().configure();
			SchemaExport export = new SchemaExport(cfg);
			export.create(true, true);
			session = HibernateFilter.getSession();		//获取Session对象
			session.beginTransaction();					//开启事物

			Category c1 = new Category();
			c1.setName("感冒用药");
			c1.setDescription("主治感冒、发烧、头痛。");
			c1.setCreateTime(new Date());
			
			Category c2 = new Category();
			c2.setName("胃肠用药");
			c2.setDescription("胃炎、肠炎专用药。");
			c2.setCreateTime(new Date());
			
			Category c3 = new Category();
			c3.setName("儿童用药");
			c3.setDescription("慎用，儿童用药。");
			c3.setCreateTime(new Date());
			
			Medicine d1 = new Medicine();
			d1.setName("感冒胶囊A");
			d1.setPrice(2.5);
			d1.setMedCount(3);
			d1.setCategory(c1);
			d1.setFactoryAdd("制药一厂");
			d1.setDescription("效果很好");
			d1.setMedNo("abc001");
			
			Medicine d2 = new Medicine();
			d2.setName("感冒胶囊B");
			d2.setPrice(10.05);
			d2.setMedCount(10);
			d2.setCategory(c1);
			d2.setFactoryAdd("制药一厂");
			d2.setDescription("治疗伤风、头痛效果很好");
			d2.setMedNo("abc002");
			
			Medicine d3 = new Medicine();
			d3.setName("xx肠炎灵");
			d3.setPrice(5.8);
			d3.setMedCount(100);
			d3.setCategory(c2);
			d3.setFactoryAdd("制药二厂");
			d3.setDescription("主治拉肚子");
			d3.setMedNo("abc003");
			
			Medicine d4 = new Medicine();
			d4.setName("小儿感冒冲剂");
			d4.setPrice(5.8);
			d4.setMedCount(100);
			d4.setCategory(c3);
			d4.setFactoryAdd("制药三厂");
			d4.setDescription("效果很好");
			d4.setMedNo("abc004");
			
			User u = new User();
			u.setUsername("admin");
			u.setPassword("admin");
			u.setCreateTime(new Date());
			
			session.save(d1);
			session.save(d2);
			session.save(d3);
			session.save(d4);
			session.save(u);
			
			session.getTransaction().commit();			//提交事物
		} catch (Exception e) {
			session.getTransaction().rollback();		//回滚事物
			e.printStackTrace();
		}finally{
			if(session != null){
				if(session.isOpen()){
					session.close();
				}
			}
		}
	}
}
