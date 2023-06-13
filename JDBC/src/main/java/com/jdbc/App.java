package com.jdbc;

import java.sql.Connection;

public class App 
{
    public static void main( String[] args )
    {
    	Connection conn=DatabaseConnection.getDbConnection();
    	System.out.println(conn);
    }
}
