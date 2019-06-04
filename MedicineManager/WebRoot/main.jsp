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
    <title>'MyJsp.jsp'</title>
	<link rel="stylesheet" type="text/css" href="images/styles.css">
  </head>
  
  <body>
  <jsp:forward page="baseData/med.do?command=paging"></jsp:forward>
  </body>
</html>
