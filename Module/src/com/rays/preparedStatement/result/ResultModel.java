package com.rays.preparedStatement.result;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.rays.util.JDBCDataSource;

public class ResultModel {
	// ----------------------create table------------------

	public void create() throws Exception {
		Connection conn = null;
		try {

			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"create table result(resultID int auto_increment primary key, studentId int ,percentage int ,grade varchar(45),resultStatus varchar(45))");

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

	// -----------------insert into table-------------

	public void insert(ResultBean bean) throws Exception {
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("insert into result values(?,?,?,?,?)");

			pstmt.setInt(1, bean.getResultId());
			pstmt.setInt(2, bean.getStudentId());
			pstmt.setInt(3, bean.getPercentage());
			pstmt.setString(4, bean.getGrade());
			pstmt.setString(5, bean.getResultStatus());

			int i = pstmt.executeUpdate();
			conn.commit();
			System.out.println("Record Inserted: " + i + " rows affected.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			conn.rollback();
		} finally {
			conn.close();
		}
	}
	// ----------------------update table------------------

	public void update(ResultBean bean)
			throws Exception {

		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"update result set  studentId = ?, percentage = ?, grade = ?,resultStatus = ?  where resultId = ?");

			pstmt.setInt(1, bean.getStudentId());
			pstmt.setInt(2, bean.getPercentage());
			pstmt.setString(3, bean.getGrade());
			pstmt.setString(4, bean.getResultStatus());
			pstmt.setInt(5, bean.getResultId());

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

	public void delete(int resultId) throws Exception {

		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("delete from result where resultId = ?");

			pstmt.setInt(1, resultId);

			int i = pstmt.executeUpdate();
			
			System.out.println("record delete successfully: " + i);
			conn.commit();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			conn.rollback();
		} finally {
			conn.close();
		}

	}
	// ----------------------findbypk------------------

		public void findbypk(int resultId) throws Exception {

			Connection conn = null;

			try {

				conn = JDBCDataSource.getConnection();

				PreparedStatement pstmt = conn.prepareStatement("select * from result where resultId = ?");

				pstmt.setInt(1, resultId);

				ResultSet rs = pstmt.executeQuery();
				
				//System.out.println("record delete successfully: " + i);
				conn.commit();

			} catch (Exception e) {
				System.out.println(e.getMessage());
				conn.rollback();
			} finally {
				conn.close();
			}

		}
	
}
