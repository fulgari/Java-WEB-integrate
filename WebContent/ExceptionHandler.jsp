<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.integrate.Exception.AccountException" %>
<%@ page import="com.integrate.Exception.BusinessException" %>
<%
	String action =request.getParameter("action");
	if("businessException".equals(action)){
		throw new BusinessException("business opt failed");
	} else if("accountException".equals(action)){
		throw new AccountException("log in required before opt");
	} else if("exception".equals(action)){
		Integer.parseInt("");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EH.jsp</title>
</head>
<body>
<a href="ExceptionHandler.jsp?action=businessException">test BusinessException</a><br/>
<a href="ExceptionHandler.jsp?action=accountException">test AccountException</a><br/>
<a href="ExceptionHandler.jsp?action=exception">test Exception</a><br/>

</body>
</html>