<%@ page pageEncoding="GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/header.jsp" %>
<center>
<h2>娱乐无限下载中心</h2>
<c:set var="url" value="${pageContext.request.contextPath}/us/listAll"/>
<c:forEach var="file" items="${pageBean.data}">
  <table border width="70%">
  <tr>
  <td bgcolor="#CCCCCC" width="15%">文件说明</td>
  <td width="45%"><a href="${pageContext.request.contextPath}/dls?id=${file.id}">${file.name}</a></td>
  <td bgcolor="#CCCCCC" width="15%">文件大小</td>
  <td>${file.size}字节</td>
  </tr>
  <tr>
  <td bgcolor="#CCCCCC" width="15%">更新日期</td>
  <td width="45%">${file.lastModified}</td>
  <td bgcolor="#CCCCCC" width="15%">下载次数</td>
  <td>${file.hits}</td>
  </tr>
  <tr>
  <td bgcolor="#CCCCCC" width="15%">详细描述</td>
  <td colspan="3">${file.description}</td>
  </tr>
  </table>
  <p>
</c:forEach>
每页${pageBean.pageSize}行  共${pageBean.totalRows}行  页数 ${pageBean.curPage}/${pageBean.totalPages}
<c:choose>
	  <c:when test="${pageBean.curPage==1}">首页 上一页</c:when>
	  <c:otherwise>
	  	<a href="${url}?page=1">首页</a>
	  	<a href="${url}?page=${pageBean.curPage-1}">上一页</a>
	  </c:otherwise>
   </c:choose>
   <c:choose>
	  <c:when test="${pageBean.curPage>=pageBean.totalPages}">下一页 尾页</c:when>
	  <c:otherwise>
	  	<a href="${url}?page=${pageBean.curPage+1}">下一页</a>
	  	<a href="${url}?page=${pageBean.totalPages}">尾页</a>
	  </c:otherwise>
</c:choose>
</center>