package com.rays.college;

import java.sql.Connection;
import java.sql.DriverManager;

public class CreateConnection {
	public static void main(String[] args ) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
		
		System.out.println("Connection established successfully....");
		
	}

}
