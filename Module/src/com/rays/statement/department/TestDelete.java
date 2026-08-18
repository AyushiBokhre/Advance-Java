package com.rays.statement.department;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestDelete {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
		
		System.out.println("Connection established Successfully...");
		
		Statement stmt =conn.createStatement();
		
		int i =stmt.executeUpdate("delete from department where departmentId=3");
		
		System.out.println("Record Deleted: "+i+" rows affected");
	

		
	}


}
