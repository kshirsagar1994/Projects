package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertRecordEx 
{
	public static void main(String[] args) 
	{	
		try(Connection con=DatabaseConnection.getDbConnection())
		{
			//class.forName("com.mysql.cj.jdbc.Driver");
			//Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/anp4778","root","1234");
			
			Statement stm=con.createStatement();
			
			String query="insert into employee value(101,'Ajay','ajay@gmail.com',50000),"
													+"(102,'Aishwarya','aishwarya@gmail.com',40000)";
			
			int row=stm.executeUpdate(query);
			
			System.out.println(row+"record inserted sucessfully...");
			
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
	}
	

}
