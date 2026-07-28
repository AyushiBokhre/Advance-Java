package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestUpdate {
public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		 
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
		 
		Statement stmt = conn.createStatement();
		
		int i =stmt.executeUpdate("update st_user set firstname='Kashish',loginId='kashish@gmail.com',password='pass1112' where id =14");
		
		System.out.println("record updated :" + i + " rows affected");
		
	}

}
