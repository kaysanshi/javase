<%@ page pageEncoding="GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/header.jsp" %>
<center>
<h2>�������а�</h2>
<table border width="50%">
<tr><th width="15%" bgcolor="#CCCCCC">����</th>
<th width="65%" bgcolor="#CCCCCC">�ļ�˵��</th>
<th width="20%" bgcolor="#CCCCCC">���ش���</th>
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