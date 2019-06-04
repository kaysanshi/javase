<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
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
	<h1>下载列表</h1><hr>
	
	<c:forEach items="${requestScope.list}" var="r">
		<h2>${r.realname }<br></h2>
		上传时间:${r.uploadtime }<br>
		上传者ip:${r.ip }<br>
		描述信息:${r.discription }<br>
		
		<a href="${pageContext.request.contextPath }/DowntServlet?id=${r.id }">下载</a>
		<a href="${pageContext.request.contextPath }/PlayServlet?id=${r.id }">播放</a>
		<a href="${pageContext.request.contextPath }/DelVideoServlet?id=${r.id }">删除</a>
		<hr>	
	</c:forEach>
  </body>
</html>
