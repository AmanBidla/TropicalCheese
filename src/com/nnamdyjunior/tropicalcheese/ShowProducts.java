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
 * Servlet implementation class ShowProducts
 */
@WebServlet("/ShowProducts")
public class ShowProducts extends HttpServlet {
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
			
				ResultSet rs = DatabaseQueries.getProducts();
				
				ArrayList<Products> prodList = new ArrayList<>();
				
				while(rs.next()) {
					Products prod = new Products();
					prod.setItemNum(rs.getInt(1));
					prod.setItemDesc(rs.getString(2));
					prod.setPrePrice(rs.getString(3));
					prod.setSize(rs.getString(4));  
					prodList.add(prod);
				}
				
				//rd = request.getRequestDispatcher("orders_page.jsp");
				getServletContext().setAttribute("products", prodList); 
				response.sendRedirect("products_page.jsp"); 
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
