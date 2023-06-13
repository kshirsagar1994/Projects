package com.jdbc.lab;

import java.sql.Connection;
import java.sql.Statement;

import com.jdbc.DatabaseConnection;

public class LAB_DeptartmentTable {
public static void main(String[] args)  {
		
		//try with resource
		try(Connection conn = DatabaseConnection.getDbConnection())
		{
			//create the statement 
			Statement st = conn.createStatement();
			
			//write / create query
			String sql= "create table LAB_DeptartmentTable(Dept_Id int primary key, Dept_Name varchar(20) not null, Dept_Head varchar(20) not null,Dept_description varchar(50) not null)";
			
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
