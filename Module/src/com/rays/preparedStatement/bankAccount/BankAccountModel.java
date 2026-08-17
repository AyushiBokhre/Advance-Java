package com.rays.preparedStatement.bankAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rays.util.JDBCDataSource;

public class BankAccountModel {
	public void create() throws SQLException {
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(
					"create table bankaccount(accountNumber bigint,accountHolderName varchar(45),accountType varchar(45),balance double,brancgName varchar(45))");
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

	public void insert(BankAccountBean bean) throws SQLException {
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("insert into bankaccount values(?,?,?,?,?)");
			pstmt.setLong(1, bean.getAccountNumber());
			pstmt.setString(2, bean.getAccountHolderName());
			pstmt.setString(3, bean.getAccountType());
			pstmt.setDouble(4, bean.getBalance());
			pstmt.setString(5, bean.getBranchName());
			int i = pstmt.executeUpdate();
			conn.commit();
			System.out.println("record inserted " + i + " rows affected");
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	public void update(BankAccountBean bean) throws SQLException {
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(
					"update bankaccount set accountHolderName=?,accountType=?,balance=?,brancgName=? where accountNumber=?");
			pstmt.setString(1, bean.getAccountHolderName());
			pstmt.setString(2, bean.getAccountType());
			pstmt.setDouble(3, bean.getBalance());
			pstmt.setString(4, bean.getBranchName());
			pstmt.setLong(5, bean.getAccountNumber());
			int i = pstmt.executeUpdate();
			conn.commit();
			System.out.println("record updated " + i + " rows affected");
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	public void delete(int accountNumber) throws SQLException {
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("delete from bankaccount where accountNumber=?");
			pstmt.setLong(1, accountNumber);
			int i = pstmt.executeUpdate();
			conn.commit();
			System.out.println("record deleted " + i + " rows affected");
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	public List<BankAccountBean> search(BankAccountBean bean, int pageNo, int pageSize) throws SQLException {
		Connection conn = null;
		List<BankAccountBean> list = new ArrayList<BankAccountBean>();
		StringBuffer sql = new StringBuffer("select * from bankaccount where 1=1");

		try {
			if (bean != null) {
				if (bean.getAccountNumber() != 0) {
					sql.append("and accountNumber = " + bean.getAccountNumber());
				}
				if (bean.getAccountHolderName() != null && bean.getAccountHolderName().length() > 0) {
					sql.append("and accountHolderName like " + bean.getAccountHolderName() + "%' ");
				}
				if (bean.getAccountType() != null && bean.getAccountType().length() > 0) {
					sql.append("and accountType like '" + bean.getAccountType() + "%' ");
				}

				if (bean.getBalance() != 0) {
					sql.append("and managerName = " + bean.getBalance());
				}
				if (bean.getBranchName() != null && bean.getBranchName().length() > 0) {
					sql.append("and brancgName like " + bean.getBranchName() + "%' ");
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
				bean = new BankAccountBean();
				bean.setAccountNumber(rs.getLong("accountNumber"));
				bean.setAccountHolderName(rs.getString("accountHolderName"));
				bean.setAccountType(rs.getString("accountType"));
				bean.setBalance(rs.getDouble("balance"));
				bean.setBranchName(rs.getString("brancgName"));
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
