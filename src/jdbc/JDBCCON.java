package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCCON {

	String username;
	String password;
	public void jdbcConnection() 
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");


			Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "selenium");

			Statement statement =connection.createStatement();

			ResultSet rs=statement.executeQuery("Select * from  where emailid='jeet.jeet@gmail.com'");

			while (rs.next()) 
			{
				username=rs.getString("firstname");
				password=rs.getString("emailid");
				System.out.println(username+" "+password);
			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			System.out.println("Sorry for the inconviniance");
			
		}
	}


	public String getUsername()
	{
		return username;
	}

	public String getPass()
	{
		return password;
	}

}
