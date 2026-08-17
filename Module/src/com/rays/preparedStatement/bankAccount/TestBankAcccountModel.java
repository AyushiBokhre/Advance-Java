package com.rays.preparedStatement.bankAccount;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

public class TestBankAcccountModel {
	public static BankAccountModel bm=new BankAccountModel();
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
	public static void testInsert() throws SQLException {
		BankAccountBean bean=new BankAccountBean();
		bean.setAccountNumber(1000000001);
		bean.setAccountHolderName("Ram Sharma");
		bean.setAccountType("Saving");
		bean.setBalance(100000);
		bean.setBranchName("Sukhliya");
		bm.insert(bean);
	}
	
	public static void testUpdate() throws SQLException {
		BankAccountBean bean=new BankAccountBean();
		bean.setAccountNumber(1000000001);
		bean.setAccountHolderName("Ram Sharma");
		bean.setAccountType("Saving");
		bean.setBalance(200000);
		bean.setBranchName("Sukhliya");
		bm.update(bean);
	}
	
	public static void testDelete() throws SQLException {
		bm.delete(1000000001);
	}
	
	public static void testSearch() throws Exception {
		BankAccountBean bean = new BankAccountBean();
//		bean.setPaymentDate(sdf.parse("2026-09-25"));
			List<BankAccountBean> list = bm.search(bean, 1, 5);

			Iterator<BankAccountBean> it = list.iterator();

			while (it.hasNext()) {
				bean = it.next();
				System.out.print(bean.getAccountNumber());
				System.out.print("\t" + bean.getAccountHolderName());
				System.out.print("\t" + bean.getAccountType());
				System.out.print("\t" + bean.getBalance());
				System.out.println("\t" + bean.getBranchName());
				
			}
		
	}
}
