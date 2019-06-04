<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

		<title>首页</title>

		<link href="<c:url value='/AmazeUI-2.4.2/assets/css/amazeui.css'/>" rel="stylesheet" type="text/css" />
		<link href="<c:url value='/AmazeUI-2.4.2/assets/css/admin.css'/>" rel="stylesheet" type="text/css" />

		<link href="<c:url value='/basic/css/demo.css'/>" rel="stylesheet" type="text/css" />

		<link href="<c:url value='/css/hmstyle.css'/>" rel="stylesheet" type="text/css" />
		<script src="<c:url value='/AmazeUI-2.4.2/assets/js/jquery.min.js'/>"></script>
		<script src="<c:url value='/AmazeUI-2.4.2/assets/js/amazeui.min.js'/>"></script>

	</head>

	<body>
		<div class="hmtop">
			
			<%@include file="/header.jsp"%>
			

				
			</div>
			<!--顶部导航条结束 -->
			
			<div class="shopMainbg">
			

					<!--甜点-->
					
					<div class="am-container ">
						<div class="shopTitle ">
							<h4>甜品</h4>
							<h3>每一道甜品都有一个故事</h3>
							
							<span class="more ">
                    <a class="more-link " href="<c:url value='/productServlet?action=findAll'/>">更多美味</a>
                        </span>
						</div>
					</div>
					     
					
					<div class="am-g am-g-fixed flood method3 ">
						<ul class="am-thumbnails ">
							<c:forEach var="item" items="${list}">						
							<li>
								<div class="list ">
									<a href="<c:url value='/productServlet?action=findById&id=${item.productid }'/>">
										<img src="<c:url value='/${item.photo }'/> " />
										<div class="pro-title ">${item.name }</div>
										<span class="e-price ">￥${item.price }</span>
									</a>
								</div>
							</li>
							</c:forEach>		
							
						
						</ul>
						
					</div>
					
					<%@include file="/footer.jsp" %>
			
			</div>
		</div>
		
		<!--引导 -->

		
		<script>
			window.jQuery || document.write('<script src="basic/js/jquery.min.js "><\/script>');
		</script>
		<script type="text/javascript " src="<c:url value='/basic/js/quick_links.js'/> "></script>
	</body>

</html>