package com.zcib.service;

import java.sql.Connection;
import java.util.List;

import com.zcib.dao.ResourceDao;
import com.zcib.domain.Page;
import com.zcib.domain.Resource;
import com.zcib.factory.BasicFactory;
import com.zcib.utils.DaoUtils;
public class ResourceServiceImpl implements ResourceService {
	ResourceDao dao=BasicFactory.getFactory().GetInstance(ResourceDao.class);

	@Override
	public Page getPageResource(int thispage, int rowperpage) {
		// TODO Auto-generated method stub
		Page page=new Page();
		//--当前页
		page.setThispage(thispage);
		//--每页记录数
		page.setRowperpage(rowperpage);
		//--共有多少行
		int countrow = dao.getCountRow();
		page.setCountrow(countrow);
		//--共有多少页
		int countpage = countrow/rowperpage+(countrow%rowperpage==0?0:1);
		page.setCountpage(countpage);
		//--首页
		page.setFirstpage(1);
		//--尾页
		page.setLastpage(countpage);
		//--上一页
		page.setPrepage(thispage==1?1:thispage-1);
		//--下一页
		page.setNextpage(thispage == countpage ? countpage : thispage+1);
		//--当前页数据
		List<Resource> list = dao.getPageResource((thispage-1)*rowperpage,rowperpage);
		page.setList(list);
		
		return page;
	}

	@Override
	public Boolean addResource(Resource resource) {
		// TODO Auto-generated method stub
		Connection conn = DaoUtils.getConnection();
		 return dao.addResource(resource,conn);
	}

	@Override
	public Resource getResource(Resource resource) {
		// TODO Auto-generated method stub
		return dao.getResource(resource);
	}

	@Override
	public Boolean updateResource(Resource resource) {
		// TODO Auto-generated method stub
		return dao.updateResource(resource);
	}

	@Override
	public boolean deleteResource(Resource resource) {
		// TODO Auto-generated method stub
		return dao.deleteResource(resource);
	}
}
