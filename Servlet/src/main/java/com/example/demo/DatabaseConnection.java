package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	public static Connection getDBConnection( )  
	{
		Connection conn =null;
		try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		// database connection string
		// constants
	    conn = DriverManager.getConnection
	    		("jdbc:mysql://localhost:3306/online_shopping","root","rootJEE"); 
		  return conn;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
}
