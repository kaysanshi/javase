<%@ page language="java" pageEncoding="GBK"%>

<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html locale="true">
  <head>
    <title><bean:message key="medicine.all" /></title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="../images/styles.css">
	<script type="text/javascript">
		function blurQuery(){
			var form = document.forms["medForm"];
			if(form.elements["keyWord"].value == ""){
				alert("<bean:message key="query.keyWord.null" />");
				form.elements["keyWord"].focus();
				return false;
			}
		}
	</script>
  </head>
  <body>
  <div class="div1">
		<table width="100%" cellpadding="0" cellspacing="0" border="0"
			align="center">
			<tr>
				<td class="td_title1">
					¡¤<bean:message key="system.current.place"/>£º
					<bean:message key="system.category.medicine"/>
					&gt;&gt; <bean:message key="system.category.medicine.view"/>
					&gt;&gt; <bean:message key="medicine.all" />
				</td>
			</tr>
			<tr>
				<td bgcolor="#FFFFFF" height="50">
					<br>
      <table border="1" align="center" width="700" cellpadding="1" cellspacing="1" bgcolor="#036500" bordercolor="#FFFFF">
        <tr bgcolor="#FFFFFF">
          <td colspan="9" align="center">
          		<table border="0" width="100%">
          			<tr>
          				<td align="left">
          					<form name="medForm" action='<html:rewrite page="/baseData/med.do"/>' method="post" onsubmit="return blurQuery();" class="blur_form">
          						<input type="hidden" name="command" value="blurQuery"/>
          						<bean:message key="system.blur.query" />£º<input name="keyWord" type="text" size="20"/>
          						<input type="submit" value="<bean:message key="button.query" />"/>
          					</form>
          				</td>
          			</tr>
          		</table>
          </td>
        </tr>
        <tr bgcolor="#FFFFFF" >
          <td class="tb_tl"><bean:message key="system.delete" /></td>
          <td class="tb_tl"><bean:message key="medicine.id" /></td>
          <td class="tb_tl"><bean:message key="medicine.medNo" /></td>
          <td class="tb_tl"><bean:message key="medicine.name" /></td>
          <td class="tb_tl"><bean:message key="medicine.price" /></td>
          <td class="tb_tl"><bean:message key="medicine.storage.count" /></td>
          <td class="tb_tl"><bean:message key="medicine.req.count" /></td>
          <td class="tb_tl"><bean:message key="medicine.factoryAdd" /></td>
          <td class="tb_tl"><bean:message key="system.operate" /></td>
        </tr>
        <logic:present name="list" scope="request">
        	<logic:notEmpty name="list" scope="request">
        		<form action='<html:rewrite page="/baseData/deleteMedicineAction.do"/>' method='post'>
	        	<logic:iterate id="ele" name="list" scope="request">
	        		<tr bgcolor="#FFFFFF">
	        			<td>
	        				<input type="hidden" name="allId" value='<bean:write name="ele" property="id" />'>
							<input type="checkbox" name="selectedId" value='<bean:write name="ele" property="id" />'>
						</td>
	        			<td><bean:write name="ele" property="id"/></td>
	        			<td><bean:write name="ele" property="medNo"/></td>
	        			<td>
	        				<html:link href="med.do?command=view" paramId="id" paramName="ele" paramProperty="id">
	        				<bean:write name="ele" property="name"/>
	        				</html:link>
	        			</td>
	        			<td><bean:write name="ele" property="price" format="###,###.##"/>
							<bean:message key="system.money"/>
						</td>
	        			<td><bean:write name="ele" property="medCount"/></td>
	        			<td><bean:write name="ele" property="reqCount"/></td>
	        			<td><bean:write name="ele" property="factoryAdd"/></td>
	        			<td>
	        				<html:link href="../require/require.do?command=update" paramId="id" paramName="ele" paramProperty="id">
								<bean:message key="system.stock"/>
							</html:link>
	        				<html:link href="med.do?command=edit" paramId="id" paramName="ele" paramProperty="id">
								<bean:message key="system.modify"/>
							</html:link>
	        				<logic:greaterThan value="0" name="ele" property="medCount">
	        					<html:link forward="buy" paramId="id" paramName="ele" paramProperty="id">
									<bean:message key="system.buy"/>
								</html:link>
	        				</logic:greaterThan>
	        				<logic:lessThan value="1" name="ele" property="medCount">
	        					<bean:message key="system.buy"/>
	        				</logic:lessThan>
	        			</td>
	        		</tr>
	        	</logic:iterate>
	        	<tr bgcolor="#FFFFFF">
		        
		          <td colspan="9" align="right">
		          	<table border="0" width="100%">
		          		<tr>
		          			<td>
		          				<html:submit property="command"><bean:message key="button.delete.selected"/></html:submit>
			      				<html:submit property="command"><bean:message key="button.delete.all"/></html:submit>
		          			</td>
		          			</form>
		          			<td align="right">
			          			<logic:present name="pagingBar" scope="request">
									<bean:write name="pagingBar" filter="false" scope="request"/>
							    </logic:present>
		          			</td>
		          		</tr>
		          	</table>
			      </td>
			    </tr>
        	</logic:notEmpty>
        	<logic:empty name="list" scope="request">
        	<tr bgcolor="#FFFFFF">
	          <td colspan="8" align="center">
				<bean:message key="system.message.null"/>
			  </td>
	        </tr>
        	</logic:empty>
        </logic:present>
        <logic:notPresent name="list" scope="request">
        	<tr bgcolor="#FFFFFF">
	          <td colspan="9" align="center">
				<bean:message key="system.message.null"/>
			  </td>
	        </tr>
	    </logic:notPresent>
      </table>
      <br>
      </td>
			</tr>
		</table>
	</div>
  </body>
</html:html>
