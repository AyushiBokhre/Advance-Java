package com.rays.statement.department;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestSearch {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
		
		System.out.println("Connection established Successfully...");
		
		Statement stmt =conn.createStatement();
		
		ResultSet rs=stmt.executeQuery("select* from department");
		
		while(rs.next()) {
			System.out.println("Id: "+rs.getInt("departmentId"));
			System.out.println("Department Name: "+rs.getString("departmentName"));
			System.out.println("Hod Name: "+rs.getString("hodName"));
			System.out.println("Total Faculty: "+rs.getInt("totalFaculty"));
			System.out.println("Location: "+rs.getString("location"));
			System.out.println("----------------------------------");
			System.out.println();
		}
	

		
	}


}
