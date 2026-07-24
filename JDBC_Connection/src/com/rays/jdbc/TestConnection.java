package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {
	public static void main(String[] args) throws Exception {
		
		//Step1. load Driver class into the class Loader.
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
		System.out.println("Connection established successfully..."+conn.getCatalog());
	}

}
