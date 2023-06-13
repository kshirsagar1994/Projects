package com.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Scanner;

public class FetchEmpDetails 
{
	public static void main(String[] args) 
	{
		
		try(Connection con=DatabaseConnection.getDbConnection();
				Scanner sc = new Scanner(System.in))
		{			
			String query = "select * from employee where id=?";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			System.out.println("Enter id:");
			int id=sc.nextInt();
			
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				System.out.println("employee id:"+rs.getInt(1));
				System.out.println("employee name:"+rs.getString(2));
				System.out.println("employee email:"+rs.getString("email"));
				System.out.println("employee salary:"+rs.getInt("salary"));
				System.out.println("=====================================");	
			}
		}
		
		catch(SQLException e)
		{
			System.out.println(e);
		}
		
	}
	

}
