package com.rays.statement.faculty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestInsert {
	public static void main(String[] args) throws Exception {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

			conn.setAutoCommit(false);

			Statement stmt = conn.createStatement();

			int i = stmt.executeUpdate(
					"INSERT INTO Faculty VALUES(101, 'Rahul Sharma', 'Java', 'M.Tech', 8),(102, 'Priya Verma', 'Python', 'M.Tech', 6),(103, 'Amit Patel', 'Database', 'MCA', 5),(104, 'Neha Singh', 'Data Structures', 'M.Tech', 7),(105, 'Rohit Gupta', 'Operating System', 'M.E.', 10),(106, 'Sneha Joshi', 'Computer Networks', 'Ph.D.', 12),(107, 'Vikas Mehta', 'Software Engineering', 'M.Tech', 9),(108, 'Anjali Deshmukh', 'Machine Learning', 'Ph.D.', 4),(109, 'Karan Malhotra', 'Cloud Computing', 'M.Tech', 6),(110, 'Pooja Nair', 'Cyber Security', 'M.Tech', 5)");

			System.out.println("Record Inserted: " + i + " rows affected");

			conn.commit();

		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			conn.rollback();
			
		} finally {
			conn.close();
		}
	}

}
