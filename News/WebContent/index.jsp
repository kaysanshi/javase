<%@ page language="java" import="java.util.*,com.zcib.domain.User" pageEncoding="UTF-8"%>

<jsp:forward page="${pageContext.request.contextPath }/NewsServlet">
	<jsp:param value="findAll" name="action"/>
</jsp:forward>
