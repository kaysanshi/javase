<%@ page contentType="text/html;charset=GBK" %>
<%@ page import="javax.mail.*,java.util.*,javax.mail.internet.*,java.io.*,javax.activation.*"%>
<html>
<head><title>First Attatchment Email</title></head>
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
	msg.setSubject("带有附件的邮件"); 
    //创建一个邮件主体内容
	BodyPart body=new MimeBodyPart(); 
	body.setText("带有附件的邮件");
	Multipart multpart=new MimeMultipart();
    //加入到MimeMultipart中
	multpart.addBodyPart(body); 
    //创建附件
	BodyPart attachment=new MimeBodyPart();
    //附件文件的名字
	String filename="Java技术培训.docx";
	//附件的路径
	String source=application.getRealPath("")+"\\"+filename;
    //创建数据源指向附件的文件
	DataSource ds=new FileDataSource(source);
	//获得附件文件的指针
	attachment.setDataHandler(new DataHandler(ds));
	//设置附件的文件名
	attachment.setFileName(MimeUtility.encodeWord(filename));
    //加入到MimeMultipart中
	multpart.addBodyPart(attachment);
    //将MimeMultipart加入到Message中
	msg.setContent(multpart);
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