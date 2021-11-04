package com.dao;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.Model.Country;
import com.dbConnection.DBConnection;

public class CountryDAO {
	
	private DBConnection dbConnection = new DBConnection();
	
	public double calGDPGrowthRate(Country country) {
			
			//Connect to the database
			Connection connection = DBConnection.getConnection();
			
			//SQL query to retrieve GDP values
			String GDPValues = "SELECT value FROM `gdp` WHERE CountryCode='"+country.getCode()+"' and Year in('"+country.getYear1()+"', '"+country.getYear2()+"')";
			
			ArrayList<Integer> values = new ArrayList<Integer>();
			try {
				
				Statement st = connection.createStatement();
				
				//Create ResultSet object to get database result set and execute SQL query
				ResultSet rs = st.executeQuery(GDPValues);
			
				//Search through the rows in the result set
				while (rs.next()) {
				        int result = rs.getInt(1); 
				        values.add(result);
				    }
				
				//Disconnect from the database
				connection.close();
				
			} catch (SQLException|NullPointerException e) {
				e.printStackTrace();
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			int valueOfYear1 = values.get(0);
			int valueOfYear2 = values.get(1);
			
			//calculation for GDP growth rate
			double rate = (valueOfYear2-valueOfYear1)/(double)valueOfYear1;
			
			return rate;
		} 
	
	}
