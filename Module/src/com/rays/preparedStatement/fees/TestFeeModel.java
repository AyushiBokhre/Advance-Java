package com.rays.preparedStatement.fees;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

public class TestFeeModel {
	public static FeeModel fm=new FeeModel();
	
	public static void main(String[] args) throws Exception {
		//testCreate();
		//testInsert();
		//testUpdate();
		//testDelete();
		testSearch();
	}
	
	public static void testCreate() throws SQLException {
		fm.create();
	}
	
	public static void testInsert() throws ParseException, SQLException {
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		FeeBean bean = new FeeBean();
		bean.setFeeId(110);
		bean.setStudentId(10);
		bean.setAmount(9000);
		bean.setPaymentDate(sdf.parse("2026-09-25"));
		bean.setPaymentStatus("Pending");
		fm.insert(bean);
	}
	
	public static void testUpdate() throws Exception {
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		FeeBean bean = new FeeBean();
		bean.setFeeId(101);
		bean.setStudentId(1);
		bean.setAmount(12500);
		bean.setPaymentDate(sdf.parse("2026-09-22"));
		bean.setPaymentStatus("Paid");
		fm.update(bean);
	}
	
	public static void testDelete() throws Exception {
		fm.delete(101);
		
	}
	
	public static void testSearch() throws Exception {
		FeeBean bean = new FeeBean();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		bean.setPaymentDate(sdf.parse("2026-09-25"));
			List<FeeBean> list = fm.search(bean, 1, 5);

			Iterator<FeeBean> it = list.iterator();

			while (it.hasNext()) {
				bean = it.next();
				System.out.print(bean.getFeeId());
				System.out.print("\t" + bean.getStudentId());
				System.out.print("\t" + bean.getAmount());
				System.out.print("\t" + bean.getPaymentDate());
				System.out.println("\t" + bean.getPaymentStatus());
				
			}
		
	}
	

}
