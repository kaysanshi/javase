<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<b>文件上传的使用</b>
	<form action="${pageContext.request.contextPath}/fileupload" method="post" enctype="multipart/form-data">
		文件描述：<input type="text" name="desc" size="20" maxlength="80"><br/>
		文件名称：<input type="file" name="file" size="20" maxlength="80"><br/>
		<input type="submit" value="上传">
		
	</form>
</body>
</html>