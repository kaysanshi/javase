<%@ page contentType="text/html;charset=GBK" %>
<%@ page import="javax.mail.*,java.util.*,javax.mail.internet.*,java.io.*" %>	
<html>
<head><title>receive mail sample</title></head>
<body>
<% 
	Properties props = new Properties();
	//�����ʼ���������ַ
	props.put("mail.host", "219.216.128.8");
	//�����ʼ��Ự����
	Session ses = Session.getDefaultInstance(props, null);
	Store store=ses.getStore("pop3");
	store.connect("219.216.128.8","jinyan_t@neusoft.edu.cn","***");
	//�����ļ��ж���
	Folder folder=store.getFolder("INBOX");
	folder.open(Folder.READ_ONLY);
	//folder.open(Folder.READ_WRITE);
	Message[] messages=folder.getMessages();               
	for(int i=0;i<messages.length;i++){
        //��ȡ�ļ��������е��ʼ���Ϣ
		Message msg=messages[i];
		out.println("���⣺"+msg.getSubject()+"<br>");
		out.println("����ʱ�䣺"+msg.getSentDate()+"<br>");
		out.println("���ݣ�"+msg.getContent());
		out.println("<hr>");
		//��ʶ�ʼ�ɾ��
		//msg.setFlag(Flags.Flag.DELETED,true);
	}
	folder.close(false);
	//folder.close(true);
	store.close();
%>
</body>
</html>