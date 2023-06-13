package com.jdbc.lab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.jdbc.DatabaseConnection;

public class LAB_EmployeeUploader 
{
	//inset or update department details
	 public static void storeDepartmentDetails(int Dept_Id, String Dept_Name) 
	 {
			try(Connection con=DatabaseConnection.getDbConnection();
						Scanner sc = new Scanner(System.in))
			{
				String query= "insert into LAB_DeptartmentTable values(?,?)";
				
				PreparedStatement ps = con.prepareStatement(query);
				
				System.out.println("Enter Id");
				int id =sc.nextInt();
				
				sc.nextLine();
				System.out.println("Enter Name");
				String name =sc.nextLine();
								
				ps.setInt(1, Dept_Id);
				ps.setString(2, Dept_Name);
				
				int r = ps.executeUpdate();
				System.out.println(r+"Record inserted sucessfully...");			
			}
		
			catch(Exception e)
			{
				System.out.println(e);
			}
	 }
	 
	 //insert or update employee details 
	    public static void storeEmployeeDetails(int Emp_Id, String Emp_Name, String Emp_Address, int Emp_Salary, String Emp_Contact_No, int Dept_Id)
	    {		 
	    	try(Connection con=DatabaseConnection.getDbConnection();
				Scanner sc = new Scanner(System.in))
	    	{
	    		String query= "insert into LAB_EmployeeTable values(?,?,?,?,?,?)";
		
	    		PreparedStatement ps = con.prepareStatement(query);
	    		
	    		System.out.println("Enter Employee Id:");
	    		int Emp_id =sc.nextInt();
		
	    		sc.nextLine();
	    		System.out.println("Enter Employee Name:");
	    		String Emp_name =sc.nextLine();
		
	    		System.out.println("Enter Employee Address:");
	    		String Emp_address =sc.nextLine();
	    		
	    		System.out.println("Enter Employee salary:");
	    		int Emp_salary =sc.nextInt();
		
	    		System.out.println("Enter Employee contact no:");
	    		int Emp_Contact_No1 =sc.nextInt();
		
	    		System.out.println("Enter Employee Department Id:");
	    		int Dept_id =sc.nextInt();
						
	    		ps.setInt(1, Emp_Id);
	    		ps.setString(2, Emp_Name);
	    		ps.setString(3, Emp_Address);
	    		ps.setInt(4, (int) Emp_Salary);
	    		ps.setInt(5, Emp_Contact_No1);
		
	    		int r = ps.executeUpdate();
	    		System.out.println(r+"Record inserted sucessfully...");		
	    	}
	    
	    catch(Exception e)
	    {
		System.out.println(e);
	    } 
}
}
//}
