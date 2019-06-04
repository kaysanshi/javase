package com.zcib.service;

import java.util.List;
import java.util.Map;

import com.zcib.dao.FileDao;
import com.zcib.domain.Files;
import com.zcib.utils.PageBean;

/**
 * 文件的操作的类
 * @author 555
 *@date 2018年5月13日
 */
public class FileService {
		FileDao dao=new FileDao();
		/**
		 * 文件的添加
		 * @param files
		 * @return
		 */
		public boolean addFile(Files files) {
			return dao.addFile(files);
			// TODO Auto-generated method stub
			
		}
		/**
		 * 获得文件列表
		 * @return
		 */
		public List<Map<String,Object>> getListFile() {
			// TODO Auto-generated method stub
			return dao.getListFile();
		}
		//获得总数
//		public int getTotarow() {
//			// TODO Auto-generated method stub
//			return dao.getTotalRow();
//		}
		/**
		 * 获取pageBan
		 * @param curPage
		 * @return
		 */
		public PageBean getPageBean(int curPage) {
			// TODO Auto-generated method stub
			return dao.getPageBean(curPage);
		}
		/**
		 * 查询封装到bean中
		 * @param filename
		 * @param curPage
		 * @param teacherid 
		 * @return
		 */
		public PageBean search(String filename, int curPage, String teacherid) {
			String sql=null;
				if(filename==null || filename.equals("")){
				  return null;
				}else{
				   sql="select * from files where filetitle like ?&& uploadteacherid=? ";
				   String[] params={"%"+filename+"%",teacherid};
				   return dao.getSerachBean(sql, params, curPage);
				}

			}
		/**
		 * 删除文件
		 * @param filesid
		 * @return
		 */
		public boolean deletefile(String filesid) {
			// TODO Auto-generated method stub
			return dao.deltefile(filesid);
		}
		/**
		 * 获取一条
		 * @param id
		 * @return
		 */
		public List<Map<String, Object>> getFileById(String id) {
			// TODO Auto-generated method stub
			return dao.getFileById(id);
		}
		/**
		 * 查询
		 * @param curPage
		 * @param filename
		 * @return
		 */
		public PageBean SearchPageBean(int curPage, String filename) {
			// TODO Auto-generated method stub
			
			return dao.SearchPageBean(curPage,filename);
		}
		/**
		 * 
		 * @param curPage
		 * @param teacherid
		 * @return
		 */
		public PageBean getPageBean(int curPage, String teacherid) {
			// TODO Auto-generated method stub
			return dao.getPageBean(curPage,teacherid);
		}
		/**
		 * 学生获得全部
		 * @param curPage
		 * @return
		 */
		public PageBean getAllPageBean(int curPage) {
			// TODO Auto-generated method stub
			return dao.getAllPageBean(curPage);
		}
		/**
		 * 修改
		 * @param files
		 * @return
		 */
		public int updateSaveFile(Files files) {
			// TODO Auto-generated method stub
			return dao.updateSaveFile(files);
		}
		
}
