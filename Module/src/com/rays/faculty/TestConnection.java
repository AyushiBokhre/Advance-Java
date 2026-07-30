package com.rays.faculty;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {
	public static void main(String[] args) throws Exception {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

			System.out.println("Connection established Successfully...");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			conn.rollback();
		} finally {
			conn.close();
		}

	}

}
