<%@ page pageEncoding="GBK" import="javax.mail.*,java.util.*,javax.mail.internet.*,java.io.*" %>
<html>
<head><title>First Text Email</title></head>
<body>
<%
	Properties props = new Properties();
	//�����ʼ���������ַ
	props.put("mail.host", "219.216.128.8");
	//�����ʼ��Ự����
	Session ses = Session.getDefaultInstance(props, null);
	//��Session����MimeMessage
	MimeMessage msg = new MimeMessage(ses);
	//���͵������ַ
	InternetAddress from=new InternetAddress("jinyan_t@neusoft.edu.cn");
	//���ܵ������ַ
	InternetAddress to=new InternetAddress("zhangna@neusoft.edu.cn");
	//���÷��������ַ
	msg.setFrom(from);
	//������������
	msg.addRecipient(Message.RecipientType.TO,to);
	//�����ʼ�����
	msg.setSubject("first mail");
	msg.setText("���ǵ�һ���ʼ�","GBK");
	//��ô������ʵ��
	Transport tran=ses.getTransport("smtp");
	//��������
	tran.connect("219.216.128.8","jinyan_t@neusoft.edu.cn","***");
	//�����ʼ�
	Transport.send(msg); 
	out.println("�ʼ����ͳɹ�");
%>
</body>
</html>