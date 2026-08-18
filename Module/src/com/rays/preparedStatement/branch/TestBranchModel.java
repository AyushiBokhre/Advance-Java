package com.rays.preparedStatement.branch;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;


public class TestBranchModel {
public static BranchModel bm=new BranchModel();
	
	public static void main(String[] args) throws Exception {
		//testCreate();
		//testInsert();
		//testUpdate();
		//testDelete();
		testSearch();
	}
	
	public static void testCreate() throws SQLException {
		bm.create();
	}
	
	public static void testInsert() throws ParseException, SQLException {
		BranchBean bean = new BranchBean();
		bean.setBranchId(103);
		bean.setBranchName("DreamLand");
		bean.setCity("Mhow");
		bean.setManagerName("Ramesh yadav ");
		bean.setContactNo(554433221);
		bm.insert(bean);
	}
	
	public static void testUpdate() throws Exception {
		BranchBean bean = new BranchBean();
		bean.setBranchId(103);
		bean.setBranchName("DreamLand");
		bean.setCity("Mhow");
		bean.setManagerName("Ramesh yadav ");
		bean.setContactNo(554433221);
		bm.update(bean);
	}
	
	public static void testDelete() throws Exception {
		bm.delete(110);
		
	}
	
	public static void testSearch() throws Exception {
		BranchBean bean = new BranchBean();
//		bean.setPaymentDate(sdf.parse("2026-09-25"));
			List<BranchBean> list = bm.search(bean, 1, 5);

			Iterator<BranchBean> it = list.iterator();

			while (it.hasNext()) {
				bean = it.next();
				System.out.print(bean.getBranchId());
				System.out.print("\t" + bean.getBranchName());
				System.out.print("\t" + bean.getCity());
				System.out.print("\t" + bean.getManagerName());
				System.out.println("\t" + bean.getContactNo());
				
			}
		
	}
	


}
