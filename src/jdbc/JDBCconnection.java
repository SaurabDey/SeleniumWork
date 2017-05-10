package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCconnection 
{

	public static void main(String[] args) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","selenium");
		System.out.println("Connected");

		//con.setAutoCommit(false);
		
		Statement smt=con.createStatement();
		//insert
//		int insert=smt.executeUpdate("Insert into persistent values ('dey','dey@gmail.com')");
//
//		insert=smt.executeUpdate("Insert into persistent values ('saurab','saurab.jeet@gmail.com')");
//		System.out.println(insert);
//
//		//con.commit();
//		
//		//update
//		int update=smt.executeUpdate("update persistent set firstname='Saurab' where emailid='saurab.jeet@gmail.com'");
//		System.out.println(update);

		//select
		ResultSet rs=smt.executeQuery("update persistent set firstname='Jeet1' where emailid='jeet.jeet@gmail.com'");
		
		
		while (rs.next())
		{
			String fn=rs.getString("firstname");
			String ei=rs.getString("emailid");
			System.out.println(fn+"****"+ei);

		}

		//delete
//		smt.executeUpdate("Delete from persistent where emailid='saurab.jeet@gmail.com'");

		//con.rollback();
	}
}
