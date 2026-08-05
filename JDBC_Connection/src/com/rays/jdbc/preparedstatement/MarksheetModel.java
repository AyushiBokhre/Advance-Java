package com.rays.jdbc.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.rays.jdbc.util.JDBCDataSource;

public class MarksheetModel {

	//-----------------insert into table-------------
	
	public void insert(MarksheetBean bean) throws Exception {
		Connection conn =null;
		
		try {
			conn=JDBCDataSource.getConnection();
			
			conn.setAutoCommit(false);
			
			PreparedStatement pstmt =conn.prepareStatement("insert into marksheet values(?,?,?,?,?,?)");
			
			pstmt.setInt(1, bean.getId());
			pstmt.setInt(2, bean.getRollno());
			pstmt.setString(3, bean.getName());
			pstmt.setInt(4, bean.getPhy());
			pstmt.setInt(5, bean.getChem());
			pstmt.setInt(6, bean.getMath());
			
			int i =pstmt.executeUpdate();
			conn.commit();
			System.out.println("Record Inserted: "+i+" rows affected.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			conn.rollback();
		}finally {
			conn.close();
		}
	}

}
