<%@ page language="java" pageEncoding="GBK"%>

<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html locale="true">
  <head>
    <title><bean:message key="user.login.title"/></title>
	<style type="text/css">
		<!--
		body{
			margin: 0px;
			font-size: 12px;
			background-color: #4C8C1C;
		}
		.tb1{
			position: relative;
			top: -355;
			left: 280;
		}
		.it{
			background-color: #E1FFC1;
			height: 20px;
			width: 150px;
		}
		-->
	</style>
	<script language="javaScript">
		if(self != top){
			alert("<bean:message key="user.login.timeout"/>");
			top.location = self.location;
		}
		function login(){
			var form = document.forms["userForm"];
			if(form.elements["username"].value == ""){
				alert("<bean:message key="user.username.null"/>");
				form.elements["username"].focus();
				return;
			}
			if(form.elements["password"].value == ""){
				alert("<bean:message key="user.password.null"/>");
				form.elements["password"].focus();
				return;
			}
			form.submit();
		}
	</script>
  </head>
  <body>
  <html:errors/>
  <table border="0" width="990" height="600" align="center" cellpadding="0" cellspacing="0">
      	
      	<tr>
          <td colspan="2" align="left" valign="top">
         		<img src="images/<bean:message key='system.backgroud'/>" border="0" usemap="#Map">
         		<html:form action = "login.do" focus="username">
		    	<table border="0" class="tb1">
						<logic:notEmpty name="error">
			      		 <tr>
			          		<td colspan="2" align="center">
			          			<bean:message key='user.login.error'/>
			          		</td>
			          	</tr>
			      	</logic:notEmpty>
			        <tr>
			          <td align="right"><bean:message key="user.username"/>£º</td>
			          <td><html:text property="username" value="admin" styleClass="it"/></td>
			        </tr>
			        <tr>
			          <td align="right"><bean:message key="user.password"/>£º</td>
			          <td><html:password property="password" value="admin" styleClass="it"/></td>
			        </tr>
			        <tr>
			          <td colspan="2" align="center" height="30">
			         	 <html:button property="lgoin" onclick="login()">
			         	 <bean:message key="user.button.login"/>
			         	 </html:button>
			         	 <html:reset>
			         	 <bean:message key="button.reset"/>
			         	 </html:reset>
			          </td>
			        </tr>
			      </table>
		    </html:form>
          </td>
        </tr>
  </table>
  
<map name="Map"><area shape="rect" coords="265,140,323,154" href="<html:rewrite page="/language.do?lan=zh"/>">
<area shape="rect" coords="335,138,406,153" href="<html:rewrite page="/language.do?lan=en"/>">
</map></body>
</html:html>
