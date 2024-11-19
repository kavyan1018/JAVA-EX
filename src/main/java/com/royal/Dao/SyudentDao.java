package com.royal.Dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.SQLException;

import util.DBConnection;

public class SyudentDao {

	private int instrtStudent() 
	{
	
		String insterQuery = "INSTER INTO student(name, std, marks) Value('Kavyan', 1, 100)";
		Connection conn = DBConnection.getConnection();
		Statement stmt = null;
		int rowsAffected = 0;
		
		
		if (conn != null) 
		{
			try {
				
				stmt = (Statement) conn.createStatement();
//				rowsAffected = ((Object) stmt).executeUpadte(insterQuery);
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}else {
			System.out.println("StudentDao --insertStudent() ----Db not connected");
		}
		
		return rowsAffected;
		
	}
	
}
