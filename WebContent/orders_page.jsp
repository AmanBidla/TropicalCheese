<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Orders</title> 
<%@ page import="java.util.*" %> 
<%@ page import="com.nnamdyjunior.tropicalcheese.Orders" %>
<script type="text/javascript" src="scripts.js"></script>
<link rel="stylesheet" type="text/css" href="orderStyle.css">
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


<br>

<div id="filters">
	Order Date: <select>
		  <option value="Today">Today</option>
		  <option value="This Week">This Week</option>
		  <option value="Last Week">Last Week</option>
		  <option value="This Month">This Month</option>
	</select>&nbsp;
	Customer ID: <input onkeydown="if (event.keyCode == 13) {filterItems();}" id="customerID" type="text"/>&nbsp;
	Customer Name: <input onkeydown="if (event.keyCode == 13) {filterItems();}" id="customerName" type="text"/>&nbsp; 
	Sales Manager: <input onkeydown="if (event.keyCode == 13) {filterItems();}" id="salesManager" type="text"/>
</div>
<br>

<table id="ordersTable" border="-">

	<tr id="ordersHeader">
		<td>Tracking #</td><td>Date</td><td>Customer ID</td><td>Customer Name</td><td>Address</td><td>Route #</td><td>Available Actions</td>
	</tr>

<%
ArrayList<Orders> ordList = (ArrayList<Orders>)getServletContext().getAttribute("orders");
for(Orders ord : ordList){
	%>
	<tr>
		<td><input onkeydown="if (event.keyCode == 13) {toServlet('<%=ord.getTrackingNumber()%>');}" name=<%=(String)ord.getTrackingNumber()%> type="text" disabled="disabled" value=<%=ord.getTrackingNumber()%>></td>
		<td><input onkeydown="if (event.keyCode == 13) {toServlet('<%=ord.getTrackingNumber()%>');}" name=<%=(String)ord.getTrackingNumber()%> type="text" disabled="disabled" value=<%=ord.getDate()%>></td>
		<td><input onkeydown="if (event.keyCode == 13) {toServlet('<%=ord.getTrackingNumber()%>');}" name=<%=(String)ord.getTrackingNumber()%> type="text" disabled="disabled" value=<%=ord.getCustomerID()%>></td>
		<td><input onkeydown="if (event.keyCode == 13) {toServlet('<%=ord.getTrackingNumber()%>');}" name=<%=(String)ord.getTrackingNumber()%> type="text" disabled="disabled" value=<%=ord.getCustomerName()%>></td>
		<td><input onkeydown="if (event.keyCode == 13) {toServlet('<%=ord.getTrackingNumber()%>');}" name=<%=(String)ord.getTrackingNumber()%> type="text" disabled="disabled" value=<%=ord.getAddress()%>></td>
		<td><input onkeydown="if (event.keyCode == 13) {toServlet('<%=ord.getTrackingNumber()%>');}" name=<%=(String)ord.getTrackingNumber()%> type="text" disabled="disabled" value=<%=ord.getRouteNum()%>></td>
		<td>
			<a onclick="viewDetails('<%=ord.getTrackingNumber()%>')">View</a>&nbsp;<a onclick="inLineEdit('<%=ord.getTrackingNumber()%>')">Edit</a>&nbsp;<a onclick="deleteItem('<%=ord.getTrackingNumber()%>')">Delete</a>
		</td>
	</tr>
<% 
}
%>
</table>
 
</body>
</html>













