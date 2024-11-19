package com.royal.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import bean.StudentBean;
import util.DBConnection;

public class StudentDao 
{
    public int insertStudent(StudentBean sbean) 
    {
		String insertQuery = "INSERT INTO student (name, std, marks) VALUES ('"+sbean.getName()+"', "+sbean.getStd()+", "+sbean.getMarks()+")";
        
		Connection conn = DBConnection.getConnection();
        Statement stmt = null;
        
        int rowsAffected = 0;
        
        if(conn != null)
        {
        	try 
        	{
        		stmt = conn.createStatement();
        		
        		rowsAffected = stmt.executeUpdate(insertQuery);
        		
        	} catch (SQLException e) {
        		System.err.println("Error inserting student record: " + e.getMessage());
        		e.printStackTrace();
        	}
        }
        else {
        		System.out.println("StudentDao --insertStudent()----Db not connected");
        }
        return rowsAffected;
    }
	    public int updateStudent(StudentBean sbean, int rno) 
	    {

	    	String updateQuery = "UPDATE student SET name= '"+sbean.getName()+"', std="+sbean.getStd()+", marks="+sbean.getMarks()+")";
	    	System.out.println("updateQuery: " + updateQuery);
	    	Statement stmt= null;
	    	Connection conn = DBConnection.getConnection();

	    	int rowsAffected = 0;
	    	if (conn!=null)
	    	{
	    		try
	    		{
	    			stmt= conn.createStatement();
	    			rowsAffected = stmt.executeUpdate(updateQuery);
	    		} catch (Exception e)
	    		{
	    			e.printStackTrace();
	    		}
	    	} else
	    	{	    	
	    		System.out.println("Db not connected");
	    	}
	    	
	        return rowsAffected;
	    }
	    
	    

	    public int deleteStudent(int rno) 
	    {
			String deleteQuery = "DELETE FROM student WHERE rno= " + rno;
	    	
	    	Connection conn = DBConnection.getConnection();
	    	Statement stmt = null;
	    	
	    	int rowsAffected = 0; 
	    	if (conn!=null)
	    	{
	    		try
	    		{
	    			stmt = conn.createStatement();
	    			rowsAffected = stmt.executeUpdate(deleteQuery);
	    		} catch (SQLException e)
	    		{
	    			e.printStackTrace();
	    		}
	    		
	    	} else
	    	{
		    	System.out.println("Dnb not connected :" + conn);	    		
	    	}
	    	
	    	return rowsAffected;
	    }
	
//	    public static void main(String[] args) 
//	    {
////	    	--------------Insert Student -------------------
//	        Scanner sc = new Scanner(System.in);
//	        System.out.println("Enter Name: ");
//	        String name = sc.nextLine();    
//	        System.out.println("Enter Std: ");
//	        int std = sc.nextInt();
//	        System.out.println("Enter Marks: ");
//	        int marks = sc.nextInt();
//	        StudentBean sbean = new StudentBean(0, name, std, marks);
//	        
//	    	
//	    	
//	    	int rowsAffected = dao.insertStudent(sbean);	
//	           
//	        if (rowsAffected > 0) 
//	        {
//	                System.out.println("Student record successfully inserted. Rows affected: " + rowsAffected);
//	        } else 
//	        {
//	        	System.out.println("Failed to insert student record. Rows affected: " + rowsAffected);
//	        }
//	    }

// --------------------------------------------------------------------------------------------------------------
	    
//	    	----------------Delete Student -------------------
//	    public static void main(String[] args) 
//	    {	    	
//	    	
//	    	Scanner sc = new Scanner(System.in);
//	    	System.out.println("Enter the Roll No Which u want to delete :");
//	        
//	    	int rno = sc.nextInt();
//	    	
//	    	StudentDao dao = new StudentDao();
//	        	
//	    	int rowsAffected = dao.deleteStudent(rno);
//	           
//	        if (rowsAffected > 0) 
//	        {
//	                System.out.println("Student record successfully Deleted : " + rowsAffected);
//	        } else 
//	        {
//	        	System.out.println("Student record not Deleted: " + rowsAffected);
//	        }  
//	    }

// --------------------------------------------------------------------------------------------------------------
	    
//    	----------------Update Student -------------------
//    public static void main(String[] args) 
//    {	    	
//    	Scanner sc = new Scanner(System.in);
//    	System.out.println("Enter Rno which you want to update : "); 
//
//    	int rno = sc.nextInt(); 
//    	sc.nextLine();
//    	System.out.println("Enter Name: "); 
//    	String name = sc.nextLine(); 
//    	System.out.println("Enter Std : "); 
//    	int std = sc.nextInt();
//    	System.out.println("Enter Marks: ");
//    	int marks = sc.nextInt();
//    	
//    	StudentBean sbean = new StudentBean(0, name, std, marks); 
//    	StudentDao dao = new StudentDao();
//    	
//    	int rowsAffected = dao.updateStudent (sbean, rno);
//    	
//    	if (rowsAffected > 0)
//    	{
//    		System.out.println("Student record successfully updated : " + rowsAffected);
//    	} else
//    	{
//    		System.out.println("Student record not updated : "+rowsAffected);
//    	}
//    	  
//    }

	    public ArrayList<StudentBean> getAllRecords()
	    {

	    	String selectQuery = "SELECT rno, name, std, marks FROM student"; 
	    	ArrayList<StudentBean> list = new ArrayList<StudentBean>(); 
	    	StudentBean sbean= null;
	    	Connection conn = DBConnection.getConnection();
	    	Statement stmt = null;
	    	ResultSet rs = null; 
	    	if (conn != null)
	    	{
	    		try
	    		{
	    			stmt = conn.createStatement();
	    			
	    			rs = stmt.executeQuery(selectQuery);
	    			
	    			while(rs.next())
	    			{
	    				int rno = rs.getInt(1);
	    				String name = rs.getString(2);
	    				int std= rs.getInt(3);
	    				int marks = rs.getInt(4);
	    	
	    				sbean = new StudentBean(rno, name, std, marks); 
	    				list.add(sbean);
	    			}
	    		}catch (SQLException e)
	    		{
	    			e.printStackTrace();
	    		}
	    	} else
	    	{
	    		System.out.println("Db not connected ");
	    	}
	    	return list;
	    	
	    }
	    
// --------------------------------------------------------------------------------------------------------------
	    
//    	----------------Select Student -------------------
	    

	    public static void main(String[] args)
	    {
	    	
	    	StudentDao dao = new StudentDao();
	    	ArrayList<StudentBean> list = dao.getAllRecords();

	    	System.out.println("Total Rows: " + list.size());
	    	
	    	for (int i = 0; i < list.size(); i++)
	    	{
	    		StudentBean s = list.get(i);
	    		
	    		System.out.println(s.getRno()+" " +s.getName()+" " +s.getStd()+" " + s.getMarks());
	    	}

	    }	
}