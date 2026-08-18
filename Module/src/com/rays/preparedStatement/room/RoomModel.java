package com.rays.preparedStatement.room;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.rays.util.JDBCDataSource;

public class RoomModel {
	public void create() throws SQLException {
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(
					"create table room(roomId bigint primary key,roomNumber varchar(45),roomtype varchar(45),pricePerDay double,availability boolean)");
			pstmt.executeUpdate();
			conn.commit();
			System.out.println("Table created Successfully");

		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	public void insert(RoomBean bean) throws SQLException {
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("insert into room values(?,?,?,?,?)");
			pstmt.setLong(1, bean.getRoomId());
			pstmt.setString(2, bean.getRoomNumber());
			pstmt.setString(3, bean.getRoomType());
			pstmt.setDouble(4, bean.getPricePerDay());
			pstmt.setBoolean(5, bean.isAvailability());
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
	
	public void update(RoomBean bean) throws SQLException {
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("update room set roomNumber=?,roomType=?,pricePerDay=?,availability=? where roomId=?");
		
			pstmt.setString(1, bean.getRoomNumber());
			pstmt.setString(2, bean.getRoomType());
			pstmt.setDouble(3, bean.getPricePerDay());
			pstmt.setBoolean(4, bean.isAvailability());
			pstmt.setLong(5, bean.getRoomId());
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

}
