package com.zcib.dao;

import java.sql.Connection;
import java.util.List;

import com.zcib.domain.Resource;

public interface  ResourceDao {
	/**
	 * 获得行
	 * @return
	 */
	int getCountRow();
	/**
	 * 获得列表
	 * @param i
	 * @param rowperpage
	 * @return
	 */
	List<Resource> getPageResource(int i, int rowperpage);
	/**
	 * 添加资源
	 * @param resource
	 * @return
	 */
	Boolean addResource(Resource resource,Connection conn);
	/**
	 * 获取一条记录
	 * @param resource
	 * @return
	 */
	Resource getResource(Resource resource);
	/**
	 * 修改资源
	 * @param resource
	 * @return
	 */
	Boolean updateResource(Resource resource);
	/**
	 * 删除资源
	 * @param resource
	 * @return
	 */
	boolean deleteResource(Resource resource);

}
