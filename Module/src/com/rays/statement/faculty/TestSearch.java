package com.rays.statement.faculty;

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
		
		ResultSet rs=stmt.executeQuery("select * from faculty");
		
		while(rs.next()) {
			System.out.println("Id: "+rs.getInt("facultyId"));
			System.out.println("Name: "+rs.getString("facultyName"));
			System.out.println("Subject: "+rs.getString("subject"));
			System.out.println("Qualification: "+rs.getString("qualification"));
			System.out.println("Experience: "+rs.getInt("experience"));
			System.out.println("----------------------------------");
			System.out.println();
		}
	

		
	}


}
