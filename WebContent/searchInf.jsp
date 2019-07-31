<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Toogle</title>
</head>

<body>
<fieldset>

<legend>search for sth?</legend>

<div>
<div class="leftClass"><input id="userin" type="text" value="please input"></div>
<div class="rightClass"><input type="submit" onclick='kk()' value="Let's Go!"></div>
</div>

</fieldset>

<script type="text/javascript">
	function kk(){
		var str = "http://localhost:8080/Integrate/Search.jsp?word=";
		var domInput = document.getElementById('userin');
		str = str + domInput.value;
		console.log(str);
		window.location.href=str;
	}
</script>
</body>
</html>