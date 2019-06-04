<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>left</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>

<script type="text/javascript">
$(function(){	
	//导航切换
	$(".menuson li").click(function(){
		$(".menuson li.active").removeClass("active");
		$(this).addClass("active");
	});
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('ul').slideUp();
		if($ul.is(':visible')){
			$(this).next('ul').slideUp();
		}else{
			$(this).next('ul').slideDown();
		}
	});
});	
</script>
</head>
<body style="background:#f0f9fd;">

	<div class="lefttop"><span></span><a href="index.html" target="rightFrame">管理菜单</a></div>
    <dl class="leftmenu">
        
    <dd>
    <div class="title">
    <span><img src="images/leftico01.png" /></span>商品信息管理
    </div>
    	<ul class="menuson">
        <li><cite></cite><a href="<c:url value='/adminProductServlet?action=addbefore'/>" target="rightFrame">发布商品</a><i></i></li>
        <li class="active"><cite></cite><a href="<c:url value='/adminProductServlet?action=findAll'/>" target="rightFrame">商品列表</a><i></i></li>
        </ul>    
    </dd>
    <dd>
    <div class="title">
    <span><img src="images/leftico02.png" /></span>商品分类管理
    </div>
    <ul class="menuson">
        <li><cite></cite><a href="addCategory.jsp" target="rightFrame">添加分类</a><i></i></li>
        <li><cite></cite><a href="<c:url value='/adminCategoryServlet?action=findAll'/> " target="rightFrame">分类列表</a><i></i></li>
        </ul>     
    </dd> 
    
    
    <dd><div class="title"><span><img src="images/leftico03.png" /></span>订单管理</div>
    <ul class="menuson">
        <li><cite></cite><a href="<c:url value='/adminOrderServlet?action=findAll'/>" target="rightFrame">订单列表</a><i></i></li>
    </ul>    
    </dd>  
    
    
    <dd><div class="title"><span><img src="images/leftico04.png" /></span>其它设置</div>
    <ul class="menuson">
        <li><cite></cite><a href="login.html" target="_parent">退出</a><i></i></li>
    </ul>
    </dd>
        
    </dl>
</body>
</html>
