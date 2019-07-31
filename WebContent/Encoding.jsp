<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%
	Cookie encoding=new Cookie(URLEncoder.encode("六","UTF-8"),URLEncoder.encode("核桃", "UTF-8"));
	response.addCookie(encoding);
%>
<meta charset="ISO-8859-1">
<title>Encoding test</title>
</head>
<body>

<%
	if(request.getCookies()!=null){
		for(Cookie cookie:request.getCookies()){
			out.println(cookie.getName()+" = "+cookie.getValue()+"; <br/>");
		}
	} else {
		out.println("written in the server!");
	}
%>

</body>
</html>