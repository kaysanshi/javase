package com.lyq.dao;

import java.util.List;

import com.lyq.persistence.Category;
import com.lyq.util.HibernateFilter;
/**
 * 药品类别数据库操作类
 * @author Li Yong Qiang
 */
public class CategoryDao extends SupperDao {
	
	/**
	 * 根据id查询类别
	 * @param id 
	 * @return Category
	 */
	public Category loadCategory(int id){
		Category c = null;
		try{
			session = HibernateFilter.getSession();		//获取Session对象
			session.beginTransaction();					//开启事物
			//加载类别信息
			c = (Category)session.load(Category.class, new Integer(id));
			session.getTransaction().commit();			//提交事物
		}catch(Exception e){
			e.printStackTrace();						//打印异常信息
			session.getTransaction().rollback();		//回滚事物
		}
		return c;
	}
	/**
	 * 查询所有类别
	 * @return List
	 */
	public List findAllCategory(){
		List list = null;
		try{
			session = HibernateFilter.getSession();		//获取Session对象
			session.beginTransaction();					//开启事物
			list = session.createQuery("from Category c")//创建Query对象
						  .list();						//获取结果集
			session.getTransaction().commit();			//提交事物
		}catch(Exception e){
			e.printStackTrace();						//打印异常信息
			session.getTransaction().rollback();		//回滚事物
		}
		return list;
	}
	/**
	 * 统计药品类别及数量
	 * @return
	 */
	public List findCategoryAndCount(){
		List list = null;
		try{
			session = HibernateFilter.getSession();		//获取Session对象
			session.beginTransaction();					//开启事物
			// 内连接查询语句
			String hql = "select c.name,count(*) from Medicine m join m.category c group by c";
			list = session.createQuery(hql)//创建Query对象
						  .list();						//获取结果集
			session.getTransaction().commit();			//提交事物
		}catch(Exception e){
			e.printStackTrace();						//打印异常信息
			session.getTransaction().rollback();		//回滚事物
		}
		return list;
	}
}
