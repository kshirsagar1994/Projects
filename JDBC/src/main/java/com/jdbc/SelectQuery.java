package com.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class SelectQuery 
{
	public static void main(String[] args) 
	{
		try(Connection con=DatabaseConnection.getDbConnection())
		{
			Statement st=con.createStatement();
			
			String select ="select * from employee";
			
			ResultSet rs = st.executeQuery(select);
			
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
