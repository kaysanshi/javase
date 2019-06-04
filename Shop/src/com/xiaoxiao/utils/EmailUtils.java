package com.xiaoxiao.utils;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Properties;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class EmailUtils {
	
	//发送验证邮件
	public boolean sendVerifyMail(String toemail,String code){
//		String name = "xinshang_gj";
//		String pwd = "xiaoxiao123456";
//		String host = "smtp.163.com";
//		String to = toemail;
//		String from = "xinshang_gj@163.com";
//		String subject = "注册成功！";
//		String encode = "GB2312";
//		String content = "恭喜你，注册成功！<a href='http://localhost:8080/shop/userServlet?action=activate&code={0}'>请单击这里激活账号</a>如果不能打开链接，请复制链接到浏览器地址栏打开。";

		InputStream in = EmailUtils.class.getClassLoader().getResourceAsStream("email.properties");
		Properties prop = new Properties();
		try {
			prop.load(in);
			String name = prop.getProperty("name");
			String password = prop.getProperty("password");
			String host = prop.getProperty("host");
			String to = toemail;
			String from = prop.getProperty("from");
			String subject = prop.getProperty("subject");
			String encode = prop.getProperty("encode");
			String content = prop.getProperty("content");
			content = MessageFormat.format(content,code);
			EmailUtils emailUtils = new EmailUtils();
			return emailUtils.sendMail(name, password, host, to, from, subject, content, encode);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	//发送邮件的方法
	public boolean sendMail(String name,String password,String host,String to,String From,String subject,String content,String encode){
		try {
			HtmlEmail email = new  HtmlEmail();
			//设置发邮件的用户名和密码（授权密码）
			email.setAuthentication(name, password);
			//设置发送邮件服务器(SMTP服务器)域名
			email.setHostName(host);
			//收件人的邮箱
			email.addTo(to);
			//发件人的邮箱
			email.setFrom(From);
			//邮件的主题
			email.setSubject(subject);
			//设置编码方式，为了防止中文乱码
			email.setCharset(encode);
			//邮件的内容
			email.setHtmlMsg(content);
			
			//发送邮件
			email.send();
			return true;
		} catch (EmailException e) {
			e.printStackTrace();
			return false;
		}
		
	}
}
