<%@ page pageEncoding="GBK" import="javax.mail.*,java.util.*,javax.mail.internet.*,java.io.*" %>
<html>
<head><title>First Text Email</title></head>
<body>
<%
	Properties props = new Properties();
	//设置邮件服务器地址
	props.put("mail.host", "219.216.128.8");
	//创建邮件会话对象
	Session ses = Session.getDefaultInstance(props, null);
	//从Session创建MimeMessage
	MimeMessage msg = new MimeMessage(ses);
	//发送的邮箱地址
	InternetAddress from=new InternetAddress("jinyan_t@neusoft.edu.cn");
	//接受的邮箱地址
	InternetAddress to=new InternetAddress("zhangna@neusoft.edu.cn");
	//设置发送邮箱地址
	msg.setFrom(from);
	//添加邮箱接受者
	msg.addRecipient(Message.RecipientType.TO,to);
	//设置邮件主题
	msg.setSubject("first mail");
	msg.setText("这是第一封邮件","GBK");
	//获得传输类的实例
	Transport tran=ses.getTransport("smtp");
	//建立连接
	tran.connect("219.216.128.8","jinyan_t@neusoft.edu.cn","***");
	//发送邮件
	Transport.send(msg); 
	out.println("邮件发送成功");
%>
</body>
</html>