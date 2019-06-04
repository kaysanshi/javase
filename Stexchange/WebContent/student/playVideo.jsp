<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>视频播放</title>
</head>
<body>
	<div align="center">
	<!--在html5中poster标签可以带预览的海报图片 但是如何能够同时上传文件和图片-->
	<video width="900" height="550" src="${requestScope.filepath}" controls="controls" poster="">
	</video>
	</div>
</body>
</html>