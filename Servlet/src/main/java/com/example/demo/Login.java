package com.example.demo;

import javax.servlet.ServletConfig;
import java.sql.Connection;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 

@WebServlet("/login")
public class Login extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) {

		// 1.2.3.4
		if(req.getRemoteAddr() == "1.2.3.4")
			return;

		String uid = req.getParameter("userid");
		String pwd = req.getParameter("password");
		System.out.println( req.getQueryString() );
		
		UsersTable ut=new UsersTable();
		Connection conn=DatabaseConnection.getDBConnection();
		try {
				ut.registerUser(uid, pwd, conn);
				 
				{
					//res.getWriter().write(" login is successful "); // text format response
					/*
		@@ -47,9 +51,15 @@ public void doGet(HttpServletRequest req, HttpServletResponse res) {
					req.getRequestDispatcher("error.jsp").forward(req, res);
					*/
				}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
