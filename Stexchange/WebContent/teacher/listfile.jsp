<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath }/css/mystyle.css"  type="text/css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.min.js" ></script>
<title>文件列表</title>
<script>
////搜索
$("#filesSearchBtn").bind("click",function(){  
	   $.ajax({
			 type: 'post',
			 url: 'FileSeachServlet' ,
			 data: $('#filesSearchForm').serialize(),
			 success: function(data) {
				  //将“添加新闻”页面的内容插入到页面的“主区域”
				  $("#content").html(data);
			 }
		});
});

//编辑
function sendAjaxNoParam(url,method){
	$.ajax({
			 type: method,
			 url: url ,
			 success: function(data) {
				  $("#content").html(data);
			 }
	});
}
//删除方法
function ajaxDel(url,method){	
	alert(11111);
	if(confirm('你确认要删除吗？')){
		
		$.ajax({
			 type: method,
			 url: url ,
			 success: function(data) {
				  var msg="删除失败";
				  //data代表服务端返回的数据
				  if($.trim(data)=="1"){//删除成功
					 msg='删除成功';
				  }
				  alert(msg);
				  
			 }
	    });
	}
}
//ajax分页
function getpage(url,method){
	alert("1233");
	$.ajax({
		type:method,
		url:url,
		success:function(data){
			$("#content").html(data);
		}
		
	})
}
</script>
</head>
<body>
	 
	   <!-- 搜素区域 --> 
	   <form id="filesSearchForm" method="post" action="">
	   <table align="center" width="100%" border="0" cellpadding="0" 
                             cellspacing="0" class="biao">	
           <tr>
			 <td class="neirong">
			   文件名：<input type="text" name="filename" value="${filetitle}" style="width:30%">
			   
			   <input type="hidden" name="curpage" value="">
			   
			   <a href="javascript:void(0);" id="filesSearchBtn" class="btn-green">搜&nbsp;索</a>
			   
			 </td>                   
           </tr>                  
	   </table>
	   </form>
	   
       <table align="center" width="100%" border="0" cellpadding="0" 
                             cellspacing="0" class="biao">	
	              <tr>
					<td class="biaotou">文件名</td>
					<td class="biaotou">上传者ip</td>
					<td class="biaotou">发布时间</td>
					<td class="biaotou">描述</td>
	                <td class="biaotou">操作</td>
	              </tr>
	              <c:forEach var="r" items="${pageBean.data }">
				  <tr>
					<td class="neirong" style="width:40%">${r.filetitle}</td>
					<td class="neirong">${r.uplaodip}</td>
					<td class="neirong">${r.uploadtime}</td>
					<td class="neirong">${r.description}</td>
					<td class="neirong">
					   <a href="javascript:sendAjaxNoParam('EditfilesServlet?filesid=${r.id}','post')">编辑</a>
					   <a href="javascript:ajaxDel('DeletefilesServlet?filesid=${r.id}','post')">删除</a>
					</td>
	              </tr>
				 </c:forEach>
		</table>
	<div align="center" style="font-size:14px">
		<c:set var="url" value="${pageContext.request.contextPath}/teacher/ListFilesServlet"/>
			每页${pageBean.pageSize}行  共${pageBean.totalRows}行  页数 ${pageBean.curPage}/${pageBean.totalPages}
			<c:choose>
				  <c:when test="${pageBean.curPage==1}">首页 上一页</c:when>
				  <c:otherwise>
				  	<a href="javascript:getpage('${url}?page=1','post')">首页</a>
				  	<a href="javascript:getpage('${url}?page=${pageBean.curPage-1}','post')">上一页</a>
				  </c:otherwise>
			   </c:choose>
			   <c:choose>
				  <c:when test="${pageBean.curPage>=pageBean.totalPages}">下一页 尾页</c:when>
				  <c:otherwise>
				  	<a href="javascript:getpage('${url}?page=${pageBean.curPage+1}','post')">下一页</a>
				  	<a href="javascript:getpage('${url}?page=${pageBean.totalPages}','post')">尾页</a>
				  </c:otherwise>
			</c:choose>
		</div>
</body>
</html>