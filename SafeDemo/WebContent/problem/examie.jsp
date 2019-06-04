<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<title>在线答题</title>
		<meta name="generator" content="editplus">
		<meta name="author" content="">
		<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
		<meta name="keywords" content="">
		<meta name="description" content="">
</head>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/testOnline.css" />
	<script src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js" type="text/javascript" charset="utf-8"></script>
	<!--倒计时-->
	<script type="text/javascript">
		var starttime = new Date().setMilliseconds(2700000);
		setInterval(function() {
			var nowtime = new Date().setMilliseconds(0);
			var time = starttime - nowtime;
			var minute = parseInt(time / 1000 / 60 % 60);
			var seconds = parseInt(time / 1000 % 60);
			$('#time li').html(minute + "分" + seconds + "秒");
		}, 1000);
	</script>
	<!--弹出答案-->
	<script type="text/javascript">
		$(document).ready(function() {
			$('#keys').click(function() {
				$('#Pop-up').show();
			});
			$('#close').click(function() {
				$('#Pop-up').hide();
			});
		});
	</script>
	<!--收起解析-->
	<script type="text/javascript">
		$(document).ready(function() {
			$('#hand').click(function() {
				$('#keys').show();
				$('#close').show();
			});
		});
	</script>
	<!--检查试卷是否为白卷-->
	<script type="text/javascript">
		$(document).ready(function() {
			var optionA = $("#A");
			var optionB = $("#B");
			var optionC = $("#C");
			var optionD = $("#D");
			var hand = $("#hand")
			hand.click(function() {
				if(optionA.is(":checked") ||
					optionB.is(":checked") ||
					optionC.is(":checked") ||
					optionD.is(":checked")) {
					alert("交卷成功！");
				} else {
					alert("请认真答题");	
				}
			})
		});
	</script>

	<body>
	<c:if test="${sessionScope.user != null}">
		<div class="back">
			<div id="menu">
				<li id="top">在线考试平台</li>
				<li id="account">
					用户名:<span>${sessionScope.user.username}</span>
				</li>
				<div id="time">
					<li></li>
				</div>
			</div>
			<form action="${pageContext.request.contextPath}/CheckAnswerServlet" method="post">
				<% int i=1; %>
				<c:forEach items="${requestScope.list}" var="problem">
					<input type="hidden" name="subjectid" value="${problem.subjectid}"/>
					
			<div id="test">
					<ul id="section-title">
						<li id="num"><%=i++%>.</li>
						<li id="score">(3分)</li>
						<li id="title"><c:out value="${problem.subjecttitle}"></c:out>( )</li>
					</ul>
					<ul id="section-selct">
						<li id="selction">
							<li id="a">A.<c:out value="${problem.subjectOptionA}"></c:out></li>
							<li id="b">B.<c:out value="${problem.subjectOptionB}"></c:out></li>
							<li id="c">C.<c:out value="${problem.subjectOptionC}"></c:out></li>
							<li id="d">D.<c:out value="${problem.subjectOptionD}"></c:out></li>
						</li>
						<li id="reset1">
							A<input type="checkbox" name="subjectOption" id="A" value="${problem.subjectOptionA}" /> B
							<input type="checkbox" name="subjectOption" id="B" value="${problem.subjectOptionB}" /> C
							<input type="checkbox" name="subjectOption" id="C" value="${problem.subjectOptionC}" /> D
							<input type="checkbox" name="subjectOption" id="D" value="${problem.subjectOptionD}" />
						</li>
						<div id="Pop-up">
							<li id="parsing">
								<a href="#">解析：</a>
							</li>
							<li>
								<c:out value="${problem.subjectParse}"></c:out>
							</li>

						</div>
					</ul>
					</div>
					</c:forEach>
					<input type="submit" value="交卷" id="hand" />
					<input type="button" value="查看答案" id="keys" />
					<input type="button" value="收起解析" id="close" />
					</form>
			</div>
			
		</c:if>
		<c:if test="${sessionScope.user== null ||sessionScope.user==''}">
			 <script language='javascript'> alert('未登录登陆请先登录');window.location.href='index.jsp';</script>;
		</c:if>
	</body>

</html>