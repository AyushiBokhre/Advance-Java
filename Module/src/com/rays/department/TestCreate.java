package com.rays.department;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestCreate {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
		
		System.out.println("Connection established Successfully...");
		
		Statement stmt =conn.createStatement();
		
		int i =stmt.executeUpdate("create table Department(departmentId int primary key ,departmentName varchar(45),hodName varchar(45),totalFaculty int, location varchar(45))");
		
		System.out.println("Table  created: "+i+" rows affected");
	

		
	}

}
