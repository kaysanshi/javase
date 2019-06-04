package com.xiaoxiao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xiaoxiao.utils.Upload;



public class ImageUploadServlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String path = "/uploadimages/";//上传路径
		request.setAttribute("path", Upload.upload(path,request,response));
		request.getRequestDispatcher("/admin/upload.jsp").forward(request,response);
	}
//	//返回上传后的路径,带文件名（相对于项目）
//	public String upload(String path,HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		/*
//		 * 1.创建工厂对象
//		 */
//		DiskFileItemFactory factory = new DiskFileItemFactory();
//		//2.通过工厂对象创建解析器
//		ServletFileUpload sfu = new ServletFileUpload(factory);
//		
//		String filepath = "";//上传文件后的路径
//		try {
//			//3.解析request，获取FileItem的列表
//			List<FileItem> items = sfu.parseRequest(request);
//			//4.通过循环获取表单项
//			for(FileItem item :items){
//				//判断是否是普通表单项
//				if(item.isFormField()){
//					String name = item.getFieldName();//获取表单项的name
//					String value = item.getString("utf-8");//获取表单项的值，utf-8是防止中文乱码
//					System.out.println(name+":"+value);
//				}else{
//					//文件表单项
//					String filename = item.getName();//获取文件名
//					System.out.println(filename);
//					// e:/a/b.txt
//					//截取文件名
//					int index = filename.indexOf("\\");
//					if(index!=-1){
//						filename = filename.substring(index+1);
//					}
//					
//					//防止上传重名的问题
//					filename = UUID.randomUUID().toString().replace("-", "")+filename;
//					
//					File file = new File(this.getServletContext().getRealPath(path+filename));
//					if(!file.exists()){
//						file.getParentFile().mkdirs();//创建上层目录
//					}
//					//保存
//					item.write(file);
//					filepath = path + filename;
//				}
//			}
//			
//		} catch (FileUploadException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return filepath;
//	}

}
