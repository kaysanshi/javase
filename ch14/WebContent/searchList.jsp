<%@ page pageEncoding="GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/header.jsp" %>
<center>
<h2>������ʾ</h2>
<c:set var="url" value="${pageContext.request.contextPath}/us/search" />
<form action="${url}" method="post">
��ѡ�����
<select name="type">
   <option value="" <c:if test="${empty param.type}">selected</c:if>>ȫ�����</option>
   <option value="1" <c:if test="${param.type==1}">selected</c:if>>ͼƬ</option>
   <option value="2" <c:if test="${param.type==2}">selected</c:if>>Flash</option>
   <option value="3" <c:if test="${param.type==3}">selected</c:if>>����</option>
   <option value="4" <c:if test="${param.type==4}">selected</c:if>>С��Ƶ</option>
   <option value="5" <c:if test="${param.type==5}">selected</c:if>>����</option>
</select>
������ؼ��֣�
<input type="text" name="name" value="${param.name}">
<input type="submit" value="�鿴">
</form>
<c:forEach var="file" items="${pageBean.data}">
  <table border width="70%">
  <tr>
  <td bgcolor="#CCCCCC" width="15%">�ļ�˵��</td>
  <td width="45%"><a href="${pageContext.request.contextPath}/dls?id=${file.id}">${file.name}</a></td>
  <td bgcolor="#CCCCCC" width="15%">�ļ���С</td>
  <td>${file.size}�ֽ�</td>
  </tr>
  <tr>
  <td bgcolor="#CCCCCC" width="15%">��������</td>
  <td width="45%">${file.lastModified}</td>
  <td bgcolor="#CCCCCC" width="15%">���ش���</td>
  <td>${file.hits}</td>
  </tr>
  <tr>
  <td bgcolor="#CCCCCC" width="15%">��ϸ����</td>
  <td colspan="3">${file.description}</td>
  </tr>
  </table>
  <p>
</c:forEach>
ÿҳ${pageBean.pageSize}��  ��${pageBean.totalRows}��  ҳ�� ${pageBean.curPage}/${pageBean.totalPages}
<c:url var="newUrl" value="/us/search">
   <c:param name="type">${param.type}</c:param>
   <c:param name="name">${param.name}</c:param>
</c:url>
<c:choose>
	  <c:when test="${pageBean.curPage==1}">��ҳ ��һҳ</c:when>
	  <c:otherwise>
	  	<a href="${newUrl}&page=1">��ҳ</a>
	  	<a href="${newUrl}&page=${pageBean.curPage-1}">��һҳ</a>
	  </c:otherwise>
   </c:choose>
   <c:choose>
	  <c:when test="${pageBean.curPage>=pageBean.totalPages}">��һҳ βҳ</c:when>
	  <c:otherwise>
	  	<a href="${newUrl}&page=${pageBean.curPage+1}">��һҳ</a>
	  	<a href="${newUrl}&page=${pageBean.totalPages}">βҳ</a>
	  </c:otherwise>
</c:choose>
</center>