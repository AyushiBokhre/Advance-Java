package com.rays.scholarship;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rays.fees.FeeBean;
import com.rays.student.UserBean;
import com.rays.util.JDBCDataSource;

public class ScholarshipModel {
	// ------------------create table------------------------------
		public void create() throws SQLException {
			Connection conn = null;
			try {
				conn = JDBCDataSource.getConnection();
				conn.setAutoCommit(false);
				PreparedStatement pstmt = conn.prepareStatement(
						"create table scholarship(scholarshipId int primary key,scholarshipName varchar(45),amount int,eligibility varchar(45),lastdate date)");
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
		public void insert(ScholarshipBean bean) throws SQLException {
			Connection conn = null;
			try {
				conn = JDBCDataSource.getConnection();
				conn.setAutoCommit(false);
				PreparedStatement pstmt = conn.prepareStatement("insert into scholarship values(?,?,?,?,?)");
				pstmt.setInt(1, bean.getScholarshipId());
				pstmt.setString(2, bean.getScholarshipName());
				pstmt.setInt(3, bean.getAmount());
				pstmt.setString(4, bean.getEligibility());
				pstmt.setDate(5, new java.sql.Date(bean.getLastDate().getTime()));
				

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
		public void update(ScholarshipBean bean) throws SQLException {
			Connection conn = null;
			try {
				conn = JDBCDataSource.getConnection();
				conn.setAutoCommit(false);
				PreparedStatement pstmt = conn.prepareStatement(
						"update scholarship set scholarshipId=?,scholarshipName=?,amount=?,eligibility=?,lastDate=? where scholarshipId=?");
				pstmt.setString(1, bean.getScholarshipName());
				pstmt.setInt(2, bean.getAmount());
				pstmt.setString(3, bean.getEligibility());
				pstmt.setDate(4, new java.sql.Date(bean.getLastDate().getTime()));
				pstmt.setInt(5, bean.getScholarshipId());

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
		public void delete(int ScholarshipId) throws Exception {
			Connection conn = null;
			try {
				conn = JDBCDataSource.getConnection();
				conn.setAutoCommit(false);
				PreparedStatement pstmt = conn.prepareStatement("delete from scholarship where scholarshipId=?");
				pstmt.setInt(1, ScholarshipId);
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
		public List<ScholarshipBean> search(ScholarshipBean bean, int pageNo, int pageSize) throws Exception {
			List<ScholarshipBean> list = new ArrayList<ScholarshipBean>();
			StringBuffer sql = new StringBuffer("select * from scholarship where 1=1 ");

			Connection conn = null;
			try {
				if (bean != null) {
					if (bean.getScholarshipName() != null && bean.getScholarshipName().length()>0) {
						sql.append("and scholarshipName like " + bean.getScholarshipName()+"%' ");
					}
					if (bean.getAmount() != 0) {
						sql.append("and Amount = " + bean.getAmount());
					}
					if (bean.getEligibility() != null && bean.getEligibility().length() > 0) {
						sql.append("and eligibility like '" + bean.getEligibility()+"%' ");
					}

					if (bean.getLastDate() != null && bean.getLastDate().getTime() > 0) {
						sql.append("and lastdate like '" + bean.getLastDate() + "%' ");
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
					bean = new ScholarshipBean();
					bean.setScholarshipId(rs.getInt("scholarshipId"));
					bean.setScholarshipName(rs.getString("scholarshipName"));
					bean.setAmount(rs.getInt("Amount"));
					bean.setEligibility(rs.getString("eligibility"));
					bean.setLastDate(rs.getDate("lastdate"));
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
