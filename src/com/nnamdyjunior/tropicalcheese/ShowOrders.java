package com.nnamdyjunior.tropicalcheese;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowOrders
 */
@WebServlet("/all_orders")
public class ShowOrders extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		String username = (String)request.getSession().getAttribute("username");
		String password = (String)request.getSession().getAttribute("password");
		
		RequestDispatcher rd;
		
		try {
			if(username==null || password==null) {
				rd = request.getRequestDispatcher("index.jsp");
				request.setAttribute("message", "incorrect"); 
				rd.forward(request, response); 
			}
			else {
				ResultSet rs = DatabaseQueries.getOrders();
				
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
			}
		}catch(Exception ex) {}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

