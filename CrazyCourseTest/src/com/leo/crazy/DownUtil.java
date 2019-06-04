package com.leo.crazy;

import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *����
 *download()�����������²�����ʵ�ֶ��߳����ء�
��1������URL����
��2����ȡָ��URL������ָ����Դ�Ĵ�С��ͨ��getContentLength()������ã����˴��õ���URLConnection�࣬�������JavaӦ�ó����URL֮���ͨ�����ӡ����滹�й���URLConnection����ϸ�Ľ��ܡ�
��3���ڱ��ش����ϴ���һ����������Դ������ͬ��С�Ŀ��ļ���
��4������ÿ���߳�Ӧ������������Դ���ĸ����֣����ĸ��ֽڿ�ʼ�����ĸ��ֽڽ�������
��5�����δ�������������߳�������������Դ��ָ�����֡�
 * @author leoi555
 *@date 2018��10��20��
 */
public class DownUtil {
	    // ����������Դ��·��
	    private String path;
	    // ָ�������ص��ļ��ı���λ��
	    private String targetFile;
	    // ������Ҫʹ�ö��ٸ��߳�������Դ
	    private int threadNum;
	    // �������ص��̶߳���
	    private DownThread[] threads;
	    // �������ص��ļ����ܴ�С
	    private int fileSize;
	    public DownUtil(String path, String targetFile, int threadNum)
	    {
	          this.path=path;
	          this.threadNum=threadNum;
	          // ��ʼ��threads����
	          threads=new DownThread[threadNum];
	          this.targetFile=targetFile;
	    }
	    public void download() throws Exception
	    {
	          URL url=new URL(path);
	          HttpURLConnection conn=(HttpURLConnection) url.openConnection();
	          conn.setConnectTimeout(5*1000);
	          conn.setRequestMethod("GET");
	          conn.setRequestProperty(
	                "Accept",
	                "image/gif, image/jpeg, image/pjpeg, image/pjpeg, "
	                + "application/x-shockwave-flash, application/xaml+xml, "
	                + "application/vnd.ms-xpsdocument, application/x-ms-xbap, "
	                + "application/x-ms-application, application/vnd.ms-excel, "
	                + "application/vnd.ms-powerpoint, application/msword, ��/��");
	          conn.setRequestProperty("Accept-Language", "zh-CN");
	          conn.setRequestProperty("Charset", "UTF-8");
	          conn.setRequestProperty("Connection", "Keep-Alive");
	          // �õ��ļ���С
	          fileSize=conn.getContentLength();
	          conn.disconnect();
	          int currentPartSize=fileSize / threadNum + 1;
	          RandomAccessFile file=new RandomAccessFile(targetFile, "rw");
	          // ���ñ����ļ��Ĵ�С
	          file.setLength(fileSize);
	          file.close();
	          for (int i=0; i < threadNum; i++)
	          {
	                // ����ÿ���߳����صĿ�ʼλ��
	                int startPos=i*currentPartSize;
	                // ÿ���߳�ʹ��һ��RandomAccessFile��������
	                RandomAccessFile currentPart=new RandomAccessFile(targetFile,
	                    "rw");
	                // ��λ���̵߳�����λ��
	                currentPart.seek(startPos);
	                // ���������߳�
	                threads[i]=new DownThread(startPos, currentPartSize,
	                    currentPart);
	                // ���������߳�
	                threads[i].start();
	          }
	    }
	    // ��ȡ���ص���ɰٷֱ�
	    public double getCompleteRate()
	    {
	          // ͳ�ƶ���߳��Ѿ����ص��ܴ�С
	          int sumSize=0;
	          for (int i=0; i < threadNum; i++)
	          {
	                sumSize +=threads[i].length;
	          }
	          // �����Ѿ���ɵİٷֱ�
	          return sumSize*1.0 / fileSize;
	    }
	    private class DownThread extends Thread
	    {
	          // ��ǰ�̵߳�����λ��
	          private int startPos;
	          // ���嵱ǰ�̸߳������ص��ļ���С
	          private int currentPartSize;
	          // ��ǰ�߳���Ҫ���ص��ļ���
	          private RandomAccessFile currentPart;
	          // ������߳������ص��ֽ���
	          public int length;
	          public DownThread(int startPos, int currentPartSize,
	                RandomAccessFile currentPart)
	          {
	                this.startPos=startPos;
	                this.currentPartSize=currentPartSize;
	                this.currentPart=currentPart;
	          }
	          public void run()
	          {
	                try
	                {
	                    URL url=new URL(path);
	                    HttpURLConnection conn=(HttpURLConnection)url
	                          .openConnection();
	                    conn.setConnectTimeout(5*1000);
	                    conn.setRequestMethod("GET");
	                    conn.setRequestProperty(
	                          "Accept",
	                          "image/gif, image/jpeg, image/pjpeg, image/pjpeg, "
	                          + "application/x-shockwave-flash, application/xaml+xml, "
	                          + "application/vnd.ms-xpsdocument, application/x-ms-xbap, "
	                          + "application/x-ms-application, application/vnd.ms-excel, "
	                          + "application/vnd.ms-powerpoint, application/msword, ��/��");
	                    conn.setRequestProperty("Accept-Language", "zh-CN");
	                    conn.setRequestProperty("Charset", "UTF-8");
	                    InputStream inStream=conn.getInputStream();
	                    // ����startPos���ֽڣ��������߳�ֻ�����Լ�������ǲ����ļ�
	                    inStream.skip(this.startPos);
	                    byte[] buffer=new byte[1024];
	                    int hasRead=0;
	                    // ��ȡ�������ݣ���д�뱾���ļ�
	                    while (length < currentPartSize
	                          && (hasRead=inStream.read(buffer)) !=-1)
	                    {
	                          currentPart.write(buffer, 0, hasRead);
	                          // �ۼƸ��߳����ص��ܴ�С
	                          length +=hasRead;
	                    }
	                    currentPart.close();
	                    inStream.close();
	                }
	                catch (Exception e)
	                {
	                    e.printStackTrace();
	                }
	          }
	    }
	
}