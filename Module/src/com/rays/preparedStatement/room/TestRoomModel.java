package com.rays.preparedStatement.room;

import java.sql.SQLException;

public class TestRoomModel {
	public static RoomModel rm =new RoomModel();
	
	public static void main(String[] args) throws SQLException {
		//testCreate();
		//testInsert();
		testUpdate();
	}
	public static void testCreate() throws SQLException {
		rm.create();
	}
	public static void testInsert() throws SQLException {
		RoomBean bean = new RoomBean();

		bean.setRoomId(1001);
		bean.setRoomNumber("101");
		bean.setRoomType("Deluxe");
		bean.setPricePerDay(2500);
		bean.setAvailability(true);
		rm.insert(bean);


		bean.setRoomId(1002);
		bean.setRoomNumber("102");
		bean.setRoomType("Deluxe");
		bean.setPricePerDay(2500);
		bean.setAvailability(true);
		rm.insert(bean);


		bean.setRoomId(1003);
		bean.setRoomNumber("103");
		bean.setRoomType("Deluxe");
		bean.setPricePerDay(2500);
		bean.setAvailability(true);
		rm.insert(bean);
	}
	
	public static void testUpdate() throws SQLException {
		RoomBean bean=new RoomBean();
		bean.setRoomId(1001);
		bean.setRoomNumber("101");
		bean.setRoomType("Suite");
		bean.setPricePerDay(2500);
		bean.setAvailability(true);
		rm.update(bean);
	}
//	
	

}
