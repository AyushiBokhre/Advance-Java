package com.rays.preparedStatement.user;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TestUserModel {
	public static UserModel model = new UserModel();

	public static void main(String[] args) throws Exception {
		testAdd();
//		testUpdate();
//		testDelete();
//		testFindByPk();
	}

		// ----------------------create table-------------------

		public static void testCreate() throws Exception {
			model.create();
			}


			
			public static void testAdd() throws Exception {

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

				UserBean bean = new UserBean();

				bean.setId(10);
				bean.setFirstName("Ayan");
				bean.setLastName("Choudhary");
				bean.setLoginId("ayan123@gmail.com");
				bean.setPassword("ayan123");
				bean.setDob(sdf.parse("2004-10-09"));

				model.insert(bean);

			}
		// ----------------------insert into table------------------

		public static void testInsert() throws Exception {

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			UserBean bean = new UserBean();

			bean.setId(10);
			bean.setFirstName("Ayan");
			bean.setLastName("Choudhary");
			bean.setLoginId("ayan123@gmail.com");
			bean.setPassword("ayan123");
			bean.setDob(sdf.parse("2004-09-04"));

			model.insert(bean);

		}			 
		// ----------------------update table------------------

		public static void testUpdate() throws Exception,ParseException {
			UserBean bean=new UserBean();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			bean.setId(9);
			bean.setFirstName("Ayan");
			bean.setLastName("Ahmed Choudhary");
			bean.setLoginId("ayan@gmail.com");
			bean.setPassword("ayan123");
			bean.setDob(sdf.parse("2004-10-09"));

			
			model.update(bean);
			
		}

		// ----------------------delete table------------------
		
		public static void testDelete() throws Exception {
			
			model.delete(8);
			
		}
		public static void testFindByPk() throws Exception {

			UserBean bean = new UserBean();

			bean = model.findbypk(10);

			if (bean != null) {
				System.out.print(bean.getId());
				System.out.print("\t" + bean.getFirstName());
				System.out.print("\t" + bean.getLastName());
				System.out.print("\t" + bean.getLoginId());
				System.out.print("\t" + bean.getPassword());
				System.out.println("\t" + bean.getDob());
			} else {
				throw new RuntimeException("record not found");
			}

		}
		

}	
