<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tropical Cheese!!!</title>
<script type="text/javascript" src="scripts.js"></script>
<link rel="stylesheet" type="text/css" href="indexStyle.css">
</head>
<body>
<img alt="" src="header.png" id="headerImg">

<!-- get cookies -->
<%
	String username = "";
	String password = "";
	Cookie[] cookies = request.getCookies();
	if(cookies.length > 0 && !cookies[0].getName().equalsIgnoreCase("jsessionid")){
		username = cookies[0].getName();
		password = cookies[0].getValue();
	}
%>
<form id="loginForm" action="./LoginVeri" method="post" onsubmit="return validate()">
	<header><h5>MOBILE CUSTOMER ORDER TRACKING</h5></header>
	
	<div class="loginDiv">
		Username: <input type="text" id="username" name="username" value=<%=username%> /><br>
		<br>
		Password: <input type="password" id="password" name="password" value=<%=password%>/><br>
		<br>
		Remember My ID <input name="rememberMe" type="checkbox">&nbsp;&nbsp;
		<input type="submit" value="Log-In" id="loginButton"/>
	</div>
	
	<footer id="loginFooter">
		<a href="">Forgot Username</a>&nbsp;&nbsp;<a href="">Forgot Password</a>
	</footer>
</form>

<%
String mess = (String)request.getAttribute("message");

if(mess != null){
	if(mess.equals("incorrect")){
%>
		<br><br><h5 align="center">Incorrect Username/Password!</h5>
<%
	}
}
%>
</body>
</html>