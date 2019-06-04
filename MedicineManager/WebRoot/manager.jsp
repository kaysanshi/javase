<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean"
	prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html"
	prefix="html"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic"
	prefix="logic"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title><bean:message key="system.title" /></title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
	</head>
	<logic:empty scope="session" name="user">
		<logic:forward name="login"/>
	</logic:empty>
	<logic:notEmpty scope="session" name="user">
		<frameset rows="180,*" cols="*" framespacing="0" frameborder="no"
			border="0">
			<frame src="top.jsp" name="top" scrolling="NO">
			<frameset rows="*" cols="223,*" framespacing="0" frameborder="no"
				border="0">
				<frame src="left.jsp" name="left">
				<frame src="baseData/med.do?command=paging" name="main">
			</frameset>
		</frameset>
		<noframes>
			<body>
			</body>
		</noframes>
	</logic:notEmpty>
</html>
