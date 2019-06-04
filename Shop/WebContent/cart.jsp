<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

	<title>购物车页面</title>
	<link href="<c:url value='/AmazeUI-2.4.2/assets/css/amazeui.css'/>"
		rel="stylesheet" type="text/css" />
	<link type="text/css" href="<c:url value='/css/optstyle.css‘'/>"
		rel="stylesheet" />
	<link href="<c:url value='/basic/css/demo.css'/>" rel="stylesheet"
		type="text/css" />
	<link type="text/css" href="<c:url value='/css/cartstyle.css'/>"
		rel="stylesheet" />

	<script type="text/javascript" src="<c:url value='/js/jquery.js' />"></script>
	<script>
		$(function() {
			$("#all").click(function() {
				if (this.checked) {
					$(":checkbox").attr("checked", true);
				} else {
					$(":checkbox").attr("checked", false);
				}
			});
			$(".increment").click(function() {
				//取得数量input的dom对象
				var qinput = $(this).siblings(":text");
				//将数量值加1
				qinput.val(eval(qinput.val()) + 1);
				var bc = qinput.val();
				//获取productid，该id以自定义text控件的属性
				var pid = qinput.attr("productid");
				var span = $("#total" + pid);
				$.post("${pageContext.request.contextPath}/cartServlet", {
					id : pid,
					buycount : bc,
					action : "updatecount"
				}, function(data, status) {
					var spantp = $("#totalprice");
					spantp.text(data.totalprice);
					span.text(data.total);
				}, "json");
			});
			$(".decrement").click(function() {
				//取得数量input的dom对象
				var qinput = $(this).siblings(":text");
				//将数量值加1
				if (eval(qinput.val()) == 1) {
					return;
				}
				qinput.val(eval(qinput.val()) - 1);
				var bc = qinput.val();
				//获取productid，该id以自定义text控件的属性
				var pid = qinput.attr("productid");
				var span = $("#total" + pid);
				$.post("${pageContext.request.contextPath}/cartServlet", {
					id : pid,
					buycount : bc,
					action : "updatecount"
				}, function(data, status) {
					var spantp = $("#totalprice");
					spantp.text(data.totalprice);
					span.text(data.total);
				}, "json");
			});
			
			
		});
		//提交按钮
		function paysubmit(){
			//重定向到CartServlet，action=paybefore
			window.location.href="<c:url value='/addressServlet?action=paybefore'/>";
		}
	</script>
</head>

