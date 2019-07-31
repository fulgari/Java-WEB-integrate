<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<style type="text/css">
.error{
	font-size:12px;
	padding:5px;
	border: 1px solid #FF0000;
	background: url(images/vue_brasov.jpg) 8px 5px no-repeat #FFEEFF;
	padding-left:30px;
}
</style>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="error">
${message} 
<a href="javascript:history.go(-1);">RETURN</a>
</div>
</body>
</html>