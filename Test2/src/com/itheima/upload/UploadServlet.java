package com.itheima.upload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FilePermission;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.itheima.util.IOUtils;

import sun.nio.ch.IOUtil;



/**
 * Servlet implementation class UploadServlet
 */
@WebServlet(description = "文件上传", urlPatterns = { "/UploadServlet" })
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpSep=rvlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//通过工厂类来实现
		DiskFileItemFactory factory=new DiskFileItemFactory();
		//设置缓冲区大小
		factory.setSizeThreshold(100*1024);
		//设置临时文件夹
		factory.setRepository(new File(this.getServletContext().getRealPath("WEB-INF/temp")));
		//2.生产文件上传核心类
		ServletFileUpload fileUpload=new ServletFileUpload(factory);
		try {
		//判断是否为真正的表单上传文件
		//if (fileUpload.isMultipartContent(request)) {
			//throw new RuntimeException("请用正确的表单上传");
		//}
		//设置文件大小的上传限制
		fileUpload.setFileSizeMax(1024*1024*10);
		fileUpload.setSizeMax(1024*1024*100);
		//设置编码
		fileUpload.setHeaderEncoding("UTF-8");
		//设置上传监听进度条：
		fileUpload.setProgressListener(new ProgressListener() {
			//
			Long beginTime = System.currentTimeMillis();
			//已经读了，总共多少 ，读到第几个了
			@Override
			public void update(long pBytesRead, long pContentLength, int pItems) {
				// TODO Auto-generated method stub
				//转换为kb
				//double br=pBytesRead*1.0/1024;
				//double cl=pContentLength*1.0/1024;
				//为了保留字节用以下方法
				BigDecimal br = new BigDecimal(pBytesRead).divide(new BigDecimal(1024),2,BigDecimal.ROUND_HALF_UP);
				BigDecimal cl = new BigDecimal(pContentLength).divide(new BigDecimal(1024),2,BigDecimal.ROUND_HALF_UP);
				System.out.print("当前读取的是第"+pItems+"个上传项,总大小"+cl+"KB,已经读取"+br+"KB");
				//剩余字节数
				BigDecimal ll = cl.subtract(br);
				System.out.print("剩余"+ll+"KB");
				//上传百分比
				BigDecimal per = br.multiply(new BigDecimal(100)).divide(cl,2,BigDecimal.ROUND_HALF_UP);
				System.out.print("已经完成"+per+"%");
				//上传用时
				Long nowTime = System.currentTimeMillis();
				Long useTime = (nowTime - beginTime)/1000;
				System.out.print("已经用时"+useTime+"秒");
				//上传速度
				BigDecimal speed = new BigDecimal(0);
				if(useTime!=0){
					//四舍五入模式向“最近邻居”转弯，除非两个邻居都是等距的，在这种情况下是圆括弧的。
					speed = br.divide(new BigDecimal(useTime),2,BigDecimal.ROUND_HALF_UP);
				}
				System.out.print("上传速度为"+speed+"KB/S");
				//大致剩余时间
				BigDecimal ltime = new BigDecimal(0);
				if(!speed.equals(new BigDecimal(0))){
					//返回一个 BigDecimal ，其值为 (this / divisor) ，其比例为指定。
					ltime = ll.divide(speed,0,BigDecimal.ROUND_HALF_UP);
				}
				System.out.print("大致剩余时间为"+ltime+"秒");
				
				System.out.println();
				}
		});
		
		//3.利用文件上传核心类来解析request
			List<FileItem> list=fileUpload.parseRequest(request);
			//循环遍历
			for(FileItem item :list){
				if (item.isFormField()) {
					//普通的字段获得的是一个表单？？
					String name=item.getFieldName();
					String value=item.getString("utf-8");
					System.out.println(name+":"+value);
				}else{
					//当前一个文件上传项
					String filename=item.getName();//文件名
					//设置一个独一无二的文件名
					String uuidfilename=UUID.randomUUID().toString()+"_"+filename;
					//转换为hash值
					int hash=uuidfilename.hashCode();
					//转化为hash字符串
					String hashstr=Integer.toHexString(hash);
					char[] hss=hashstr.toCharArray();
					String path=this.getServletContext().getRealPath("upload");
					for(char c:hss){
						path+="/"+c;
					}
					new File(path).mkdirs();
					InputStream inputStream=item.getInputStream();
					
					OutputStream outputStream=new FileOutputStream(new File(path,uuidfilename)); 
					IOUtils.In2Out(inputStream, outputStream);
					IOUtils.close(inputStream, outputStream);
					//删除临时文件
					item.delete();
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
