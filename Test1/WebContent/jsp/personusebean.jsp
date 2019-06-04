<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>使用动作元素的方式</title>
</head>
<body>
		<jsp:useBean id="Person" class="beans.Person" scope="page"></jsp:useBean>
		<jsp:setProperty property="*"  name="Person"/>
		原始姓名：<br>
		姓名：<jsp:getProperty property="name" name="Person"/><br>
		更改参数：<br>
		<jsp:setProperty property="name" name="Person" value="海哥"/>
		根据传入的参数获取属性的值为：<br>
		姓名：<jsp:getProperty property="name" name="Person"/>
		年龄：<jsp:getProperty property="age" name="Person"/><br>
		职业：<jsp:getProperty property="career" name="Person"/>
</body>
</html>