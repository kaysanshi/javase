<%@ page pageEncoding="GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/header.jsp" %>
<center>
<h2>������ҳ�����ļ��б�</h2>
<a href="${pageContext.request.contextPath}/admin/add.jsp">�ļ����</a>
<br/>
<c:set var="url" value="${pageContext.request.contextPath}/as/list"/>
<c:forEach var="file" items="${pageBean.data}">
  <table border width="70%">
  <tr>
  <td bgcolor="#CCCCCC" width="15%">�ļ�˵��</td>
  <td width="45%">${file.name}</td>
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
  <tr>
  <td colspan="4" align="center">
  <a href="${url}/update?id=${file.id}">
   �޸�</a>
  &nbsp;&nbsp; &nbsp;&nbsp; 
  <a href="${url}/delete?id=${file.id}"
   onClick="return confirm('ȷ��Ҫɾ����')">
   �h��</a>
  </td>
  </tr>
  </table>
  <p>
</c:forEach>
ÿҳ${pageBean.pageSize}��  ��${pageBean.totalRows}��  ҳ�� ${pageBean.curPage}/${pageBean.totalPages}
<c:choose>
	  <c:when test="${pageBean.curPage==1}">��ҳ ��һҳ</c:when>
	  <c:otherwise>
	  	<a href="${url}?page=1">��ҳ</a>
	  	<a href="${url}?page=${pageBean.curPage-1}">��һҳ</a>
	  </c:otherwise>
   </c:choose>
   <c:choose>
	  <c:when test="${pageBean.curPage>=pageBean.totalPages}">��һҳ βҳ</c:when>
	  <c:otherwise>
	  	<a href="${url}?page=${pageBean.curPage+1}">��һҳ</a>
	  	<a href="${url}?page=${pageBean.totalPages}">βҳ</a>
	  </c:otherwise>
</c:choose>
</center>