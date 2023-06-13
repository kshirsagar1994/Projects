package com.jdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.Scanner;

public class InsertRecordUsingPS 
{
	public static void main(String[] args) 
	{
		try(Connection con=DatabaseConnection.getDbConnection();
					Scanner sc = new Scanner(System.in))
		{
			String query= "insert into employee values(?,?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			System.out.println("Enter Id");
			int id =sc.nextInt();
			
			sc.nextLine();
			System.out.println("Enter Name");
			String name =sc.nextLine();
			
			System.out.println("Enter email");
			String mail =sc.nextLine();
			
			System.out.println("Enter salary");
			int sal = sc.nextInt();
			
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, mail);
			ps.setInt(4, sal);
			
			int r = ps.executeUpdate();
			System.out.println(r+"Record inserted sucessfully...");
					
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
