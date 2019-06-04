<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath }/css/mystyle.css"  type="text/css" rel="stylesheet" />
<script type="text/javaScript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.min.js"></script>
<title>消息列表</title>
<script>
//搜索
$("#MessageSearchBtn").bind("click",function(){  
	   $.ajax({
			 type: 'post',
			 url: 'MessageSeachServlet' ,
			 data: $('#MessageSearchForm').serialize(),
			 success: function(data) {
				  $("#content").html(data);
			 }
		});
});


///回复方法
function sendAjaxReply(url,method){
	alert(12122);
	$.ajax({
		type:method,
		url:url,
		success:function(data){
			$("#content").html(data);
		},
		error:function(data){
			alert("回复失败");
		}		
	});
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
<!-- 搜索 区域-->
<form id="MessageSearchForm" method="post" action="">
	   <table align="center" width="100%" border="0" cellpadding="0" 
                             cellspacing="0" class="biao">	
           <tr>
			 <td class="neirong">
			  消息名：<input type="text" name="messagename" value="${title}" style="width:30%">
			   
			   <input type="hidden" name="curpage" value="">
			   
			   <a href="javascript:void(0);" id="MessageSearchBtn" class="btn-green">搜&nbsp;索</a>
			   
			 </td>                   
           </tr>                  
	   </table>
	   </form>
 <table align="center" width="100%" border="0" cellpadding="0" 
                             cellspacing="0" class="biao">	
	              <tr>
					<td class="biaotou">标题</td>
					<td class="biaotou">内容</td>
					<td class="biaotou">回复内容</td>
					<td class="biaotou">回复时间</td>
	                <td class="biaotou">操作</td>
	              </tr>
	              <c:forEach var="r" items="${pageBean.data }">
				  <tr>
					<td class="neirong" style="width:40%">${r.title}</td>
					<td class="neirong">${r.content}</td>
					<td class="neirong">${r.reply}</td>
					<td class="neirong">${r.replydate}</td>
					<td class="neirong">
					<a href="javascript:sendAjaxReply('ReplyServlet?msid=${r.id}','post');">回复</a>
					</td>
	              </tr>
				 </c:forEach>
		</table>
		<div align="center" style="font-size:14px">
		<c:set var="url" value="${pageContext.request.contextPath}/student/MyMessageListServlet"/>
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