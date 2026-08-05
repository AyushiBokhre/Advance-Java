package com.rays.subject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rays.student.UserBean;
import com.rays.util.JDBCDataSource;

public class SubjectModel {
	// ------------------create table-------------------
	public void create() throws SQLException {
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(
					"create table subject(subjectId int primary key,subjectName varchar(45),subjectCode varchar(45),credits int,semester int)");
			pstmt.executeUpdate();
			conn.commit();
			System.out.println("Table created successfully");

		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	// ------------------insert values into table-------------------
	public void insert(SubjectBean bean) throws SQLException {
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("insert into subject values(?,?,?,?,?)");
			pstmt.setInt(1, bean.getSubjectId());
			pstmt.setString(2, bean.getSubjectName());
			pstmt.setString(3, bean.getSubjectCode());
			pstmt.setInt(4, bean.getCredits());
			pstmt.setInt(5, bean.getSemester());

			int i = pstmt.executeUpdate();

			conn.commit();
			System.out.println("record inserted: " + i + " rows affected");

		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	// ------------------update values into table-------------------
	public void update(SubjectBean bean) throws SQLException {
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(
					"update subject set subjectName=?,subjectCode=?,credits=?,semester=? where subjectId=?");

			pstmt.setString(1, bean.getSubjectName());
			pstmt.setString(2, bean.getSubjectCode());
			pstmt.setInt(3, bean.getCredits());
			pstmt.setInt(4, bean.getSemester());
			pstmt.setInt(5, bean.getSubjectId());

			int i = pstmt.executeUpdate();

			conn.commit();

			System.out.println("record updated " + i + "rows affected");

		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	// ------------------delete values from table-------------------
	public void delete(int subjectId) throws Exception {
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("delete from subject where subjectId=?");
			pstmt.setInt(1, subjectId);
			int i = pstmt.executeUpdate();
			conn.commit();
			System.out.println("record deleted: " + i + " rows affected");
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	// ---------------------------findbypk-----------------------
	public SubjectBean findByPk(int subjectId) {
		Connection conn = null;
		SubjectBean bean = null;
		try {
			conn = JDBCDataSource.getConnection();

			PreparedStatement pstmt = conn.prepareStatement("select * from subject where subjectId=?");

			pstmt.setInt(1, subjectId);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new SubjectBean();
				bean.setSubjectId(rs.getInt("subjectId"));
				bean.setSubjectName(rs.getString("subjectName"));
				bean.setSubjectCode(rs.getString("subjectCode"));
				bean.setCredits(rs.getInt("credits"));
				bean.setSemester(rs.getInt("semester"));

			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return bean;
	}

	public List<SubjectBean> search(SubjectBean bean, int pageNo, int pageSize) throws SQLException {
		Connection conn = null;
		List<SubjectBean> list = new ArrayList<SubjectBean>();
		StringBuffer sql = new StringBuffer("select * from subject where 1=1 ");

		if (bean != null) {
			if (bean.getSubjectName() != null && bean.getSubjectName().length() > 0) {
				sql.append("and subjectName like '" + bean.getSubjectName() + "%' ");
			}

			if (bean.getSubjectCode() != null && bean.getSubjectCode().length() > 0) {
				sql.append("and subjectCode like '" + bean.getSubjectCode() + "%' ");
			}
			if (bean.getCredits() != 0 && bean.getCredits() > 0) {
				sql.append("and credits like '" + bean.getCredits() + "%' ");
			}
			if (bean.getSemester() != 0 && bean.getSemester() > 0) {
				sql.append("and semester like '" + bean.getSemester() + "%' ");
			}

		}
		if (pageSize > 0) {
			int index = (pageNo - 1) * pageSize;
			sql.append("limit " + index + ", " + pageSize);
		}
		conn = JDBCDataSource.getConnection();

		System.out.println("sql search query ====> " + sql.toString());

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			bean = new SubjectBean();
			bean.setSubjectId(rs.getInt("subjectId"));
			bean.setSubjectName(rs.getString("subjectName"));
			bean.setSubjectCode(rs.getString("subjectCode"));
			bean.setCredits(rs.getInt("credits"));
			bean.setSemester(rs.getInt("semester"));

			list.add(bean);
		}

		try {

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		return list;

	}

}
