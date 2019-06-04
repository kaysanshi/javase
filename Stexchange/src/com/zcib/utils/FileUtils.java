package com.zcib.utils;

import static org.hamcrest.CoreMatchers.nullValue;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.imageio.stream.FileImageInputStream;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;import sun.java2d.loops.FillParallelogram;
import sun.text.resources.iw.FormatData_iw_IL;
/**
 * 文件操作
 * @author 555
 *@date 2018年5月8日
 */
public class FileUtils {
	//储存表单信息
			private Map<String, Object> parameters=null;
			//储存文件上传的信息
			private Map<String, Object> file=null;
			//最大的上传文件的大小
			private long max_size=30*1024*1024;
		
			
			public FileUtils(){
				parameters=new HashMap<>();
				file=new HashMap<>();
			}
			/**
			 * 上传方法
			 * @param request
			 * @param uploadPath
			 * @param temp
			 * @return
			 * @throws IOException
			 */
			//问件上传；
			public int upload(HttpServletRequest request,String uploadPath,String temp) throws IOException{
				//实例一个硬盘文件工厂用来配置上传组件servletFileUpload
				DiskFileItemFactory factory=new DiskFileItemFactory();
				//设置临时文件夹
				factory.setRepository(new File(temp));
				//设置缓冲区的大小4kb
				factory.setSizeThreshold(4096);
				//实例化上传组件
				ServletFileUpload upload=new ServletFileUpload(factory);
				//设置上传的文件的尺寸
				upload.setSizeMax(max_size);
				//解决路径的 文件名的乱码问题
				upload.setHeaderEncoding("UTF-8");
				List  filelist=null;
				try {
					//获取request对象
					//把request转成FileItem的实例
					filelist=upload.parseRequest(request);
					//FileDescription=request.getParameter("description");
					//System.out.println("文件名："+FileDescription);
				} catch (FileUploadException e) {
					// TODO Auto-generated catch block
					//判断是否为这个异常的一个：你属于该类吗？或者你属于该类的派生类吗？
					if (e instanceof SizeLimitExceededException) {
						System.out.println("文件大小超过"+max_size+"字节");
						return 0;
					}
					e.printStackTrace();
				}
				Iterator fIterator=filelist.iterator();
				while(fIterator.hasNext()){
					FileItem fileItem=null;//
					String sourceFilePath=null;//文件的路径
					String sourceFileName=null;//文件的完整名字
					String fileExt=null;//文件的扩展名
					String filePath=null;
					String realPath=null;
					long size=0;
					fileItem=(FileItem)fIterator.next();
					//如果问价中是上传问价而不是表单信息
					if(!fileItem.isFormField()){
						//得到文件的完整路径
						sourceFilePath=fileItem.getName();
						//System.out.println("是能获取："+fileItem.getString());
						//获得uuid的名字
						String uuidfilename=UUID.randomUUID().toString()+"_"+sourceFilePath;
						size=fileItem.getSize();
						
						if (!sourceFilePath.equals("") && size!=0) {
							//得到去除路径的文件名
							sourceFileName=sourceFilePath.substring(sourceFilePath.lastIndexOf("\\")+1);
							//得到文件的扩展名
							fileExt=sourceFileName.substring(sourceFileName.lastIndexOf(".")+1);
							System.out.println("文件的扩展名是："+fileExt);
							//以当前系统时间保存上传文件
							long systemTime=System.currentTimeMillis();
							//
							//filePath=uploadPath+"/"+systemTime+"."+fileExt;
							filePath=uploadPath+"/"+uuidfilename;
							//真实路径
							realPath=request.getServletContext().getRealPath(filePath);
							//获取虚拟路径
							System.out.println(uuidfilename);
							try{
								System.out.println(realPath);
								fileItem.write(new File(realPath));
							}catch(Exception e){
								e.printStackTrace();
								return 0;
							}
							System.out.println(String.valueOf(size));
							System.out.println(filePath);
							System.out.println(sourceFileName);
							//获取fileExt及文件的扩展名
							file.put("fileExt", fileExt);
							file.put("size", String.valueOf(size));
							file.put("filePath", filePath);
							file.put("filename", sourceFileName);
							file.put("uuidname", uuidfilename);
							//未能获取
							//file.put("description",FileDescription);
							String ip=request.getRemoteAddr();
							System.out.println(ip);
							file.put("ip",ip);
						}
					}else{
						//如果不是上传的文件而是表单信息，则将信息保存在paramters中
						String descName=fileItem.getFieldName();
						//获取name属型的值非文件
						String value=fileItem.getString("UTF-8");
						System.out.println("value:"+value);
						file.put(descName, value);
						System.out.println("这个是："+descName);
					}
					
				}
				return 1;
			}
			/**
			 * 下载的方法
			 * @param servletContext
			 * @param response
			 * @param file
			 * @return
			 * @throws IOException
			 */
			//下载文件的方法，参数Map储存下载文件的信息，包括文件的地址filePath和名称的fileName
			public int download(ServletContext servletContext,HttpServletResponse response,Map file,HttpServletRequest request) throws IOException{
//					String filePath=(String)file.get("savepath");
//					System.out.println(filePath+"////");
//					String realPath=servletContext.getRealPath(filePath);
//					System.out.println(realPath+";;");
					///
				//4.如果存在提供下载

				//
					System.out.println("文件的真实名字："+(String)file.get("realname"));
					response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode((String)file.get("realname"),"UTF-8"));
					response.setContentType(servletContext.getMimeType((String)file.get("realname")));
					String Path = servletContext.getRealPath( file.get("savepath")+"/"+file.get("uuidname"));
					System.out.println("PAth:"+Path);
					
					InputStream in = new FileInputStream(Path);
					OutputStream out = response.getOutputStream();
					
					IOUtils.In2Out(in, out);
					IOUtils.close(in, null);
					return 1;
			}
			public Map<String,Object> getFile(){
				return file;
				
			}
			public Map<String, Object> getParameters(){
				return parameters;
			}
			public void setMax_size(long max_size){
				this.max_size=max_size;
			}
			
		}

