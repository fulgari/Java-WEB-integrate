<%@page import="com.integrate.listener.ApplicationConstants"%>
<%@page import="java.text.DateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
running time:
<br>
<%= DateFormat.getDateInstance().format(ApplicationConstants.START_DATE) %>
<br>
all visitors:
<br>
<%=ApplicationConstants.TOTAL_HISTORY_COUNT %>
<br>
max online visitors:
<%=ApplicationConstants.MAX_ONLINE_COUNT %>
<br>
at:<%=DateFormat.getDateInstance().format(ApplicationConstants.MAX_ONLINE_COUNT_DATE)%>
<br>
online now:
<%=ApplicationConstants.SESSION_MAP.size() %>
<br>
user:
<%=ApplicationConstants.CURRENT_LOGIN_COUNT %>
<br>

<table border=1>
	<tr>
		<th>jsessionid</th>
		<th>account</th>
		<th>creationTime</th>
		<th>lastAccessedTime</th>
	</tr>
</table>
</body>
</html>