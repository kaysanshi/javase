<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>备忘录-备忘列表-与我相关</title>
<link href="/memo/css/bootstrap.min.css" rel="stylesheet">
<link href="/memo/css/common.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-default" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <a href="/memo/home.jsp" class="navbar-brand">备忘录</a>
        </div>
        <div id="navbar" class="">
            <!-- 要想使用navbar-tabs必须有nav这个基类 -->
            <ul class="nav navbar-nav">   
                <li><a href="/memo/add.jsp">新建</a></li>
                <li class="active"><a href="/memo/rd_list">列表</a></li>
            </ul>
        </div>
        <div class="navbar-right nav-right dropdown">
            <img class="img-circle header-img" src="/memo/images/header.jpg" width="48" height="48"/>
            <a href="#" data-toggle="dropdown" aria-expanded="false">
                <span>${user.nick }</span>
                <span class="caret"></span>
            </a>
            <ul class="dropdown-menu" role="menu">

                <li><a href="/memo/pwd.jsp">修改密码</a></li>

                <li><a href="/memo/user_exit">退出</a></li>
            </ul>
        </div>
    </div>
</nav>
<nav class="content" width="1200px">
    <div class="bclear"></div>
    <!--资料列表-->
    <div class="table-content">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>序号</th>
                <th>标题</th>
                <th>计划日期</th>
                <th>添加时间</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:if test="${not empty list }">
		        <c:forEach items="${list }" var="entry" varStatus="num">
		        	<tr>
		        		<td>${num.count }</td>
		        		<td>${entry.title }</td>
		        		<td>${entry.time }</td>
		        		<td>${entry.addtime }</td>
		        		<td><a href="/memo/rd_edit?id=${entry.id }">编辑</a> <a href="/memo/rd_info?id=${entry.id }">查看</a> <a url="${entry.id }" class="delbtn" style="cursor: pointer;">删除</a></td>
		        	</tr>
		        </c:forEach>
	        </c:if>
            </tbody>
        </table>
    </div>


    <!--分页-->
    <nav id="page" class="start">
            <ul class="pagination">
	        	<c:if test="${page != 1 }">
	        		<!-- 首页 -->
	        		<li><a href="/memo/rd_list">&laquo;</a></li>
	        	</c:if>
	            
	            <!-- 分析起始值和结束值 -->
	            <c:set var="showNum" value="10"/>
	            <c:choose>
	            	<c:when test="${tp <= showNum }">
	            		<c:set var="bg" value="1"/>
	            		<c:set var="ed" value="${tp }"/>
	            	</c:when>
	            	<c:otherwise>
	            		<c:set var="bg" value="${page - showNum / 2 }"/>
	            		<c:set var="ed" value="${page + showNum / 2 -1 }"/>
	            		<c:if test="${bg < 1 }">
	            			<c:set var="bg" value="1"/>
	            			<c:set var="ed" value="10"/>
	            		</c:if>
	            		<c:if test="${ed > tp }">
	            			<c:set var="bg" value="${tp - showNum - 1 }"/>
	            			<c:set var="ed" value="${tp }"/>
	            		</c:if>
	            	</c:otherwise>
	            </c:choose>
	            
	            <!-- 循环 -->
	            <c:forEach var="v" begin="${bg }" end="${ed }">
	            	<c:choose>
	            		<c:when test="${page == v }">
	            			<li class="active"><a href="#">${v }</a></li>
	            		</c:when>
	            		<c:otherwise>
	            			<li><a href="/memo/rd_list?p=${v - 1 }">${v }</a></li>
	            		</c:otherwise>
	            	</c:choose>
	            </c:forEach>
	            
	            <!-- 尾页 -->
	            <c:if test="${page != tp }">
	            	<li><a href="/memo/rd_list?p=${tp - 1 }">&raquo;</a></li>
	            </c:if>
            </ul>
        </nav>
</nav>
</body>
<script src="/memo/js/jquery-1.11.0.min.js"></script>
<script src="/memo/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('.delbtn').click(function() {
			var check = confirm("确定删除此条记录？");
			if (check == true) {
				$.ajax({
					url:"/memo/rd_del",
					type:"POST",
					data:{id:$(this).attr('url')},
					dataType:"json",
					success:function (data) {
						alert(data['msg']);
						location.reload();
					},
					error:function () {
						alert("操作提交失败");
					}
				});
			}
		});
	});
</script>
</html>