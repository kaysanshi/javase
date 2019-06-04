<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>


<link href="<c:url value='/admin/css/style.css'/> " rel="stylesheet"
	type="text/css" />

<script type="text/javascript"
	src="<c:url value='/admin/js/jquery.js'/>"></script>

<script type="text/javascript" src="<c:url value='/admin/js/jquery.idTabs.min.js' />"></script>

</head>

<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a>
			</li>
			<li><a href="#">商品信息管理</a>
			</li>
		</ul>
	</div>

	<div class="formbody">

		<div class="formtitle">
			<span>商品基本信息</span>
		</div>

		<ul class="forminfo">
			<li><label>商品名称</label> <label>${item.name }</label>
			</li>
			<li><label>商品分类<b>*</b>
			</label>
				<div class="vocation">
					${item.cname}
				</div></li>
			<li><label>商品封面</label> <img src="<c:url value='${item.photo } '/>" /></li>
			<li><label>商品价格</label> <label>￥${item.price }</label>
			</li>
			<li><label>商品市场价格</label> <label>￥${item.markprice }</label>
			</li>
			<li><label>商品数量</label> <label>${item.quality }</label>
			</li>
			<li><label>浏览量</label> <label>${item.hit }</label>
			</li>
			<li><label>上架时间</label> <label>${item.time }</label>
			</li>
			<li><label>商品描述内容</label> <label>${item.content }</label></li>
			<form action = "<c:url value='/adminProductServlet'/>" method="post">
			<input type="hidden" name="action" value="updatebefore"/>
			<input type="hidden" name="id" value="${item.productid }"/>
			<li><label></label> <label><input type="submit" value="修改" class="btn"/></label>
			</li>
			
			</form>
		</ul>
	</div>
</body>
</html>
