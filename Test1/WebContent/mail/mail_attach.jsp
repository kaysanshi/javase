<%@ page contentType="text/html;charset=GBK" %>
<%@ page import="javax.mail.*,java.util.*,javax.mail.internet.*,java.io.*,javax.activation.*"%>
<html>
<head><title>First Attatchment Email</title></head>
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
	msg.setSubject("���и������ʼ�"); 
    //����һ���ʼ���������
	BodyPart body=new MimeBodyPart(); 
	body.setText("���и������ʼ�");
	Multipart multpart=new MimeMultipart();
    //���뵽MimeMultipart��
	multpart.addBodyPart(body); 
    //��������
	BodyPart attachment=new MimeBodyPart();
    //�����ļ�������
	String filename="Java������ѵ.docx";
	//������·��
	String source=application.getRealPath("")+"\\"+filename;
    //��������Դָ�򸽼����ļ�
	DataSource ds=new FileDataSource(source);
	//��ø����ļ���ָ��
	attachment.setDataHandler(new DataHandler(ds));
	//���ø������ļ���
	attachment.setFileName(MimeUtility.encodeWord(filename));
    //���뵽MimeMultipart��
	multpart.addBodyPart(attachment);
    //��MimeMultipart���뵽Message��
	msg.setContent(multpart);
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