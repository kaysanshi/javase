package com.zcib.service;

import java.sql.Connection;
import java.util.List;

import com.zcib.dao.NewsDao;
import com.zcib.domain.News;
import com.zcib.domain.Page;
import com.zcib.domain.Video;
import com.zcib.factory.BasicFactory;
import com.zcib.utils.DaoUtils;
/**
 * 
 * @author 555
 *
 */
public class NewsServiceImpl implements NewsService{
	NewsDao dao=BasicFactory.getFactory().GetInstance(NewsDao.class);
	@Override
	public Boolean addNews(News news) {
		// TODO Auto-generated method stub
		Connection conn = DaoUtils.getConnection();
		//1.
		if(dao.findNewsByName(news.getTitle(),conn)!=null){
			throw new RuntimeException("已有这个标题!!");
		}
		return dao.addNews(news,conn);
	}
	@Override
	public List<News> getAllNews() {
		// TODO Auto-generated method stub
		return dao.getAllNews();
	}
	@Override
	public Page getPageNews(int thispage, int rowperpage) {
		// TODO Auto-generated method stub
		Page page = new Page();
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
		List<News> list = dao.getPageNews((thispage-1)*rowperpage,rowperpage);
		page.setList(list);
		
		return page;
	}
	@Override
	public Boolean deleteNews(News news) {
		// TODO Auto-generated method stub
		return dao.deleteNews(news);
	}
	@Override
	public News getNews(News news) {
		// TODO Auto-generated method stub
		return dao.getNews(news);
	}
	@Override
	public Boolean updateNews(News news) {
		// TODO Auto-generated method stub
		return dao.updateNews(news);
	}

}
