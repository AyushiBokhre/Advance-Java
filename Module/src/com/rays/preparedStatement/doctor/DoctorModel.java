package com.rays.preparedStatement.doctor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rays.preparedStatement.branch.BranchBean;
import com.rays.util.JDBCDataSource;

public class DoctorModel {
	public void create() throws SQLException {
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(
					"create table doctor(doctorid bigint primary key,doctorName varchar(45),specialization varchar(45),experience int,contactNo varchar(10))");
			pstmt.executeUpdate();
			conn.commit();
			System.out.println("Table Created Successfully");

		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}

	}

	public void insert(DoctorBean bean) throws SQLException {
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("insert into doctor values(?,?,?,?,?)");
			pstmt.setLong(1, bean.getDoctorId());
			pstmt.setString(2, bean.getDoctorName());
			pstmt.setString(3, bean.getSpecialization());
			pstmt.setInt(4, bean.getExperience());
			pstmt.setString(5, bean.getContactNo());
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

	public void update(DoctorBean bean) throws SQLException {
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(
					"update doctor set doctorName=?,specialization=?,experience=?,contactNo=? where doctorId=?");
			pstmt.setString(1, bean.getDoctorName());
			pstmt.setString(2, bean.getSpecialization());
			pstmt.setInt(3, bean.getExperience());
			pstmt.setString(4, bean.getContactNo());
			pstmt.setLong(5, bean.getDoctorId());
			int i = pstmt.executeUpdate();
			conn.commit();
			System.out.println("record updated: " + i + " rows affected");

		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	public void delete(int doctorId) throws SQLException {
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("delete from doctor where doctorId=?");
			pstmt.setLong(1, doctorId);
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

	public List<DoctorBean> search(DoctorBean bean, int pageNo, int pageSize) throws SQLException {
		List<DoctorBean> list = new ArrayList<DoctorBean>();
		StringBuffer sql = new StringBuffer("select * from doctor where 1=1 ");
		Connection conn = null;
		if (pageNo > 0) {
			int index = (pageNo - 1) * pageSize;
			sql.append(" limit " + index + "," + pageSize);
		}
		
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			System.out.println(sql);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				bean = new DoctorBean();
				bean.setDoctorId(rs.getLong("doctorId"));
				bean.setDoctorName(rs.getString("doctorName"));
				bean.setSpecialization(rs.getString("specialization"));
				bean.setExperience(rs.getInt("experience"));
				bean.setContactNo(rs.getString("contactNo"));
				list.add(bean);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		return list;

	}

}
