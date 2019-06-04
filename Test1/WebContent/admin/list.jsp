<%@ page pageEncoding="GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/header.jsp" %>
<center>
<h2>管理首页——文件列表</h2>
<a href="${pageContext.request.contextPath}/admin/add.jsp">文件添加</a>
<br/>
<c:set var="url" value="${pageContext.request.contextPath}/as/list"/>
<c:forEach var="file" items="${pageBean.data}">
  <table border width="70%">
  <tr>
  <td bgcolor="#CCCCCC" width="15%">文件说明</td>
  <td width="45%">${file.name}</td>
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
  <tr>
  <td colspan="4" align="center">
  <a href="${url}/update?id=${file.id}">
   修改</a>
  &nbsp;&nbsp; &nbsp;&nbsp; 
  <a href="${url}/delete?id=${file.id}"
   onClick="return confirm('确定要删除吗？')">
   刪除</a>
  </td>
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