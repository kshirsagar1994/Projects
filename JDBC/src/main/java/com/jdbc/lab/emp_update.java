package com.jdbc.lab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.jdbc.DatabaseConnection;

public class emp_update 
{
	public static void storeDepartmentDetails(int departmentId, String departmentName)
	{
		try(Connection con=DatabaseConnection.getDbConnection();
				//Scanner sc = new Scanner(System.in))
		
             PreparedStatement stmt = con.prepareStatement("INSERT INTO LAB_DeptartmentTable (Department_Id, Department_Name) VALUES (?, ?)")) 
		{
            stmt.setInt(1, departmentId);
            stmt.setString(2, departmentName);
            stmt.executeUpdate();
            
            System.out.println("Department details stored successfully!");
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }

    public static void storeEmployeeDetails(int employeeId, String employeeName, String employeeAddress, double employeeSalary,
                                            String employeeContactNo, int departmentId) 
    {
    	try (Connection con = DatabaseConnection.getDbConnection();
                PreparedStatement stmt = con.prepareStatement("INSERT INTO LAB_EmployeeTable (Employee_Id, Employee_Name, Employee_Address, Employee_Salary, Employee_Contact_No, Department_Id) VALUES (?, ?, ?, ?, ?, ?)")) {
               stmt.setInt(1, employeeId);
               stmt.setString(2, employeeName);
               stmt.setString(3, employeeAddress);
               stmt.setDouble(4, employeeSalary);
               stmt.setString(5, employeeContactNo);
               stmt.setInt(6, departmentId);
               stmt.executeUpdate();
               
               System.out.println("Employee details stored successfully!");
           } 
    		catch (SQLException e) 
    		{
               e.printStackTrace();
           }
       }
 }
