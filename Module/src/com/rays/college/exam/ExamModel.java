package com.rays.college.exam;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ExamModel {

	// ----------------------create table------------------

	public void create() throws Exception {
		Connection conn = null;
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"create table exam(examID int primary key, examName varchar(45),examDate Date, totalMarks int,passingMarks int)");

			int i = pstmt.executeUpdate();

			conn.commit();

			System.out.println("Table created successfully " + i);

		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}

	}

	// ----------------------insert into table------------------

	public void insert(int examId, String examName, java.util.Date date, int totalMarks, int passingMarks)
			throws Exception {

		Connection conn = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("insert into exam values(?, ?, ?, ?, ?)");

			pstmt.setInt(1, examId);
			pstmt.setString(2, examName);
			pstmt.setDate(3, new java.sql.Date(date.getTime()));
			pstmt.setInt(4, totalMarks);
			pstmt.setInt(5, passingMarks);

			int i = pstmt.executeUpdate();

			conn.commit();

			System.out.println("record inserted successfully: " + i);

		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}

	}

	// ----------------------update table------------------

	public void update(int examId, String examName, java.util.Date examDate, int totalMarks, int passingMarks)
			throws Exception {

		Connection conn = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"update exam set examName = ?, examDate = ?, totalMarks = ?, passingMarks = ? where examId = ?");

			pstmt.setString(1, examName);
			pstmt.setDate(2, new java.sql.Date(examDate.getTime()));
			pstmt.setInt(3, totalMarks);
			pstmt.setInt(4, passingMarks);
			pstmt.setInt(5, examId);

			int i = pstmt.executeUpdate();

			conn.commit();

			System.out.println("record updated successfully: " + i);

		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}

	}

	// ----------------------delete table------------------

	public void delete(int examId) throws Exception {

		Connection conn = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("delete from exam where examId = ?");

			pstmt.setInt(1, examId);

			int i = pstmt.executeUpdate();

			conn.commit();

			System.out.println("record delete successfully: " + i);

		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}

	}

}
