<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>上传</h1>
		<form action="${pageContext.request.contextPath }/UploaddisckServlet" method="post" enctype="multipart/form-data">
		选择文件：<input type="file" name="file1"><br/>
		描述信息：<textarea rows="5" cols="30" name="description"></textarea>
		<input type="submit"value="上传">
		
		</form>

</body>
</html>