<body>
<!--顶部导航条 -->
	<div class="am-container header">
				<ul class="message-l">
					<div class="topMessage">
						<div class="menu-hd">
							<a href="<c:url value='/home/login.jsp'/>" target="_top" class="h">亲，请登录</a>
							<a href="<c:url value='/home/regist.jsp'/>" target="_top">免费注册</a>
						</div>
					</div>
				</ul>
				<ul class="message-r">
					<div class="topMessage home">
						<div class="menu-hd"><a href="<c:url value='/index.jsp'/>" target="_top" class="h">商城首页</a></div>
					</div>
					<div class="topMessage my-shangcheng">
						<div class="menu-hd MyShangcheng"><a href="#" target="_top"><i class="am-icon-user am-icon-fw"></i>个人中心</a></div>
					</div>
					<div class="topMessage mini-cart">
						<div class="menu-hd"><a id="mc-menu-hd"  href="<c:url value='/home/cart.jsp'/>" target="_top"><i class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong id="J_MiniCartNum" class="h">0</strong></a></div>
					</div>
					<div class="topMessage favorite">
						<div class="menu-hd"><a href="#" target="_top"><i class="am-icon-heart am-icon-fw"></i><span>收藏夹</span></a></div>
				</ul>
				</div>

			<!--悬浮搜索框-->

			<div class="nav white">
				<div class="logo"><img src="../images/logo.png" /></div>
					<div class="logoBig">
					<li><img src="<c:url value='/images/logobig.png'/>" /></li>
				</div>

				<div class="search-bar pr">
					<a name="index_none_header_sysc" href="#"></a>
					<form action="<c:url value='/productServlet'/>" method="post">
					<input type="hidden" name="action" value="findAll"/>
						<input id="searchInput" name="svalue" type="text" placeholder="搜索" autocomplete="off">
						<input id="ai-topsearch" class="submit am-btn"  value="搜索" index="1" type="submit">
					</form>
				</div>
			</div>


	<div class="clear"></div>

	<!--购物车 -->
	<div class="concent">
		<div id="cartTable">
			<div class="cart-table-th">
				<div class="wp">
					<div class="th th-chk">
						<div id="J_SelectAll1" class="select-all J_SelectAll"></div>
					</div>
					<div class="th th-item">
						<div class="td-inner">商品信息</div>
					</div>
					<div class="th th-price">
						<div class="td-inner">单价</div>
					</div>
					<div class="th th-amount">
						<div class="td-inner">数量</div>
					</div>
					<div class="th th-sum">
						<div class="td-inner">金额</div>
					</div>

					<div class="th th-op">
						<div class="td-inner">操作</div>
					</div>
				</div>
			</div>
			<div class="clear"></div>

			<form action="<c:url value='/cartServlet'/>" method="post" id="form1">
				<input type="hidden" name="action" value="deletemore" />
				<c:forEach var="item" items="${cart}">

					<tr class="item-list">
						<div class="bundle  bundle-last ">

							<div class="bundle-main">
								<ul class="item-content clearfix">
									<li class="td td-chk">
										<div class="cart-checkbox ">
											<input class="check" name="sel" value="${item.productid }"
												type="checkbox" /> <label for=""></label>
										</div></li>
									<li class="td td-item">
										<div class="item-pic">
											<a href="#" target="_blank" data-title="${item.name }"
												class="J_MakePoint" data-point="tbcart.8.12"> <img
												src="<c:url value='/${item.photo }'/>"
												class="itempic J_ItemImg" /> </a>
										</div>
										<div class="item-info">
											<div class="item-basic-info">
												<a href="#" target="_blank" title=""
													class="item-title J_MakePoint" data-point="tbcart.8.11">${item.name
													} </a>
											</div>
										</div></li>

									<li class="td td-price">
										<div class="item-price price-promo-promo">
											<div class="price-content">
												<div class="price-line">
													<em class="price-original">${item.markprice }</em>
												</div>
												<div class="price-line">
													<em class="J_Price price-now" tabindex="0">${item.price
														}</em>
												</div>
											</div>
										</div></li>
									<li class="td td-amount">
										<div class="amount-wrapper ">
											<div class="item-amount ">
												<div class="sl">
													<input class="decrement" name="" type="button" value="-" />
													<input class="text_box" name="buycount" type="text"
														value="${item.buycount }" style="width:30px;"
														productid="${item.productid }" readonly /> <input
														class="increment" name="" type="button" value="+" />
												</div>
											</div>
										</div></li>
									<li class="td td-sum">
										<div class="td-inner">
											<span tabindex="0" class="J_ItemSum number"
												id="total${item.productid}">${item.total }</span>
										</div></li>
									<li class="td td-op">
										<div class="td-inner">

											<a
												href='javascript:if(confirm("确定要删除吗？"))window.location.href="<c:url value='/cartServlet?action=delete&id=${item.productid }'/>" ;'
												data-point-url="#" class="delete"> 删除</a>
										</div></li>
								</ul>
							</div>
						</div>
					</tr>
				</c:forEach>
			</form>
		</div>
		<div class="clear"></div>

		<div class="float-bar-wrapper">
			<div id="J_SelectAll2" class="select-all J_SelectAll">
				<div class="cart-checkbox">
					<input class="check-all check" id="all" type="checkbox" /> <label
						for="J_SelectAllCbx2"></label>
				</div>
				<span>全选</span>
			</div>
			<div class="operations">
				<a href='javascript:if(confirm("确定要删除吗？"))form1.submit();'
					hidefocus="true" class="deleteAll">删除</a>

			</div>
			<div class="float-bar-right">
				<div class="amount-sum">
					<span class="txt">已选商品</span> <em id="J_SelectedItemsCount">0</em><span
						class="txt">件</span>
					<div class="arrow-box">
						<span class="selected-items-arrow"></span> <span class="arrow"></span>
					</div>
				</div>
				<div class="price-sum">
					<span class="txt">合计:</span> <strong class="price">¥<span
						id="totalprice">${totalprice}</span> </strong>
				</div>
				<div class="btn-area">
					<a   id="J_Go"
						class="submit-btn submit-btn-disabled"
						aria-label="请注意如果没有选择宝贝，将无法结算" onclick="paysubmit()"> <span>结&nbsp;算</span> </a>
				</div>
			</div>
		</div>
	</div>
	<!-- 购物车end -->

	<div class="footer">

		<div class="footer-bd">
			<p>
				<a href="#">关于我们</a> <a href="#">合作伙伴</a> <a href="#">联系我们</a> <a
					href="#">网站地图</a> <em>© 2015-2025 版权所有. </em>
			</p>
		</div>
	</div>




	<!--操作页面-->

	<!--引导 -->
	<div class="navCir">
		<li><a href="home2.html"><i class="am-icon-home "></i>首页</a>
		</li>
		<li><a href="sort.html"><i class="am-icon-list"></i>分类</a>
		</li>
		<li class="active"><a href="shopcart.html"> <i
				class="am-icon-shopping-basket"></i>购物车</a>
		</li>
		<li><a href="../person/index.html"><i class="am-icon-user"></i>我的</a>
		</li>
	</div>
	
</body>

</html>