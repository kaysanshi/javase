package com.leo.crazy.test;

import com.leo.crazy.DownUtil;
/**
 *1）通过调用URL对象的openConnection()方法来创建URLConnection对象。
（2）设置URLConnection的参数和普通请求属性。
（3）如果只是发送GET方式请求，则使用connect()方法建立和远程资源之间的实际连接即可；如果需要发送POST方式的请求，则需要获取URLConnection实例对应的输出流来发送请求参数。
（4）远程资源变为可用，程序可以访问远程资源的头字段或通过输入流读取远程资源的数据。
 * @author leoi555
 *@date 2018年10月20日
 */
public class DownUtil_test {
	public static void main(String[] args) throws Exception
    {
	  // 初始化DownUtil对象
	  final DownUtil downUtil=new DownUtil("http://www.crazyit.org/"
		+ "attachment.php?aid=MTY0NXxjNjBiYzNjN3wxMzE1NTQ2MjU5fGNhO"
		+ "DlKVmpXVmhpNGlkWmVzR2JZbnluZWpqSllOd3JzckdodXJOMUpOWWt0aTJz,"
		, "oracelsql.rar", 4);
	  // 开始下载
	  downUtil.download();          
	  new Thread(){
		public void run()
		{
		    while(downUtil.getCompleteRate() < 1)
		    {
			  // 每隔0.1秒查询一次任务的完成进度
			  // GUI程序中可根据该进度来绘制进度条
			  System.out.println("已完成："
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
