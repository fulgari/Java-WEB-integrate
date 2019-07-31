<%@ page language="java" contentType="text/html; charset=ISO-8859-1" errorPage="login.jsp"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%
request.setCharacterEncoding("UTF-8");

String username="";
int visitTimes=0;

Cookie[] cookies = request.getCookies();
for(int i=0; cookies!=null && i<cookies.length;i++){
	Cookie cookie = cookies[i];
	if("username".equals(cookie.getName())){
		username=cookie.getValue();
	}else if("visitTimes".equals(cookie.getName())){
		visitTimes=Integer.parseInt(cookie.getValue());
	}
}
if(username==null||username.trim().equals("")){
	throw new Exception("not signed in");
}
Cookie visitTimesCookie = new Cookie("visitTimes",Integer.toString(++visitTimes));
response.addCookie(visitTimesCookie);
%>
<title></title>
</head>
<body>
<div align="center" style="margin:10px;">
<fieldset>
<legend>Log in message</legend>
<form action="login.jsp" method="post">
<table>
<tr>
<td>your account:</td>
<td><%= username %></td>
</tr>
<tr>
<td>log in times:</td>
<td><%= visitTimes %></td>
</tr>
<tr>
<td></td>
<td><input type="button" value="refresh" onclick="location='<%=request.getRequestURI() %>?ts='+new Date().getTime();" class="button"></td>
</tr>
</table>
</form>
</fieldset>
</div>
</body>
</html>