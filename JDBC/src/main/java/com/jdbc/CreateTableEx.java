package com.jdbc;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class CreateTableEx {
	
	public static void main(String[] args)  {
		
		//try with resource
		try(Connection conn = DatabaseConnection.getDbConnection())
		{
			//create the statement 
			Statement st = conn.createStatement();
			
			//write / create query
			String sql= "create table employee(id int primary key, name varchar(20) not null, "+" email varchar(30) unique, salary int not null)";
			
			//execute the query
			st.executeUpdate(sql);
			System.out.println("Table created sucessfully");
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

}
