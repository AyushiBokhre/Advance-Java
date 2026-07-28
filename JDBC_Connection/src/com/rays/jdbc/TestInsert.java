package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestInsert {
public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		 
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
		 
		Statement stmt = conn.createStatement();
		
		int i =stmt.executeUpdate("INSERT INTO st_user values (13, 'Sneha', 'Prajapati', 'Sneha11@gmail.com', 'pass1234', '2004-05-05'),(14, 'Nandini', 'Dubey', 'nandini12@gmail.com', 'pass1141', '2003-09-12')");
		
		System.out.println("record inserted :" + i + " rows affected");
		
	}

}
