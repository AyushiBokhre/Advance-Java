package com.rays.fees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rays.util.JDBCDataSource;

public class FeeModel {
	// ------------------create table------------------------------
	public void create() throws SQLException {
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(
					"create table fee(feeId int primary key,studentId int,amount int,paymentDate date,paymentStatus varchar(45))");
			pstmt.executeUpdate();
			conn.commit();
			System.out.println("table created successfully.");
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	// ------------------insert values into table------------------------------
	public void insert(FeeBean bean) throws SQLException {
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("insert into fee values(?,?,?,?,?)");
			pstmt.setInt(1, bean.getFeeId());
			pstmt.setInt(2, bean.getStudentId());
			pstmt.setInt(3, bean.getAmount());
			pstmt.setDate(4, new java.sql.Date(bean.getPaymentDate().getTime()));
			pstmt.setString(5, bean.getPaymentStatus());

			int i = pstmt.executeUpdate();
			conn.commit();
			System.out.println("record inserted: " + i + " rows affected.");
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	// ------------------update values into table------------------------------
	public void update(FeeBean bean) throws SQLException {
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(
					"update fee set studentId=?,amount=?,paymentDate=?,paymentStatus=? where feeId=?");
			pstmt.setInt(1, bean.getStudentId());
			pstmt.setInt(2, bean.getAmount());
			pstmt.setDate(3, new java.sql.Date(bean.getPaymentDate().getTime()));
			pstmt.setString(4, bean.getPaymentStatus());
			pstmt.setInt(5, bean.getFeeId());

			int i = pstmt.executeUpdate();
			conn.commit();
			System.out.println("record updated: " + i + " rows affected.");
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	// -----------------------------delete data from table--------------------------
	public void delete(int feeid) throws Exception {
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("delete from fee where feeId=?");
			pstmt.setInt(1, feeid);
			int i = pstmt.executeUpdate();
			conn.commit();
			System.out.println("record deleted: " + i + " rows affected.");
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	// ---------------------search---------------
	public List<FeeBean> search(FeeBean bean, int pageNo, int pageSize) throws Exception {
		List<FeeBean> list = new ArrayList<FeeBean>();
		StringBuffer sql = new StringBuffer("select * from fee where 1=1 ");

		Connection conn = null;
		try {
			if (bean != null) {
				if (bean.getStudentId() != 0) {
					sql.append("and studentId = " + bean.getStudentId());
				}
				if (bean.getAmount() != 0) {
					sql.append("and Amount = " + bean.getAmount());
				}
				if (bean.getPaymentDate() != null && bean.getPaymentDate().getTime() > 0) {
					sql.append("and paymentDate like '" + new java.sql.Date(bean.getPaymentDate().getTime())+"'");
				}

				if (bean.getPaymentStatus() != null && bean.getPaymentStatus().length() > 0) {
					sql.append("and paymentStatus like '" + bean.getPaymentStatus() + "%' ");
				}
			}

			if (pageSize > 0) {
				int index = (pageNo - 1) * pageSize;
				sql.append(" limit " + index + ", " + pageSize);
			}
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			System.out.println(sql);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				bean = new FeeBean();
				bean.setFeeId(rs.getInt("feeId"));
				bean.setStudentId(rs.getInt("studentId"));
				bean.setAmount(rs.getInt("Amount"));
				bean.setPaymentDate(rs.getDate("paymentDate"));
				bean.setPaymentStatus(rs.getString("paymentStatus"));
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
