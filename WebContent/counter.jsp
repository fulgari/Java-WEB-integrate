<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<% out.clear();
   if("1".equals(request.getParameter("param"))){
%>
<jsp:forward page="/greeting.jsp">
<jsp:param name="param1" value="value1"/>
<jsp:param name="param2" value="value2"/>
</jsp:forward>
<%} %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Counter jsp</title>
</head>
<body>
<br>
<jsp:useBean id="personCount" class="jsp.bean.Counter" scope="session"/>
<jsp:useBean id="totalCount" class="jsp.bean.Counter" scope="application"/>
<div align="center">
<form action="method.jsp" method="get">
<fieldset style="width:300">
<legend>Counter</legend>
<tr>
	<td align="right" style="font-weight:bold;">Your visits:</td>
	<td><jsp:getProperty name="personCount" property="count"/></td>
</tr>
<br>
<tr>
	<td align="right" style="font-weight:bold;">Total visits:</td>
	<td><jsp:getProperty name="totalCount" property="count"/></td>
</tr>
<br/>
<input type="button" onclick="window.location.reload();" value="back" class="button">
</fieldset>
</form>
</div>
</body>
</html>