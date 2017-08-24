package com.nnamdyjunior.tropicalcheese;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

/**
 * Servlet implementation class LoginVeri
 */
@WebServlet("/LoginVeri")
public class LoginVeri extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginVeri() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		
		if(request.getParameter("rememberMe") != null) {
			Cookie cookie = new Cookie(username, password); 
			cookie.setMaxAge(1000 * 60 * 60); //request.getCookies();
			response.addCookie(cookie);
		}
		
		RequestDispatcher rd;
		int x = DatabaseQueries.loginValidation(username, password);
		
		try {
			if(x == 0) {
				rd = request.getRequestDispatcher("index.jsp");
				request.setAttribute("message", "incorrect"); 
				rd.forward(request, response); 
			}
			else {
				request.getSession().setAttribute("username", username);
				request.getSession().setAttribute("password", password);
				response.sendRedirect("./all_orders"); 
				
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
