package util;
//�ļ��ϴ�������

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
	//�������Ϣ
	private Map parameters=null;
	//�����ļ��ϴ�����Ϣ
	private Map file=null;
	//�����ϴ��ļ��Ĵ�С
	private long max_size=30*1024*1024;
	
	public FileUtil(){
		parameters=new HashMap<>();
		file=new HashMap<>();
	}
	//�ʼ��ϴ���
	public int upload(HttpServletRequest request,String uploadPath) throws IOException{
		//ʵ����һ��Ӳ���ļ������������ϴ������servletFileUpload
		//ʵ��һ��Ӳ���ļ��������������ϴ����servletFileUpload
		DiskFileItemFactory factory=new DiskFileItemFactory();
		//���û������Ĵ�С4kb
		factory.setSizeThreshold(4096);
		//ʵ�����ϴ����
		ServletFileUpload upload=new ServletFileUpload(factory);
		//�����ϴ����ļ��ĳߴ�
		upload.setSizeMax(max_size);
		//���·���� �ļ�������������
		upload.setHeaderEncoding("UTF-8");
		List  filelist=null;
		try {
			//��ȡrequest����
			//��requestת��FileItem��ʵ��
			filelist=upload.parseRequest(request);
			
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			//�ж��Ƿ�Ϊ����쳣��һ���������ڸ����𣿻��������ڸ������������
			if (e instanceof SizeLimitExceededException) {
				System.out.println("�ļ���С����"+max_size+"�ֽ�");
				return 0;
			}
			e.printStackTrace();
		}
		Iterator fIterator=filelist.iterator();
		while(fIterator.hasNext()){
			FileItem fileItem=null;//
			String sourceFilePath=null;//�ļ���·��
			String sourceFileName=null;//�ʼ�����������
			String fileExt=null;//�ļ�����չ��
			String filePath=null;
			String realPath=null;
			long size=0;
			fileItem=(FileItem)fIterator.next();
			//����ʼ������ϴ��ʼ۶����Ǳ���Ϣ
			if(!fileItem.isFormField()){
				//�õ��ļ�������·��
				sourceFilePath=fileItem.getName();
				size=fileItem.getSize();
				if (!sourceFilePath.equals("") && size!=0) {
					//�õ�ȥ��·�����ļ���
					sourceFileName=sourceFilePath.substring(sourceFilePath.lastIndexOf("\\")+1);
					//�õ��ļ�����չ��
					fileExt=sourceFileName.substring(sourceFileName.lastIndexOf(".")+1);
					//�Ե�ǰϵͳʱ�䱣���ϴ��ļ�
					long systemTime=System.currentTimeMillis();
					//
					filePath=uploadPath+"/"+systemTime+"."+fileExt;
					//��ʵ·��
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
				//��������ϴ����ļ����Ǳ���Ϣ������Ϣ������paramters��
				String fileldName=fileItem.getFieldName();
				String value=fileItem.getString("UTF-8");
				parameters.put(fileldName, value);
			}
			
		}
		return 1;
	}
	//�����ļ��ķ���������Map���������ļ�����Ϣ�������ļ��ĵ�ַfilePath�����Ƶ�fileName
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
