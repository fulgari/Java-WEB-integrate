<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.text.DateFormat" import="java.text.SimpleDateFormat" import="java.util.Date" import="jsp.bean.Person"  %>
<%!
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
%>
<%
	Person person = (Person) session.getAttribute("person");
	Date loginTime = (Date) session.getAttribute("loginTime");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome To the PAGE!</title>
</head>
<body>

<fieldset>
	<legend>WELCOME</legend>
	<table>
		<tr>
			<td>Your name:</td>
			<td><%= person.getName() %></td>
		</tr>
		<tr>
			<td>Your age:</td>
			<td><%= person.getAge() %></td>
		</tr>
	</table>
</fieldset>
</body>
</html>