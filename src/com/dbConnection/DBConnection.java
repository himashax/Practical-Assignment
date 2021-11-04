package com.dbConnection;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {
	
	public static Connection getConnection() {
		
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Get connection
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/practical", "root", "");
			System.out.println("successfully connected");
			
		}catch (SQLException|ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//Returns connection
		return connection;
	}
	
}
