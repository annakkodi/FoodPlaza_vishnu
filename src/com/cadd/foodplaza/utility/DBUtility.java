 package com.cadd.foodplaza.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBUtility 
{		
	public static Connection establishConnection() throws ClassNotFoundException, SQLException
	{	
		String url,user,pass;
		url = "jdbc:mysql://localhost:3306/foodplaza_vishnu";
		user = "root";
		pass = "Vs_vishnu@";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url,user,pass);
		return conn;
	}
}