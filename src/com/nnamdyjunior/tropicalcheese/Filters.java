package com.nnamdyjunior.tropicalcheese;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Filters
 */
@WebServlet("/Filters")
public class Filters extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String orderDate = request.getParameter("orderDate");
		String customerID = request.getParameter("customerID");
		String customerName = request.getParameter("customerName");
		String salesManager = request.getParameter("salesManager");
		
		List<String> res = new ArrayList<>();
		//if(orderDate != null && !orderDate.equals("")) res.add("dateSent like '"+orderDate+"%'");
		if(customerID != null && !customerID.equals("")) res.add("customerID like '"+customerID+"%'");
		if(customerName != null && !customerName.equals("")) res.add("customerName like '"+customerName+"%'");
		if(salesManager != null && !salesManager.equals("")) res.add("salesManager like '"+salesManager+"%'");
		
		String qry = res.get(0);
		
		for(int i=1; i<res.size(); i++) {
			qry += " and " + res.get(i);
		}
		
		try {
			ResultSet rs = DatabaseQueries.getFilteredorders(qry);
			
			ArrayList<Orders> ordersList = new ArrayList<>();
			
			while(rs.next()) {
				Orders ord = new Orders();
				ord.setTrackingNumber(rs.getString(1));
				ord.setDate(rs.getString(2));
				ord.setCustomerID(rs.getLong(3));
				ord.setCustomerName(rs.getString(4));
				ord.setAddress(rs.getString(5));
				ord.setRouteNum(rs.getInt(6)); 
				ordersList.add(ord);
			}
			
			//rd = request.getRequestDispatcher("orders_page.jsp");
			getServletContext().setAttribute("orders", ordersList); 
			response.sendRedirect("orders_page.jsp"); 
		}catch(Exception ex) {}
		
//		response.getWriter().println(qry);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
