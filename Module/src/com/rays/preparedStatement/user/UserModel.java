package com.rays.preparedStatement.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.rays.util.JDBCDataSource;

public class UserModel {
	// ----------------------create table------------------

	public void create() throws Exception {
		Connection conn = null;
		try {

			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"create table st_user(id int auto_increment primary key, firstName varchar(50) , lastName varchar(50) ,loginId varchar(45),password varchar(45),dob date)");

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

	public void insert(UserBean bean) throws Exception {

		Connection conn = null;

		UserBean existBean = findbylogin(bean.getLoginId());

		if (existBean != null) {
			throw new RuntimeException("loginId already exists");
		}

		try {

			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("insert into st_user values(?, ?, ?, ?, ?, ?)");

			pstmt.setInt(1, bean.getId());
			pstmt.setString(2, bean.getFirstName());
			pstmt.setString(3, bean.getLastName());
			pstmt.setString(4, bean.getLoginId());
			pstmt.setString(5, bean.getPassword());
			pstmt.setDate(6, new java.sql.Date(bean.getDob().getTime()));

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

	public void update(UserBean bean) throws Exception {

		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"update st_user set  firstName = ?, lastName = ?, loginId = ?,password = ?,dob=?  where id = ?");

			pstmt.setString(1, bean.getFirstName());
			pstmt.setString(2, bean.getLastName());
			pstmt.setString(3, bean.getLoginId());
			pstmt.setString(4, bean.getPassword());
			pstmt.setDate(6, new java.sql.Date(bean.getDob().getTime()));
			pstmt.setInt(6, bean.getId());

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

	public void delete(int id) throws Exception {

		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("delete from st_user where resultId = ?");

			pstmt.setInt(1, id);

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

	public UserBean findbypk(int id) throws Exception {

		Connection conn = null;
		UserBean bean = null;

		try {

			conn = JDBCDataSource.getConnection();

			PreparedStatement pstmt = conn.prepareStatement("select * from st_user where id = ?");

			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new UserBean();
				bean.setId(rs.getInt("id"));
				bean.setFirstName(rs.getString("firstName"));
				bean.setLastName(rs.getString("lastName"));
				bean.setLoginId(rs.getString("loginId"));
				bean.setPassword(rs.getString("password"));
				bean.setDob(rs.getDate("dob"));
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());

		} finally {
			conn.close();
		}
		return bean;

	}

	// ----------------------findbylogin------------------

	public UserBean findbylogin(String loginId) throws Exception {

		Connection conn = null;
		UserBean bean = null;

		try {

			conn = JDBCDataSource.getConnection();

			PreparedStatement pstmt = conn.prepareStatement("select * from st_user where loginId = ?");

			pstmt.setString(1, loginId);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new UserBean();
				bean.setId(rs.getInt("id"));
				bean.setFirstName(rs.getString("firstName"));
				bean.setLastName(rs.getString("lastName"));
				bean.setLoginId(rs.getString("loginId"));
				bean.setPassword(rs.getString("password"));
				bean.setDob(rs.getDate("dob"));
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());

		} finally {
			conn.close();
		}
		return bean;

	}

	public UserBean authenticate(String loginId, String password) throws Exception {

		UserBean bean = findbylogin(loginId);

		if (bean != null && bean.getPassword().equals(password)) {
			return bean;
		}

		return null;

	}

}
