<%@ page language="java" pageEncoding="GBK"%>

<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html locale="true">
  <head>
    <title><bean:message key="system.category.category.add"/></title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="../images/styles.css">
  </head>
  <body>
    <div class="div1">
		<table width="100%" cellpadding="0" cellspacing="0" border="0"
			align="center">
			<tr>
				<td class="td_title1">
					¡¤<bean:message key="system.current.place"/>£º
					<bean:message key="system.category.category"/>
					&gt;&gt; <bean:message key="system.category.category.count"/>
				</td>
			</tr>
			<tr>
				<td bgcolor="#FFFFFF" height="50" align="center">
					<br>
   					<logic:notEmpty name="graphURL" scope="request">
   						<img src="<bean:write name='graphURL' scope='request'/>">
   					</logic:notEmpty>
    			</td>
			</tr>
		</table>
	</div>
  </body>
</html:html>
