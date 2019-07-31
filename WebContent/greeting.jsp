<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="java.util.*"
    pageEncoding="ISO-8859-1"%>
<%
	Locale locale = request.getLocale();
	Calendar calendar = Calendar.getInstance(locale);
	int hour = calendar.get(Calendar.HOUR_OF_DAY);
	String greeting="";
	if(hour<=6){
		greeting="Midnight";
	} else if(hour<=9){
		greeting="Morning";
	} else if(hour<=12){
		greeting="before noon真棒！";
	} else if(hour<=18){
		greeting="after noon好哦";
	}else if(hour<=24){
		greeting="Evening";
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome!!</title>
</head>
<body>
<table>
<tr>
<td><%= greeting %></td>
</tr>
</table>
</body>
<img src="/images/vue_brasov.jpg">
</html>