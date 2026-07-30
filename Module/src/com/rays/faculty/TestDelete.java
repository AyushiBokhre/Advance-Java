package com.rays.faculty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestDelete {
	public static void main(String[] args) throws Exception {
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

			conn.setAutoCommit(false);

			Statement stmt = conn.createStatement();

			int i = stmt.executeUpdate("delete from faculty where facultyId=105");

			System.out.println("Record Deleted: " + i + " rows affected");

			conn.commit();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			conn.rollback();

		} finally {
			conn.close();
		}
	}

}
