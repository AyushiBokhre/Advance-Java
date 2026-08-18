package com.rays.statement.department;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestCreate {
	public static void main(String[] args) throws Exception {
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
			
			conn.setAutoCommit(false);
			
			Statement stmt =conn.createStatement();
			
			int i =stmt.executeUpdate("create table Department(departmentId int primary key ,departmentName varchar(45),hodName varchar(45),totalFaculty int, location varchar(45))");
			
			System.out.println("Table  created: "+i+" rows affected");
			
			conn.commit();
		
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			conn.rollback();
			
		}finally {
			conn.close();
		}

		
	}

}
