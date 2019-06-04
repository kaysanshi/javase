package com.lyq.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lyq.struts.form.MedicineForm;

/**
 * 条件查询工具类
 * @author Li Yong Qiang
 */
public class QueryUtil {
	/**
	 * 多条件查询药品
	 * @param form
	 * @param currPage
	 * @param action
	 * @return Map对象
	 */
	public static Map queryMedicine(MedicineForm form,String currPage,String action){
		//创建Map对象
		Map map = new HashMap();
		//HQL语句
		String hql = "from Medicine d where 1=1";
		//创建List集合，用于装载查询参数
		List temp = new ArrayList();
		//超链接乱码处理
		boolean flag = false;
		String s;
		if(currPage != null && !currPage.isEmpty()){
			flag = true;
		}
		//如果药品id存在，加入id条件
		if(form.getId() > 0){
			hql += " and d.id = ?";
			temp.add(new Integer(form.getId()));
			action += "&id=" + form.getId();
		}
		//如果药品编号存在，加入药品编号条件
		if(form.getMedNo() != null && !form.getMedNo().isEmpty()){
			hql += " and d.medNo = ?";
			s = form.getMedNo();
			if(flag){
				s = StringUtil.encodeZh(s);
			}
			temp.add(s);
			action += "&medNo=" + StringUtil.encodeURL(s);
		}
		//如果药品名称存在，加入药品名称条件
		if(form.getName() != null && !form.getName().isEmpty()){
			hql += " and d.name = ?";
			s = form.getName();
			if(flag){
				s = StringUtil.encodeZh(s);
			}
			temp.add(s);
			action += "&name=" + StringUtil.encodeURL(s);
		}
		//如果药品厂址存在，加入药品厂址条件
		if(form.getFactoryAdd() != null && !form.getFactoryAdd().isEmpty()){
			hql += " and d.factoryAdd = ?";
			s = form.getFactoryAdd();
			if(flag){
				s = StringUtil.encodeZh(s);
			}
			temp.add(s);
			action += "&factoryAdd=" + StringUtil.encodeURL(s);
		}
		//如果药品描述信息存在，加入药品描述信息条件
		if(form.getDescription() != null && !form.getDescription().isEmpty()){
			hql += " and d.description like ?";
			s = form.getDescription();
			if(flag){
				s = StringUtil.encodeZh(s);
			}
			temp.add("%" + s + "%");
			action += "&description=" + StringUtil.encodeURL(s);
		}
		//将HQL查询语句放入到map中
		map.put("hql", hql);
		//将action放入到map中
		map.put("action", action);
		//将查询参数的数组放入到map中
		map.put("where", temp.toArray());
		return map;
	}
}
