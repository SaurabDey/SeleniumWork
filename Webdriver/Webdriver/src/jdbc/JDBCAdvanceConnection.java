package com.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class JDBCAdvanceConnection 
{

	public static void main(String[] args) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","selenium");
		System.out.println("Connected");

		//-------------DatabaseMetaData gives all the information related to Database
		DatabaseMetaData dmt= con.getMetaData();
		System.out.println("Database version : "+dmt.getDatabaseMajorVersion());
		
		//-------------Statement- sql_query will be sent in executeUpdate line for execution
		Statement smt=con.createStatement();
		String sql_query="Insert into persistent values ('dey','dey@gmail.com')";
		smt.executeUpdate(sql_query);
		
		//--------------Statementbatch is possible
		smt.addBatch("Insert into persistent values ('d','d@gmail.com')");
		smt.addBatch("Insert into persistent values ('de','de@gmail.com')");
		smt.addBatch("Insert into persistent values ('dey2','dey2@gmail.com')");
		
		
		int[] noOfInsert=smt.executeBatch();
		System.out.println(noOfInsert.length);
		
		
		
		//---------------PreparedStatement- sql is in the same line where it is defined , setString feature is available
		String sql="Select * from persistent where firstname=?";
		PreparedStatement prsmt=con.prepareStatement(sql);
		prsmt.setString(1, "dey1");
		
		ResultSet rs=prsmt.executeQuery();
		
		//--------------ResultSetMetaData- gives information related to Result sets
		ResultSetMetaData rsmt= rs.getMetaData();
		System.out.println("Result set data : "+rsmt.getColumnCount());
		
		while (rs.next())
		{
			String fn=rs.getString("firstname");
			String ei=rs.getString("emailid");
			System.out.println(fn+"****"+ei);

		}
		
		//--------------Callable Statement- This helps in calling the Store Procedures
		String callSP="{call FirstSP(?,?)}";
		CallableStatement csmt= con.prepareCall(callSP);
		csmt.setString(1, "dey3");
		csmt.registerOutParameter(2, Types.VARCHAR);
		csmt.execute();
		
		System.out.println("Callable Statement : "+csmt.getString(2));
		
		

	}
}
