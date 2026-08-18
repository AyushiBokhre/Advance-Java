package com.rays.statement.faculty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestCreate {
	public static void main(String[] args) throws Exception {
		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

			conn.setAutoCommit(false);

			Statement stmt = conn.createStatement();

			int i = stmt.executeUpdate(
					"create table Faculty(facultyId int primary key ,facultyName varchar(45),subject varchar(45),	qualification varchar(45),experience int )");

			System.out.println("Table  created: " + i + " rows affected");

			conn.commit();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			conn.rollback();

		} finally {
			conn.close();
		}

	}

}
