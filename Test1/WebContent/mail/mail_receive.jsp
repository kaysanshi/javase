<%@ page contentType="text/html;charset=GBK" %>
<%@ page import="javax.mail.*,java.util.*,javax.mail.internet.*,java.io.*" %>	
<html>
<head><title>receive mail sample</title></head>
<body>
<% 
	Properties props = new Properties();
	//设置邮件服务器地址
	props.put("mail.host", "219.216.128.8");
	//创建邮件会话对象
	Session ses = Session.getDefaultInstance(props, null);
	Store store=ses.getStore("pop3");
	store.connect("219.216.128.8","jinyan_t@neusoft.edu.cn","***");
	//创建文件夹对象
	Folder folder=store.getFolder("INBOX");
	folder.open(Folder.READ_ONLY);
	//folder.open(Folder.READ_WRITE);
	Message[] messages=folder.getMessages();               
	for(int i=0;i<messages.length;i++){
        //读取文件夹中所有的邮件信息
		Message msg=messages[i];
		out.println("主题："+msg.getSubject()+"<br>");
		out.println("发送时间："+msg.getSentDate()+"<br>");
		out.println("内容："+msg.getContent());
		out.println("<hr>");
		//标识邮件删除
		//msg.setFlag(Flags.Flag.DELETED,true);
	}
	folder.close(false);
	//folder.close(true);
	store.close();
%>
</body>
</html>