<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:directive.page import="jsp.bean.PersonInfo" />

<%
	String action=request.getParameter("action");
	String account=request.getParameter("account");
	
	if("login".equals(action) && account.trim().length()>0){
		PersonInfo personInfo = new PersonInfo();
		personInfo.setAccount(account.trim().toLowerCase());
		personInfo.setIp(request.getRemoteAddr());
		personInfo.setLoginDate(new Date());
		session.setAttribute("personInfo", personInfo);
		
		response.sendRedirect(response.encodeRedirectURL(request.getRequestURI()));
		return;
	} else if("logout".equals(action)){
		session.removeAttribute("personInfo");
		response.sendRedirect(response.encodeRedirectURL(request.getRequestURI().toString()));
		return;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% if(session.getAttribute("personInfo") != null){ %>
		welcome, <%= ((String)((PersonInfo)session.getAttribute("personInfo")).getAccount()) %>, <br/>
		your IP is: <%= ((PersonInfo)session.getAttribute("personInfo")).getIp() %>, <br/>
		<%=((PersonInfo)session.getAttribute("personInfo")).getLoginDate() %>
		<a href="${pageContext.request.requestURI }?action=logout">Logout</a>
		<script type="text/javascript">setTimeout("location=location;",5000);</script>
<% } else { %>

		<%= (String)session.getAttribute("msg") %>
		<% session.removeAttribute("msg"); %>
		<form action="${pageContext.request.requestURI }?action=login" method="post">
		username: <input name="account"/>
		<input type="submit" value="LOGIN">
		</form>
<%} %>
</body>
</html>