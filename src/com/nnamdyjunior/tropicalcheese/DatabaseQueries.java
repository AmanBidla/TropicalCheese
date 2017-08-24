package com.nnamdyjunior.tropicalcheese;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;

public class DatabaseQueries {

	private static DataSource dataSource = null; 
	private static Connection connection;
	private static Statement statement;
	private static PreparedStatement preparedStatement1, preparedStatement2, preparedStatement3;
	private static ResultSet resultSet;
	
	public static void init() {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context)initContext.lookup("java:/comp/env");
			dataSource = (DataSource)envContext.lookup("jdbc/RealMadrid");
			connection = dataSource.getConnection();
		    	statement = connection.createStatement();
		    	preparedStatement1 = connection.prepareStatement("select * from Managers where username=?"
		    			+ " and password=?");
		    	preparedStatement2 = connection.prepareStatement("update Orders set dateSent=?, customerID=?, "
		    			+ "customerName=?, address=?, routeNum=? where trackingNum=?");
		    	preparedStatement3 = connection.prepareStatement("delete from Orders where trackingNum=?");
		    	connection.setAutoCommit(false); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ResultSet getOrders() {
		
		try {
			resultSet = statement.executeQuery("select * from Orders");
			
			return resultSet;
		}catch(Exception e) { return null; }
	}
	
	public static ResultSet getProducts() {
		
		try {
			resultSet = statement.executeQuery("select * from Products");
			
			return resultSet;
		}catch(Exception e) { return null; }
	}
	
	public static int loginValidation(String user, String pass) {
		init();
		
		try {
			preparedStatement1.setString(1, user);
			preparedStatement1.setString(2, pass); 
			resultSet = preparedStatement1.executeQuery();
			connection.commit();
			
			if(resultSet.next()) {
				return 1;
			}
			else {
				return 0;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public static void makeChanges(Orders ord) {
		try {
			preparedStatement2.setString(1, ord.getDate());
			preparedStatement2.setLong(2, ord.getCustomerID());
			preparedStatement2.setString(3, ord.getCustomerName());
			preparedStatement2.setString(4, ord.getAddress());
			preparedStatement2.setInt(5, ord.getRouteNum());
			preparedStatement2.setString(6, ord.getTrackingNumber());
			preparedStatement2.executeUpdate();
			connection.commit(); 
		}catch(Exception e) { e.printStackTrace(); }
	}
	
	public static void delete(Orders ord) {
		try {
			preparedStatement3.setString(1, ord.getTrackingNumber());
			preparedStatement3.executeUpdate();
			connection.commit(); 
		}catch(Exception e) { e.printStackTrace(); }
	}
	
	public static ResultSet getFilteredorders(String qry) {
		try {
			String query = "select * from Orders where " + qry ;
			System.out.println(query);
			resultSet = statement.executeQuery(query);
			return resultSet;
		}catch(Exception ex) {
			return null;
		}
	}
}
