<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--顶部导航条 -->
			<div class="am-container header">
				<ul class="message-l">
					<div class="topMessage">
						<div class="menu-hd">
							<a href="<c:url value='/login.jsp'/>" target="_top" class="h">亲，请登录</a>
							<a href="<c:url value='/regist.jsp'/>" target="_top">免费注册</a>
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
						<div class="menu-hd"><a id="mc-menu-hd"  href="<c:url value='/cart.jsp'/>" target="_top"><i class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong id="J_MiniCartNum" class="h">0</strong></a></div>
					</div>
					<div class="topMessage favorite">
						<div class="menu-hd"><a href="#" target="_top"><i class="am-icon-heart am-icon-fw"></i><span>收藏夹</span></a></div>
				</ul>
				</div>
				
				<!--悬浮搜索框-->

				<div class="nav white">
				<div class="logo"><img src="<c:url value='/images/logo.png'/>" /></div>
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
			<!--悬浮搜索框结束-->
				<div class="clear"></div>
				
				<div class="listMain">"
				
			        
					  
								<div class="nav-table">
					   <div class="long-title"><span class="all-goods">全部分类</span></div>
					   <div class="nav-cont">
							<ul>
								<li class="index"><a href="<c:url value='/index.jsp'/>">首页</a></li>
                                <li class="qc"><a href="<c:url value='/cart.jsp'/>">购物车</a></li>
                                <li class="qc"><a href="<c:url value='/orderServlet?action=findAll'/>">我的订单</a></li>
                                <li class="qc last"><a href="#">个人中心</a></li>
							</ul>
						    
						</div>
			</div>
				
			</div>