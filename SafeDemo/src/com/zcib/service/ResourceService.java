package com.zcib.service;

import com.zcib.domain.Page;
import com.zcib.domain.Resource;

public interface ResourceService {
	/**
	 * 分页
	 * @param thispage
	 * @param rowperpage
	 * @return
	 */
	Page getPageResource(int thispage, int rowperpage);
	/**
	 * 添加资源
	 * @param resource
	 * @return 
	 */
	Boolean  addResource(Resource resource);
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
	 * 删除
	 * @param resource
	 * @return
	 */
	boolean deleteResource(Resource resource);

}
