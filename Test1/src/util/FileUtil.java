package util;
//文件上传和下载

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUtil {
	//储存表单信息
	private Map parameters=null;
	//储存文件上传的信息
	private Map file=null;
	//最大的上传文件的大小
	private long max_size=30*1024*1024;
	
	public FileUtil(){
		parameters=new HashMap<>();
		file=new HashMap<>();
	}
	//问件上传；
	public int upload(HttpServletRequest request,String uploadPath) throws IOException{
		//实例化一个硬盘文件，用来配置上传的组件servletFileUpload
		//实例一个硬盘文件工厂用来配置上传组件servletFileUpload
		DiskFileItemFactory factory=new DiskFileItemFactory();
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
			String sourceFileName=null;//问件的完整名字
			String fileExt=null;//文件的扩展名
			String filePath=null;
			String realPath=null;
			long size=0;
			fileItem=(FileItem)fIterator.next();
			//如果问价中是上传问价而不是表单信息
			if(!fileItem.isFormField()){
				//得到文件的完整路径
				sourceFilePath=fileItem.getName();
				size=fileItem.getSize();
				if (!sourceFilePath.equals("") && size!=0) {
					//得到去除路径的文件名
					sourceFileName=sourceFilePath.substring(sourceFilePath.lastIndexOf("\\")+1);
					//得到文件的扩展名
					fileExt=sourceFileName.substring(sourceFileName.lastIndexOf(".")+1);
					//以当前系统时间保存上传文件
					long systemTime=System.currentTimeMillis();
					//
					filePath=uploadPath+"/"+systemTime+"."+fileExt;
					//真实路径
					realPath=request.getServletContext().getRealPath(filePath);
					try{
						fileItem.write(new File(realPath));
					}catch(Exception e){
						e.printStackTrace();
						return 0;
					}
					file.put("size", String.valueOf(size));
					file.put("filePath", filePath);
					file.put("filename", sourceFileName);
					
				}
			}else{
				//如果不是上传的文件而是表单信息，则将信息保存在paramters中
				String fileldName=fileItem.getFieldName();
				String value=fileItem.getString("UTF-8");
				parameters.put(fileldName, value);
			}
			
		}
		return 1;
	}
	//下载文件的方法，参数Map储存下载文件的信息，包括文件的地址filePath和名称的fileName
	public int download(ServletContext servletContext,HttpServletResponse response,Map file) throws IOException{
		BufferedInputStream bis=null;
		BufferedOutputStream bos=null;
		try{
			String filePath=(String)file.get("filePath");
			String realPath=servletContext.getRealPath(filePath);
			long fileLength=new File(realPath).length();
			response.setHeader("Content-dispostion", "attachment;filename="+new String(((String)file.get("fileName")).getBytes("UTF-8"),"ISO8859-1"));
			bis=new BufferedInputStream(new FileInputStream(realPath));
			bos=new BufferedOutputStream(response.getOutputStream());
			byte[] buff=new byte[2048];
			int bytesRead;
			while((bytesRead=bis.read(buff,0,buff.length))!=-1){
				bos.write(buff,0,bytesRead);
			}
		}catch(Exception e){
			return 0;
		}finally {
			if (bis!=null) {
				bis.close();
			}if (bos!=null) {
				bos.close();
			}
			
		}
		return 1;
	}
	public Map getFile() {
		return file;
		
	}
	public Map getParameters(){
		return parameters;
	}
	public void setMax_size(long max_size){
		this.max_size=max_size;
	}
	
}
