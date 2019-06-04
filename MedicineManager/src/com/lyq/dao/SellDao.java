package com.lyq.dao;

import java.util.ArrayList;
import java.util.List;

import com.lyq.persistence.SellDetail;
import com.lyq.persistence.SellSeq;
import com.lyq.util.HibernateFilter;
/**
 * 药品销售数据库操作类
 * @author Li Yong Qiang
 */
public class SellDao extends SupperDao{
	/**
	 * 保存销售明细
	 * @param sd SellDetail对象
	 */
	public void saveSellDetail(SellDetail sd){
		try {
			session = HibernateFilter.getSession();		//获取Session对象
			session.beginTransaction();					//开启事物
			session.save(sd);							//保存销售信息
			session.getTransaction().commit();			//提交事物
		} catch (Exception e) {
			e.printStackTrace();						//打印异常信息
			session.getTransaction().rollback();		//回滚事物
		}
	}
	
	/**
	 * 查询销售排行
	 * @return List
	 */
	public List sellSeq(){
		List list = null;
		try {
			session = HibernateFilter.getSession();		//获取Session对象
			session.beginTransaction();					//开启事物
			//HQL查询语句
			String hql = "select s.sellName,sum(s.sellPrice),sum(s.sellCount)," +
					"m.id from SellDetail s join s.med m " +
					"group by m order by sum(s.sellCount) desc";
			List temp = session.createQuery(hql)		//创建Query对象
							   .setFirstResult(0)		//起始位置
							   .setMaxResults(10)		//偏移量
							   .list();					//获取结果集
			if(temp != null && temp.size() > 0){
				list = new ArrayList();
				for (int i = 0; i < temp.size(); i++) {
					Object[] obj = (Object[])temp.get(i);
					SellSeq s = new SellSeq();
					s.setName(obj[0].toString());
					s.setTotalPrice((Double)obj[1]);
					s.setTotalCount((Long)obj[2]);
					s.setMedId(((Integer)obj[3]));
					list.add(s);
				}
			}
			session.getTransaction().commit();			//提交事物
		} catch (Exception e) {
			e.printStackTrace();						//打印异常信息
			session.getTransaction().rollback();		//回滚事物
		}
		return list;
	}
}
