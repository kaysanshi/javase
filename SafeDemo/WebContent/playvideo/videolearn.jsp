<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/video.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/videomain.css">
	<title>在线视频学习</title>
</head>
<body>
	<div class="header">
        <div class="container">
            <a href="#" class="f_left logo"></a>
            <c:if test="${sessionScope.user == null}">
            <div class="f_right text-right">
            	
                <a id="loginLinkBtn" href="${pageContext.request.contextPath}/index.jsp" title="您好，请登录">您好，请登录</a>
          		
            </div>
            </c:if>
            <c:if test="${sessionScope.user != null}">
            <div class="f_right text-right">
            	<p font-color="#209583">你好！${sessionScope.user.username}</p>
            </div>
            </c:if>
            <ul id="navigator">
                <li><a id="top_2" href="#" title="安全新闻">安全新闻</a></li>
                <li><a id="top_3" href="#" title="通知公告">通知公告</a></li>
                <li><a id="top_1" href="#" title="政策法规">政策法规</a></li>
                <li><em></em></li>
                <li><a target="_blank" href="#" title="安全教育实验区">安全教育实验区</a></li>
                <li><a href="#" target="_blank" title="安全教育示范区">安全教育示范区</a></li>
                <li><a id="top_4" href="#" target="_blank" title="安全专委会">安全专委会</a></li>
                <li><em></em></li>
                <li><a id="top_SecurityRepository" href="#" title="安全资源库">安全资源库</a></li>
                <li><a id="top_Seminar" href="#" title="专题课">专题课</a></li>
                <li><a id="top_Activity" href="#" title="活动专区">活动专区</a></li>
            </ul>
        </div>
	</div>
		

	<div class="header_top">
		<div class="topcont">
			<div class="topleft">
       			<div class="pic"></div>
       			<div class="f_left">
            		<a href="${pageContext.request.contextPath}/index.jsp" title="首页">首页</a>&gt;
            		<a href="${pageContext.request.contextPath}/DownVideoListServlet" title="安全资源库">安全资源库</a>&gt;
            		<a href="#" id="anquanship" style=" display:none" title="安全视频">安全视频</a>
            		<a href="#" id="gongxiangziyuan" style="" title="共享资源">共享资源</a>&gt;
            		<a href="#">家有儿女</a>
        		</div>
    		</div>
    		<div class="searchbg">
        		<input type="text" placeholder="请输入关键字">
       			<a href="#" class="btn_search"></a>
    		</div>
		</div>
	</div>
	

	<div class="sub_menu">
		<ul id="ul_menu">
		    <li><a id="menu_zrzh" href="#" title="自然灾害">自然灾害</a></li>
		    <li><a id="menu_ywsh" href="#" title="意外伤害">意外伤害</a></li>
		    <li><a id="menu_shaq" href="#" title="社会安全">社会安全</a></li>
		    <li><a id="menu_ggws" href="#" title="公共卫生">公共卫生</a></li>
		    <li><a id="menu_wlaq" href="#" title="网络安全">网络安全</a></li>
		    <li><a id="menu_xljk" href="#" title="心理健康">心理健康 </a></li>
		    <li><em></em></li>
		    <li><a id="menu_SafetyKnowledge" href="#" title="安全知识">安全知识</a></li>
		    <li><a id="menu_SafetyPicture" href="#" title="安全图片">安全图片</a></li>
		    <li><a id="menu_SafetyComicList" href="#" title="安全漫画">安全漫画</a></li>
		    <li><a id="menu_SafeVideo" href="${pageContext.request.contextPath}/playvideo/uploadvideo.jsp" class="" title="视频上传">视频上传</a></li>
		    <li><a id="menu_Encyclopedias" href="#" title="安全百科">安全百科</a></li>
		    <li><em></em></li>
		    <li><a id="menu_SharedResource" href="http://www.baidu.com" title="共享资源">
		        共享资源</a></li>
        </ul>
	</div>


	<div class="gameplay-body">
		<div class="pagecontent">
			<div class="gametitle">
				<p></p>
            	<a href="${pageContext.request.contextPath}/GetPlayServlet" title="返回">返回</a>
			</div>
			<div class="gameplay">
				<div class="playbox">
					<p style="text-align: center">
						<video autoplay="autoplay" controls="controls" loop="loop" style="width: 100%" width="100%" poster="images/shipin.png">
							<source src="${requestScope.filepath }">
						</video>
					</p>
					<div class="bto">因视频较大，建议提前缓冲观看，确保播放流畅。</div>
				</div>
				<div class="play-rtlist">
					<% int i=1; %>
	                <div class="hd">相关视频</div>
	             	<ul>
	             	<c:forEach items="${ requestScope.list}" var="r">
	                    <li class="">
	                    	<em><%=i++ %></em>
	                        <h4><a href="${pageContext.request.contextPath }/PlayServlet?id=${r.id }" target="gameplay">${r.realname}</a></h4>
	                    </li>
	                </c:forEach>
	                 </ul>
	            </div>
			</div>
		</div>

	</div>
	

	<div class="pagecontent">
		<div class="gamehd">其他人正在观看</div>
		<div class="gamediv">
			<ul>
				<li>
					<a href="#"><img src="images/1.jpg" alt=""></a>
					<h4><a href="#" title="">安全教育</a></h4>
				</li>
				<li>
					<a href="#"><img src="images/2.jpg" alt=""></a>
					<h4><a href="#" title="">神话天地</a></h4>
				</li>
				<li>
					<a href="#"><img src="images/3.jpg" alt=""></a>
					<h4><a href="#" title="">眼镜创奇</a></h4>
				</li>
				<li>
					<a href="#"><img src="images/4.jpg" alt=""></a>
					<h4><a href="#" title="">阳阳的梦</a></h4>
				</li>
			</ul>
		</div>
	</div>


    <div id="footer">
	    <div class="container text-center">
	        <p>
	            <a href="#" class="foot_logo"></a>
	        </p>
	        <p>
	            <span>
		            <a target="_blank" href="#" title="关于我们">关于我们</a>
		            <a target="_blank" href="#" title="联系我们">联系我们</a>
		            <a target="_blank" href="#" title="支持单位">支持单位</a>
		            <a target="_blank" href="#" title="专家团队">专家团队</a>
		            <a target="_blank" href="#" title="用户帮助">用户帮助</a>
	        	</span>
	        </p>
	        <p>咨询电话：400-107-1110（周一到周五 9:00-17:00）邮箱：csesafe@moe.edu.cn
	        </p>
	    </div>
	</div>






</body>
</html>