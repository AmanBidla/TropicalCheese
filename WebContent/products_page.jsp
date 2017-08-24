<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Products</title>

<%@ page import="java.util.*" %> 
<%@ page import="com.nnamdyjunior.tropicalcheese.Products" %>
<script type="text/javascript" src="scripts.js"></script>
<link rel="stylesheet" type="text/css" href="productStyle.css">
</head>
<body>
<%
String username = (String)request.getSession().getAttribute("username");
String password = (String)request.getSession().getAttribute("password");

RequestDispatcher rd;

	if(username==null || password==null) {
		rd = request.getRequestDispatcher("index.jsp");
		request.setAttribute("message", "incorrect"); 
		rd.forward(request, response); 
	}
%>

<img alt="" src="header.png" id="headerImg">
<div id="tabButt">
	<form action="orders_page.jsp" method="post" id="ordersForm"><input type="submit" value="Orders" class="tabButton"/></form>
	<form action="./ShowProducts" method="post" id="productsForm"><input type="submit" value="Products" class="tabButton"/></form>
	<form action="" method="post" id="routesForm"><input type="submit" value="Routes" class="tabButton"/></form>
	<form action="./LogOut" method="post" id="logoutForm"><input type="submit" value="LOGOUT" class="tabButton"/></form>
</div>


	
<div class="sidebar">
	<div class="caption">Product Categories</div><br><br>
	<form action="" method="post"><input type="submit" value="Carribean Line" class="catButton"/></form>
	<form action="" method="post"><input type="submit" value="Central American Line" class="catButton"/></form>
	<form action="" method="post"><input type="submit" value="Mexican Line" class="catButton"/></form>
	<form action="" method="post"><input type="submit" value="Paisano Line" class="catButton"/></form>
	<form action="" method="post"><input type="submit" value="Domestic Items" class="catButton"/></form>
	<form action="" method="post"><input type="submit" value="Meats" class="catButton"/></form>
	<form action="" method="post"><input type="submit" value="Routes" class="catButton"/></form>
	<form action="" method="post"><input type="submit" value="Deserts" class="catButton"/></form>
	<form action="" method="post"><input type="submit" value="Others" class="catButton"/></form>
	<form action="" method="post"><input type="submit" value="Drinkable Yogurts" class="catButton"/></form>
	<form action="" method="post"><input type="submit" value="Arepas" class="catButton"/></form>
	<form action="" method="post"><input type="submit" value="Per Pound Items" class="catButton"/></form>
</div>

<table id="productsTable" border="-">

	<tr id="productsHeader">
		<td>Item #</td><td>Item Description</td><td>Pre-Price</td><td>Size</td>
	</tr>

<%
ArrayList<Products> prodList = (ArrayList<Products>)getServletContext().getAttribute("products");
for(Products prod : prodList){
	%>
	<tr>
		<td><%=prod.getItemNum()%></td><td><%=prod.getItemDesc()%></td><td><%=prod.getPrePrice()%></td><td><%=prod.getSize()%></td>
	</tr>
<% 
}
%>
</table>
 
</body>
</html>