package com.leo.crazy.test;

import com.leo.crazy.DownUtil;
/**
 *1��ͨ������URL�����openConnection()����������URLConnection����
��2������URLConnection�Ĳ�������ͨ�������ԡ�
��3�����ֻ�Ƿ���GET��ʽ������ʹ��connect()����������Զ����Դ֮���ʵ�����Ӽ��ɣ������Ҫ����POST��ʽ����������Ҫ��ȡURLConnectionʵ����Ӧ����������������������
��4��Զ����Դ��Ϊ���ã�������Է���Զ����Դ��ͷ�ֶλ�ͨ����������ȡԶ����Դ�����ݡ�
 * @author leoi555
 *@date 2018��10��20��
 */
public class DownUtil_test {
	public static void main(String[] args) throws Exception
    {
	  // ��ʼ��DownUtil����
	  final DownUtil downUtil=new DownUtil("http://www.crazyit.org/"
		+ "attachment.php?aid=MTY0NXxjNjBiYzNjN3wxMzE1NTQ2MjU5fGNhO"
		+ "DlKVmpXVmhpNGlkWmVzR2JZbnluZWpqSllOd3JzckdodXJOMUpOWWt0aTJz,"
		, "oracelsql.rar", 4);
	  // ��ʼ����
	  downUtil.download();          
	  new Thread(){
		public void run()
		{
		    while(downUtil.getCompleteRate() < 1)
		    {
			  // ÿ��0.1���ѯһ���������ɽ���
			  // GUI�����пɸ��ݸý��������ƽ�����
			  System.out.println("����ɣ�"
				+ downUtil.getCompleteRate());
			  try
			  {
				Thread.sleep(1000);
			  }
			  catch (Exception ex){}
		    }
		}
	  }.start();
    }
}
