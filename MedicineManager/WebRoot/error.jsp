<%@ page language="java" pageEncoding="GBK"%>

<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html locale="true">
  <head>
    <title>error</title>

	<link rel="stylesheet" type="text/css" href="../images/styles.css">
  </head>
  <body>
    <div class="div1">
		<table width="100%" cellpadding="0"  cellspacing="0" border="0" align="center">
			<tr>
				<td class="td_title1">
					¡¤<bean:message key="system.current.place"/>£º
					<bean:message key="system.error"/>
				</td>
			</tr>
			<tr>
				<td bgcolor="#FFFFFF" height="20">
					
				</td>
			</tr>
			<tr>
  			<td bgcolor="#FFFFFF" height="50" align="center">
  				<h3><font color="red"><html:errors/></font></h3>
  			</td>
  		</tr>
  		<tr>
  			<td bgcolor="#FFFFFF" height="20" align="center">
  				<a href="javaScript:window.history.go(-1);">·µ»Ø</a>
  			</td>
  		</tr>
		</table>
  </div>
  </body>
</html:html>
