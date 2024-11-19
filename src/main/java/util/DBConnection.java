package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private static final String URLNAME = "jdbc:mysql://localhost:3306/sys";
	private static final String DRIVERCLASS = "com.mysql.cj.jdbc.Driver";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	
	public static Connection getConnection() {
		
		Connection conn = null;
		
		try {
			
			Class.forName(DRIVERCLASS);
			
			conn = DriverManager.getConnection(URLNAME, USERNAME, PASSWORD);
			
		} catch (ClassNotFoundException e) 
		{
			e.printStackTrace();	
		}catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void main(String[] args) 
	{
		Connection conn = DBConnection.getConnection();
		
		if (conn!=null) 
		{
			System.out.println("Db Connected :" + conn);
		}
		else {
			System.out.println("Db Not Connected :" + conn);
		}
	}

}
