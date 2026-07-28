package com.rays.college;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestSearch {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
		
		Statement stmt=conn.createStatement();
		
		ResultSet rs =stmt.executeQuery("select * from college");
		
		while(rs.next()) {
			System.out.println("College ID: "+ rs.getInt("collegeId"));
			System.out.println("College Name: "+rs.getString("collegeName"));
			System.out.println("City: "+rs.getString("city"));
			System.out.println("University: "+rs.getString("university"));
			System.out.println("Contact No.:"+rs.getInt("contactNo"));
			System.out.println();
			System.out.println("-----------------------");
			System.out.println();
		}
	}

}
