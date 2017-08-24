package com.nnamdyjunior.tropicalcheese;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Bridge2
 */
@WebServlet("/Bridge2")
public class Bridge2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String date = request.getParameter("date");
		String cusid = request.getParameter("cusid");
		String cusname = request.getParameter("cusname");
		String address = request.getParameter("address");
		String routenum = request.getParameter("routenum");
		
		Orders ord = new Orders();
		ord.setAddress(address); 
		ord.setCustomerID(Long.parseLong(cusid));
		ord.setCustomerName(cusname);
		ord.setDate(date);
		ord.setRouteNum(Integer.parseInt(routenum));
		ord.setTrackingNumber(id); 
		
		DatabaseQueries.delete(ord); 
		
		response.sendRedirect("./all_orders"); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
