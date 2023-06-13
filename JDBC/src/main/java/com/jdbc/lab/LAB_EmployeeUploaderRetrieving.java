package com.jdbc.lab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.jdbc.DatabaseConnection;

public class LAB_EmployeeUploaderRetrieving {
	public static void retrieveEmployeeDetails(int Emp_Id) 
	{
        
		try(Connection con=DatabaseConnection.getDbConnection();
				//Scanner sc = new Scanner(System.in))
		
             PreparedStatement stmt = con.prepareStatement(
                     "SELECT e.Emp_Id, e.Emp_Name, e.Emp_Contact_No, e.Emp_Address, d.Dept_Name, d.Dept_Head " +
                     "FROM LAB_EmployeeUploader e " +
                     "JOIN LAB_DeptartmentTable d ON e.Dept_Id = d.Dept_Id " +
                     "WHERE e.Emp_Id = ?")) 
		{
            stmt.setInt(1, Emp_Id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) 
            {
                System.out.println("Employee Details:");
                System.out.println("Employee Id: " + rs.getInt("Emp_Id"));
                System.out.println("Employee Name: " + rs.getString("Emp_Name"));
                System.out.println("Employee Contact Number: " + rs.getString("Emp_Contact_No"));
                System.out.println("Employee Address: " + rs.getString("Emp_Address"));
                System.out.println("Department Name: " + rs.getString("Dept_Name"));
                System.out.println("Department Head: " + rs.getString("Dept_Head"));
            } 
            else 
            {
                System.out.println("Employee Id not Present");
            }
        } 
		catch (SQLException e) 
		{
            e.printStackTrace();
        }
    }

	public static void main(String[] args) 
	{
	    
	    // Retrieve employee details by employee ID
	    retrieveEmployeeDetails(103); // Replace 123 with the desired employee ID
	    
	  
	}
}

