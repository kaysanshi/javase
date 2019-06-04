package com.zcib.service;

import java.util.List;

import com.zcib.domain.News;
import com.zcib.domain.Page;
/**
 * service
 * @author 555
 *
 */
public interface NewsService {
	/**
	 * 新闻添加
	 * @param news
	 * @return 
	 */
	Boolean addNews(News news);
	/**
	 * 获得新闻的列表
	 * @return
	 */
	List<News> getAllNews();
	/**
	 * 新闻分页
	 * @param thispage
	 * @param rowperpage
	 * @return
	 */
	Page getPageNews(int thispage, int rowperpage);
	/**
	 * 删除一条记录
	 * @param news
	 * @return
	 */
	Boolean deleteNews(News news);
	/**
	 * 获得一条记录的数据
	 * @param news
	 * @return
	 */
	News getNews(News news);
	/**
	 * 修改
	 * @param news
	 * @return
	 */
	Boolean updateNews(News news);

}
