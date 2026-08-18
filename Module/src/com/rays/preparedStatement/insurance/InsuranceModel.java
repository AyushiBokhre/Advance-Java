package com.rays.preparedStatement.insurance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rays.util.JDBCDataSource;

public class InsuranceModel {
	// ------------------create table------------------------------
			public void create() throws SQLException {
				Connection conn = null;
				try {
					conn = JDBCDataSource.getConnection();
					conn.setAutoCommit(false);
					PreparedStatement pstmt = conn.prepareStatement("Create table insurance(policyId int primary key,policyHolderName varchar(45),policyType varchar(45),premiumAmount bigint,expiryDate date)");
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
			public void insert(InsuranceBean bean) throws SQLException {
				Connection conn = null;
				try {
					conn = JDBCDataSource.getConnection();
					conn.setAutoCommit(false);
					PreparedStatement pstmt = conn.prepareStatement("insert into insurance values(?,?,?,?,?)");
					pstmt.setInt(1, bean.getPolicyId());
					pstmt.setString(2, bean.getPolicyHolderName());
					pstmt.setString(3, bean.getPolicyType());
					pstmt.setDouble(4, bean.getPremiumAmount());
					pstmt.setDate(5, new java.sql.Date(bean.getExpiryDate().getTime()));

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

//			// ------------------update values into table------------------------------
//			public void update(BranchBean bean) throws SQLException {
//				Connection conn = null;
//				try {
//					conn = JDBCDataSource.getConnection();
//					conn.setAutoCommit(false);
//					PreparedStatement pstmt = conn.prepareStatement(
//							"update branch set branchName=?,city=?,managerName=?,ContactNo=? where branchId=?");
//					
//					pstmt.setString(1, bean.getBranchName());
//					pstmt.setString(2, bean.getCity());
//					pstmt.setString(3, bean.getManagerName());
//					pstmt.setLong(4, bean.getContactNo());
//					pstmt.setInt(5, bean.getBranchId());
//
//					int i = pstmt.executeUpdate();
//					conn.commit();
//					System.out.println("record updated: " + i + " rows affected.");
//				} catch (Exception e) {
//					e.printStackTrace();
//					conn.rollback();
//				} finally {
//					conn.close();
//				}
//			}
//
//			// -----------------------------delete data from table--------------------------
//			public void delete(int feeid) throws Exception {
//				Connection conn = null;
//				try {
//					conn = JDBCDataSource.getConnection();
//					conn.setAutoCommit(false);
//					PreparedStatement pstmt = conn.prepareStatement("delete from fee where feeId=?");
//					pstmt.setInt(1, feeid);
//					int i = pstmt.executeUpdate();
//					conn.commit();
//					System.out.println("record deleted: " + i + " rows affected.");
//				} catch (Exception e) {
//					e.printStackTrace();
//					conn.rollback();
//				} finally {
//					conn.close();
//				}
//			}
//
//			// ---------------------search---------------
//			public List<BranchBean> search(BranchBean bean, int pageNo, int pageSize) throws Exception {
//				List<BranchBean> list = new ArrayList<BranchBean>();
//				StringBuffer sql = new StringBuffer("select * from branch where 1=1 ");
//
//				Connection conn = null;
//				try {
//					if (bean != null) {
//						if (bean.getBranchId() != 0) {
//							sql.append("and branchId = " + bean.getBranchId());
//						}
//						if (bean.getBranchName() != null && bean.getBranchName().length()> 0) {
//							sql.append("and BranchName like " + bean.getBranchName()+"%' ");
//						}
//						if (bean.getCity() != null && bean.getCity().length() > 0) {
//							sql.append("and city like '" + bean.getCity()+"%' ");
//						}
//
//						if (bean.getManagerName() != null && bean.getManagerName().length() > 0) {
//							sql.append("and managerName like '" +bean.getManagerName() + "%' ");
//						}
//					}
//
//					if (pageSize > 0) {
//						int index = (pageNo - 1) * pageSize;
//						sql.append(" limit " + index + ", " + pageSize);
//					}
//					conn = JDBCDataSource.getConnection();
//					PreparedStatement pstmt = conn.prepareStatement(sql.toString());
//					System.out.println(sql);
//
//					ResultSet rs = pstmt.executeQuery();
//					while (rs.next()) {
//						bean = new BranchBean();
//						bean.setBranchId(rs.getInt("branchId"));
//						bean.setBranchName(rs.getString("branchName"));
//						bean.setCity(rs.getString("city"));
//						bean.setManagerName(rs.getString("managerName"));
//						bean.setContactNo(rs.getLong("contactNo"));
//						list.add(bean);
//
//					}
//
//				} catch (Exception e) {
//					e.printStackTrace();
//				} finally {
//					conn.close();
//				}
//
//				return list;
//
//			}

}
