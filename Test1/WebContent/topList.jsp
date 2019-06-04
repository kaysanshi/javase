<%@ page pageEncoding="GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/header.jsp" %>
<center>
<h2>下载排行榜</h2>
<table border width="50%">
<tr><th width="15%" bgcolor="#CCCCCC">排名</th>
<th width="65%" bgcolor="#CCCCCC">文件说明</th>
<th width="20%" bgcolor="#CCCCCC">下载次数</th>
</tr>
<c:forEach var="file" items="${top}" varStatus="vs">
<tr>
<td align="center" bgcolor="#CCCCCC">${vs.count}</td>
<td align="center"><a href="${pageContext.request.contextPath}/showFile?id=${file.id}">${file.name}</a></td>
<td align="center">${file.hits}</td>
</tr>
</c:forEach>
</table>
</center>