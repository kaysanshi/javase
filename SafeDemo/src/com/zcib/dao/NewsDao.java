package com.zcib.dao;

import java.sql.Connection;
import java.util.List;

import com.zcib.domain.News;
import com.zcib.domain.Video;
/**
 * 
 * @author 555
 *
 */
public interface NewsDao {
	/**
	 * 新闻添加
	 * @param news
	 * @param conn 
	 * @return 
	 */
	Boolean addNews(News news, Connection conn);
	/**
	 * 查找是否添加过这样的标题
	 * @param title
	 * @param conn
	 * @return
	 */
	News findNewsByName(String title, Connection conn);
	/**
	 *获取所有的新闻列表
	 * @return
	 */
	List<News> getAllNews();
	/**
	 * 获取总的行数
	 * @return
	 */
	int getCountRow();
	/**
	 * 获取分页参数
	 * @param i
	 * @param rowperpage
	 * @return
	 */
	List<News> getPageNews(int i, int rowperpage);
	/**
	 * 删除新闻
	 * @param news
	 * @return
	 */
	Boolean deleteNews(News news);
	/**
	 * 获得
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
