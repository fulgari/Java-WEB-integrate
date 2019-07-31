<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isErrorPage="true"
    pageEncoding="ISO-8859-1"%>
<% if("POST".equals(request.getMethod())){
	Cookie usernameC = new Cookie("username",request.getParameter("username"));
	Cookie visittimesCookie = new Cookie("visitTimes","0");
	response.addCookie(usernameC);
	response.addCookie(visittimesCookie);
	
	response.sendRedirect(request.getContextPath()+"/cookie.jsp");
	return;
}	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Please Log in</title>
</head>
<body>
<div align="center" style="margin:10px;">
<fieldset>
<legend>Log in</legend>
<form action="login.jsp" method="post">
<table>
<tr>
<td></td>
<td><%=exception.getMessage() %></td>
</tr>
<tr>
<td>your account:</td>
<td><input type="text" name="username" style="width:200px;"></td>
</tr>
<tr>
<td>password:</td>
<td><input type="password" name="password" style="width:200px;"></td>
</tr>
<tr>
<td></td>
<td><input type="submit" value="login" class="button"></td>
</tr>
</table>
</form>
</fieldset>
</div>
</body>
</html>