<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java Bean Actions</title>
</head>
<body>
<br/>
<jsp:useBean id="person" class="jsp.bean.Person" scope="page"></jsp:useBean>
<jsp:setProperty property="*" name="person"/>

<div align="center">
<form action="method.jsp" method="get">
<fieldset style="width:300">
<legend>Please Input Person Info</legend>
<tr>
	<td align="right" style="font-weight:bold;">Name</td>
	<td><jsp:getProperty name="person" property="name"/></td>
</tr>
<br>
<tr>
	<td align="right" style="font-weight:bold;">Age</td>
	<td><jsp:getProperty name="person" property="age"/></td>
</tr>
<br/>
welcome, ${person}.<br> Your name is ${person.name }, your age is ${person.age }!<br>

<input type="button" onclick="history.go(-1);" value="back" class="button">
</fieldset>
</form>

</div>
</body>
</html>