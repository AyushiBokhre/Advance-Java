package com.rays.statement.department;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestUpdate {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
		
		System.out.println("Connection established Successfully...");
		
		Statement stmt =conn.createStatement();
		
		int i =stmt.executeUpdate("update Department set location='Block B' where departmentId=1");
		
		System.out.println("Record updated: "+i+" rows affected");
	

		
	}


}
