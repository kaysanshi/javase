<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div style="text-align:right">
  	<c:if test="${sessionScope.username == null}">
  		欢迎光临,游客
  		<a href="${pageContext.request.contextPath }/regist.jsp">注册</a>
  		<a href="${pageContext.request.contextPath }/login.jsp">登录</a>
  	</c:if>
  	<c:if test="${sessionScope.user != null}">
  		欢迎回来,${sessionScope.user.username }
  		<a href="${pageContext.request.contextPath }/LogoutServlet">注销</a>
  	
  	</c:if>
  	<a href="${pageContext.request.contextPath }/index.jsp">首页</a>
  	</div>
		<h3>视频上传</h3>
		<form action="${pageContext.request.contextPath }/UploadVideoServlet" method="post" enctype="multipart/form-data">
		选择文件：<input type="file" name="file1"><br/>
		文件标题：<input type="text" name="videotitle"><br/>
		文件类型：<input type="text" name="type"><br/>
		描述信息：<textarea rows="5" cols="30" name="discription"></textarea>
		<input type="submit"value="上传">
		</form>
		<c:if test="${sessionScope.user== null ||sessionScope.user==''}">
			 <script language='javascript'> alert('未登录登陆请先登录');window.location.href='videolearn.jsp';</script>;
		</c:if>
</body>
</html>