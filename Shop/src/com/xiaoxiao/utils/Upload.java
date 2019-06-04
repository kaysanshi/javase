package com.xiaoxiao.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class Upload {
	public static String upload(String dir,HttpServletRequest request, HttpServletResponse response)
  			throws ServletException, IOException {
  		
  		/*
  		 * 1.创建DiskFileItemFactory对象
  		 * 2.使用工厂对象创建解析器
  		 * 3.使用解析器获取FileItem集合
  		 * 4.循环遍历FileItem集合，取出相应的表单项，如果是文件项，则保存到磁盘中
  		 */
  		//1.创建DiskFileItemFactory对象
  		DiskFileItemFactory factory = new DiskFileItemFactory();
  		//2.使用工厂对象创建解析器
  		ServletFileUpload sfu = new ServletFileUpload(factory);
  		
  		String filename = "";
  		
  		try {
  			//3.使用解析器获取FileItem集合
  			List<FileItem> fileItemList = sfu.parseRequest(request);
  			//4.循环遍历FileItem集合，取出相应的表单项，如果是文件项，则保存到磁盘中
  			for(FileItem fileItem:fileItemList){
  				//每次循环需要判断fileItem对象是否是表单项，分类型处理
  				if(!fileItem.isFormField()){//是普通表单项
  					//是文件表单项
  					//获取文件名，获取的为在客户端上的绝对路径（带盘符）
  					filename = fileItem.getName();
  					//截取文件名
  					int index = filename.lastIndexOf("\\");
  					if(index!=-1){
  						filename=filename.substring(index+1);
  					}
  					//文件名唯一，且一个文件夹不能放置太多的文件
  					//使用年月日作为文件的放置路径，使用uuid作为文件名前缀
  					//Date date = new Date();
  					
  					//获取年月日
//  					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//  					dir = dir+ sdf.format(date).replace("-", "/")+"/";
  					
  					//文件保存名称：加上uuid，保证文件名唯一
  					filename = UUID.randomUUID().toString().replace("-", "") + filename;
  					//构造一个文件对象
  					//获取项目路径下的绝对地址。
  					File file = new File(request.getServletContext().getRealPath(dir+filename));//这里是保存路径
  					if(!file.exists()){
  						file.getParentFile().mkdirs();//如果父目录不存在创建它们
  					}
  					fileItem.write(file);
  					filename = dir + filename;
  				}
  			}
  		} catch (FileUploadException e) {
  			throw new RuntimeException(e);
  		} catch (Exception e) {
  			throw new RuntimeException(e);
  		}
  		return filename;
  	}
}
