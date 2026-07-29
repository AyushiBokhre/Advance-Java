package com.rays.jdbc.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestTransactionHandling {
	public static void main(String[] args) throws Exception {
		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");

			conn.setAutoCommit(false);

			Statement stmt = conn.createStatement();

			int i = stmt.executeUpdate(
					"INSERT INTO st_user values (16, 'Sneha', 'Prajapati', 'Sneha11@gmail.com', 'pass1234', '2004-05-05')");
			
			i = stmt.executeUpdate(
					"INSERT INTO st_user values (17, 'Mahak', 'Bokhre', 'mahak15@gmail.com', 'pass1703', '2003-03-17')");

			System.out.println("record inserted :" + i + " rows affected");

			conn.commit();

		} catch (Exception e) {
			
			System.out.println("Eception: " + e.getMessage());
			
			conn.rollback();
			
		} finally {
			
			conn.close();
		}

	}

}
