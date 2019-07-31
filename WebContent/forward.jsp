<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
    <jsp:directive.page import = "java.util.Date"/>
    <jsp:directive.page import = "java.text.SimpleDateFormat"/>
    <% Date date = (Date) request.getAttribute("date"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forward Jump</title>

<link rel='stylesheet' type='text/css' href='<%= request.getContextPath() %>/css/style.css'>
</head>
<body>
<div align='center'><br/><fieldset style=width:90%><legend>Forward Jump</legend><br/>
<div style='line'>
	<div>from ForwardServlet we have the date:</div>
	<div><%= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(date) %></div>
</div><br/>
<div style='line'>
<div align='center'>

	<input type='button' onclick='location="<%=request.getContextPath() %>/ForwardServlet?dest=servlet";' value='jump to Servlet' class=button/>
	<input type='button' onclick='location="<%=request.getContextPath() %>/ForwardServlet?dest=file";' value='jump to web.xml' class=button/>
	<input type='button' onclick='location="<%=request.getContextPath() %>/ForwardServlet?dest=jsp";' value='jump to JSP' class=button/>
	
</div>
</div>
</fieldset></div>
</body>
</html>