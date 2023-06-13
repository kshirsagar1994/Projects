package com.jdbc.lab;

import java.sql.Connection;
import java.sql.Statement;

import com.jdbc.DatabaseConnection;

public class LAB_EmployeeTable {
public static void main(String[] args)  {
		
		//try with resource
		try(Connection conn = DatabaseConnection.getDbConnection())
		{
			//create the statement 
			Statement st = conn.createStatement();
			
			//write / create query
			String sql= "create table LAB_EmployeeTable(Emp_Id int primary key, Emp_Name varchar(20) not null, Emp_Address varchar(20) not null, "
					+ "Emp_Salary decimal(10, 2) not null, Emp_Contact_No int not null, Dept_Id int, FOREIGN KEY (Dept_Id) REFERENCES LAB_DeptartmentTable(Dept_Id))";
				          
					
			//execute the query
			st.executeUpdate(sql);
			System.out.println("Table created sucessfully...");
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}	
	}
}
