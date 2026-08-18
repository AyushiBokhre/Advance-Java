package com.rays.preparedStatement.hotel;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;


public class TestHotelModel {
public static HotelModel hm=new HotelModel();
	
	public static void main(String[] args) throws Exception {
		//testCreate();
		//testInsert();
//		testUpdate();
		testDelete();
		//testSearch();
	}
	
	public static void testCreate() throws SQLException {
		hm.create();
	}
	
	public static void testInsert() throws ParseException, SQLException {
		HotelBean bean = new HotelBean();
		bean.setHotelId(103);
		bean.setHotelName("DreamLand");
		bean.setLocation("Mhow");
		bean.setRating(4.5);
		bean.setContactNo("554433221");
		hm.insert(bean);
	}
//	
	public static void testUpdate() throws Exception {
		HotelBean bean = new HotelBean();
		bean.setHotelId(103);
		bean.setHotelName("DreamLand");
		bean.setLocation("Mhow");
		bean.setRating(3.5);
		bean.setContactNo("554433221");
		hm.update(bean);
	}
	
	public static void testDelete() throws Exception {
		hm.delete(101);
		
	}
	
	public static void testSearch() throws Exception {
		HotelBean bean = new HotelBean();
//		bean.setPaymentDate(sdf.parse("2026-09-25"));
			List<HotelBean> list = hm.search(bean, 1, 5);

			Iterator<HotelBean> it = list.iterator();

			while (it.hasNext()) {
				bean = it.next();
				System.out.print(bean.getHotelId());
				System.out.print("\t" + bean.getHotelName());
				System.out.print("\t" + bean.getLocation());
				System.out.print("\t" + bean.getRating());
				System.out.println("\t" + bean.getContactNo());
				
			}
		
	}

}
