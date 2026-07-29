package com.rays.department;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestInsert {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
		
		System.out.println("Connection established Successfully...");
		
		Statement stmt =conn.createStatement();
		
		int i =stmt.executeUpdate("INSERT INTO Department VALUES(1, 'Computer Science', 'Dr. Sharma', 35, 'Block A'),(2, 'Mechanical', 'Dr. Verma', 28, 'Block B'),(3, 'Electrical', 'Dr. Gupta', 30, 'Block C'),(4, 'Civil', 'Dr. Singh', 25, 'Block D'),(5, 'Electronics', 'Dr. Mishra', 22, 'Block E')");
		
		System.out.println("Record Inserted: "+i+" rows affected");
	

		
	}

}
