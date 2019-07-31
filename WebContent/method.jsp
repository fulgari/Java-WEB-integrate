<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP Scriptlets</title>
</head>
<body>
<%
String param = request.getParameter("param");
String re = request.getParameter("re");
if("1".equals(param)){
%>
HHHHHHHHHHHHHHHHHHHH
<%
} else if("2".equals(param)){
%>
SSSSSSSSSSSSSSSSSSSS
<%} %>

<%
Object[][] letters={
		{true,"nice to meet you"},
		{true,"Received"},
		{false,"new msg"},
};
String[] colors={"#DDDDDD","#AAAAAA"};
%>
<table border=0 cellspacing=1 cellpadding=2 width=700 align=center>
<tr style="background: url(images/vertical_line.gif);">
<td align="center" style="line-height:22px;">&nbsp;</td>
<td align="center" style="line-height:22px;">title&nbsp;</td>
<td align="center" style="line-height:22px;">message&nbsp;</td>
</tr>
<%
for(int i=0; i<letters.length; i++){
	Object[] letter = letters[i];
%>
<tr style='background:<%=colors[i%2] %>'>
<td align="center">
<% if(letter[0]==Boolean.TRUE){ %>
<img src="images/mail.gif">
<% }else{ out.println("&nbsp;");} %>
</td>
<td><a href="#"><%=letter[1] %></a></td>
</tr>
<%} %>

<%
java.util.List<String> list = new java.util.ArrayList<String>();
list.add("rabbit");
list.add("walk around");
if("return".equals(re)) return;

list.add("cloth not new");
list.add("people still");
java.util.Iterator it = list.iterator();
while(it.hasNext()){
%><%=it.next() %><br/>
<%
}%>

</table>
</body>
</html>