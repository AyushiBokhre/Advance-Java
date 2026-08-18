package com.rays.preparedStatement.patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rays.util.JDBCDataSource;

public class PatientModel {
	//---------------create-----------------------------
	public void create() throws SQLException {
		Connection conn=null;
		try {
			conn=JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt= conn.prepareStatement("create table patient(patientId bigint primary key,patientName varchar(45),disease varchar(45),doctorName varchar(45),admissionDate date)");
			pstmt.executeUpdate();
			conn.commit();
			System.out.println("Table created successfully");
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		}finally {
			conn.close();
		}
	}
	
	//------------------insert------------------------
	public void insert(PatientBean bean) throws SQLException {
		Connection conn=null;
		try {
			conn=JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt= conn.prepareStatement("insert into patient values(?,?,?,?,?)");
			pstmt.setLong(1, bean.getPatientId());
			pstmt.setString(2, bean.getPatientName());
			pstmt.setString(3, bean.getDisease());
			pstmt.setString(4, bean.getDoctorName());
			pstmt.setDate(5, new java.sql.Date(bean.getAdmissionDate().getTime()));
			int i=pstmt.executeUpdate();
			conn.commit();
			System.out.println("Record inserted "+i+" rows affected.");
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		}finally {
			conn.close();
		}
	}
	//------------------update------------------------
	public void update(PatientBean bean) throws SQLException {
		Connection conn=null;
		try {
			conn=JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt= conn.prepareStatement("update patient set patientName=?,disease =?,doctorName=?,admissionDate=? where patientId=?");
			
			pstmt.setString(1, bean.getPatientName());
			pstmt.setString(2, bean.getDisease());
			pstmt.setString(3, bean.getDoctorName());
			pstmt.setDate(4, new java.sql.Date(bean.getAdmissionDate().getTime()));
			pstmt.setLong(5, bean.getPatientId());
			int i=pstmt.executeUpdate();
			conn.commit();
			System.out.println("Record updated "+i+" rows affected.");
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		}finally {
			conn.close();
		}
	}
	//----------------------delete--------------------------
	public void delete(long patientId) throws SQLException {
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("delete from patient where patientId=?");

			pstmt.setLong(1, patientId);

			int i = pstmt.executeUpdate();
			conn.commit();
			System.out.println("record deleted: " + i + " rows affected.");
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		} finally {
			conn.close();
		}

	}
	
	//-----------------------search-------------------------------------------
	
	public List<PatientBean> search(PatientBean bean,int pageNo,int pageSize) throws SQLException {
		List<PatientBean> list=new ArrayList<PatientBean>();
		Connection conn = null;
		StringBuffer sql=new StringBuffer("select * from patient where 1=1");
		if(pageNo >0) {
			int index=(pageNo-1)*pageSize;
			sql.append(" limit " + index + ", " + pageSize);
			
		}
		conn = JDBCDataSource.getConnection();

		System.out.println("sql search query ====> " + sql.toString());

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			bean = new PatientBean();
			bean.setPatientId(rs.getLong("patientId"));
			bean.setPatientName(rs.getString("patientName"));
			bean.setDisease(rs.getString("disease"));
			bean.setDoctorName(rs.getString("doctorName"));
			bean.setAdmissionDate(rs.getDate("admissionDate"));

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
