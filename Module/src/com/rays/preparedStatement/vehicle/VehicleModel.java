package com.rays.preparedStatement.vehicle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.rays.util.JDBCDataSource;

public class VehicleModel {
	public void create() throws SQLException {
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(
					"create table vehicle(vehicleId int primary key,vehicleName varchar(45),model varchar(45),color varchar(45),price bigint)");
			pstmt.executeUpdate();
			conn.commit();
			System.out.println("Table created successfully.");
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		} finally {
			conn.close();
		}

	}

	public void insert(VehicleBean bean) throws SQLException {
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("insert into vehicle values(?,?,?,?,?)");
			pstmt.setLong(1, bean.getVehicleId());
			pstmt.setString(2, bean.getVehicleName());
			pstmt.setString(3, bean.getModel());
			pstmt.setString(4, bean.getColor());
			pstmt.setDouble(5, bean.getPrice());
			int i = pstmt.executeUpdate();
			conn.commit();
			System.out.println("record inserted: " + i + " rows affected.");
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		} finally {
			conn.close();
		}
	}

	public void update(VehicleBean bean) throws SQLException {
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn
					.prepareStatement("update vehicle set vehicleName=?,model=?,color=?,price=? where vehicleId=?");

			pstmt.setString(1, bean.getVehicleName());
			pstmt.setString(2, bean.getModel());
			pstmt.setString(3, bean.getColor());
			pstmt.setDouble(4, bean.getPrice());
			pstmt.setLong(5, bean.getVehicleId());
			int i = pstmt.executeUpdate();
			conn.commit();
			System.out.println("record updated: " + i + " rows affected.");
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		} finally {
			conn.close();
		}

	}

	public void delete(long vehicleId) throws SQLException {
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("delete from vehicle where vehicleId=?");

			pstmt.setLong(1, vehicleId);

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
	
	public List<VehicleBean> search(VehicleBean bean,int pageNo,int pageSize) throws SQLException {
		List<VehicleBean> list=new ArrayList<VehicleBean>();
		Connection conn = null;
		StringBuffer sql=new StringBuffer("select * from vehicle where 1=1");
		if(pageNo >0) {
			int index=(pageNo-1)*pageSize;
			sql.append(" limit " + index + ", " + pageSize);
			
		}
		conn = JDBCDataSource.getConnection();

		System.out.println("sql search query ====> " + sql.toString());

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			bean = new VehicleBean();
			bean.setVehicleId(rs.getInt("vehicleId"));
			bean.setVehicleName(rs.getString("vehicleName"));
			bean.setModel(rs.getString("model"));
			bean.setColor(rs.getString("color"));
			bean.setPrice(rs.getLong("price"));

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
