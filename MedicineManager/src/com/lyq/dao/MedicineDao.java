package com.lyq.dao;

import com.lyq.persistence.Medicine;
import com.lyq.util.HibernateFilter;

/**
 * 药品数据库操作类
 * 
 * @author Li Yong Qiang
 */
public class MedicineDao extends SupperDao {
	/**
	 * 查询药品信息
	 * 
	 * @param id
	 * @return Medicine
	 */
	public Medicine loadMedicine(int id) {
		Medicine med = null;
		try {
			session = HibernateFilter.getSession(); // 获取Session对象
			session.beginTransaction(); // 开启事物
			// 加载药品信息
			med = (Medicine) session.load(Medicine.class, new Integer(id));
			session.getTransaction().commit(); // 提交事物
		} catch (Exception e) {
			e.printStackTrace(); // 打印异常信息
			session.getTransaction().rollback(); // 回滚事物
		}
		return med;
	}

	/**
	 * 通过fetch同时抓取药品和类别
	 * 
	 * @param id
	 * @return Medicine
	 */
	public Medicine loadMedicineAndCategory(int id) {
		Medicine med = null;
		try {
			session = HibernateFilter.getSession(); // 获取Session对象
			session.beginTransaction(); // 开启事物
			// HQL查询语句
			String hql = "select a from Medicine a join fetch a.category b where a.id = "
					+ id;
			med = (Medicine) session.createQuery(hql) // 创建Query对象
					.uniqueResult(); // 单值检索
			session.getTransaction().commit(); // 提交事物
		} catch (Exception e) {
			e.printStackTrace(); // 打印异常信息
			session.getTransaction().rollback(); // 回滚事物
		}
		return med;
	}

	/**
	 * 根据medNo查询
	 * 
	 * @param medNo
	 * @return Medicine
	 */
	public Medicine findMedicineByMedNo(String medNo) {
		Medicine med = null;
		try {
			session = HibernateFilter.getSession(); // 获取Session对象
			session.beginTransaction(); // 开启事物
			// HQL查询语句
			String hql = "from Medicine d where d.medNo = ?";
			med = (Medicine) session.createQuery(hql) // 创建Query对象
					.setParameter(0, medNo) // 对HQL动态赋值
					.uniqueResult(); // 返回单个对象
			session.getTransaction().commit(); // 提交事物
		} catch (Exception e) {
			e.printStackTrace(); // 打印异常信息
			session.getTransaction().rollback(); // 回滚事物
		}
		return med;
	}
}
