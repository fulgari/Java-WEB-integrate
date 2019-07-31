<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.text.DateFormat" import="java.text.SimpleDateFormat" import="java.util.Date" import="jsp.bean.Person"  %>
<%!	
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
%>

<%	Person[] persons = {
			new Person("LiuXiang",23),
			new Person("XiaoMing",21),
			new Person("LiZhi",36)
		};
	String message="";
	response.setCharacterEncoding("UTF-8");
	
	// if login by POST method
	if(request.getMethod().equals("POST")){
		for(Person p : persons){ // run through data to verify username and age 
			if(p.getName().equalsIgnoreCase(request.getParameter("username"))
					&& p.getAge()==Integer.parseInt(request.getParameter("age"))){
			
				// SUCCESSFULLY LOGGED IN, save user info and login time to Session
				session.setAttribute("person", p); // save login Person
				session.setAttribute("loginTime", new Date()); // save login time
				// session.setAttribute("role", p);
			
				response.sendRedirect(request.getContextPath()+"/welcome.jsp");
				return;
			}
		}
		message="Login failed: username and age not correct";
	}
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Session Form</title>
</head>
<body>
	<form method="post">
		<fieldset>
			<legend>Session Form</legend>
			<div>
				<div class="left"><label for="username">Username:</label></div>
				<div><input type="text" name="username"></div>
			</div>
			<div>
				<div class="left"><label for="age">Age:</label></div>
				<div><input type="text" name="age"></div>
			</div>
			<div>
				<div class="left"></div>
				<div><input class="button" value="Confirm" type="submit" /></div>
			</div>
			<div><%=message %></div>
			<div><%=request.getParameter("username") %></div>
		</fieldset>
	</form>
</body>
</html>