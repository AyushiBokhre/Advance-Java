package com.rays.preparedStatement.hotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rays.util.JDBCDataSource;

public class HotelModel {
	public void create() throws SQLException {
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(
					"create table hotel(hotelId bigint primary key,hotelName varchar(45),location varchar(45),rating double,contactNo varchar(45))");
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

	public void insert(HotelBean bean) throws SQLException {
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("insert into hotel values(?,?,?,?,?)");
			pstmt.setLong(1, bean.getHotelId());
			pstmt.setString(2, bean.getHotelName());
			pstmt.setString(3, bean.getLocation());
			pstmt.setDouble(4, bean.getRating());
			pstmt.setString(5, bean.getContactNo());
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
//
	public void update(HotelBean bean) throws SQLException {
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(
					"update hotel set hotelName=?,location=?,rating=?,contactNo=? where hotelId=?");
			pstmt.setString(1, bean.getHotelName());
			pstmt.setString(2, bean.getLocation());
			pstmt.setDouble(3, bean.getRating());
			pstmt.setString(4, bean.getContactNo());
			pstmt.setLong(5, bean.getHotelId());
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

	public void delete(int hotelId) throws SQLException {
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("delete from hotel where hotelId=?");
			pstmt.setLong(1, hotelId);
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

	public List<HotelBean> search(HotelBean bean, int pageNo, int pageSize) throws SQLException {
		Connection conn = null;
		List<HotelBean> list = new ArrayList<HotelBean>();
		StringBuffer sql = new StringBuffer("select * from bankaccount where 1=1");

		try {
			if (bean != null) {
				if (bean.getHotelId() != 0) {
					sql.append("and hotelId = " + bean.getHotelId());
				}
				if (bean.getHotelName() != null && bean.getHotelName().length() > 0) {
					sql.append("and hotelName like " + bean.getHotelName() + "%' ");
				}
				if (bean.getLocation() != null && bean.getLocation().length() > 0) {
					sql.append("and location like '" + bean.getLocation() + "%' ");
				}

				if (bean.getRating() != 0) {
					sql.append("and rating = " + bean.getRating());
				}
				if (bean.getContactNo() != null && bean.getContactNo().length() > 0) {
					sql.append("and contactNo like " + bean.getContactNo() + "%' ");
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
				bean = new HotelBean();
				bean.setHotelId(rs.getLong("hotelId"));
				bean.setHotelName(rs.getString("hotelName"));
				bean.setLocation(rs.getString("location"));
				bean.setRating(rs.getDouble("rating"));
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
