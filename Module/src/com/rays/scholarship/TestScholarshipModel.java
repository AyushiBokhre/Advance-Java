package com.rays.scholarship;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;


public class TestScholarshipModel {
	public static ScholarshipModel sm=new ScholarshipModel();
	public static void main(String[] args) throws Exception {
		//testCreate();
		//testInsert();
		//testUpdate();
		//testDelete();
		testSearch();
		
		}
	public static void testCreate() throws Exception {
		sm.create();
	}
	public static void testInsert() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		// 1
		ScholarshipBean bean = new ScholarshipBean();
		bean.setScholarshipId(1);
		bean.setScholarshipName("Merit Scholarship");
		bean.setAmount(28700);
		bean.setEligibility("Minimum 75% marks");
		bean.setLastDate(sdf.parse("2026-09-04"));
		sm.insert(bean);


		// 2
		bean = new ScholarshipBean();
		bean.setScholarshipId(2);
		bean.setScholarshipName("Sports Scholarship");
		bean.setAmount(25000);
		bean.setEligibility("State level sports certificate");
		bean.setLastDate(sdf.parse("2026-09-10"));
		sm.insert(bean);


		// 3
		bean = new ScholarshipBean();
		bean.setScholarshipId(3);
		bean.setScholarshipName("Girl Child Scholarship");
		bean.setAmount(30000);
		bean.setEligibility("Minimum 70% marks");
		bean.setLastDate(sdf.parse("2026-09-15"));
		sm.insert(bean);


		// 4
		bean = new ScholarshipBean();
		bean.setScholarshipId(4);
		bean.setScholarshipName("SC/ST Scholarship");
		bean.setAmount(35000);
		bean.setEligibility("Valid caste certificate");
		bean.setLastDate(sdf.parse("2026-09-20"));
		
		sm.insert(bean);


		// 5
		bean = new ScholarshipBean();
		bean.setScholarshipId(5);
		bean.setScholarshipName("Financial Aid Scholarship");
		bean.setAmount(20000);
		bean.setEligibility("Family income below 3 LPA");
		bean.setLastDate(sdf.parse("2026-09-25"));
		sm.insert(bean);
	}
	// ----------------------update table------------------

	public static void testUpdate() throws Exception,ParseException {
		ScholarshipBean bean=new ScholarshipBean();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		bean.setScholarshipId(5);
		bean.setScholarshipName("Financial Aid Scholarship");
		bean.setAmount(20000);
		bean.setEligibility("Family income below 3 LPA");
		bean.setLastDate(sdf.parse("2026-10-03"));
			
		sm.update(bean);
				
		}
	//-----------------------delete from table--------------------
	public static void testDelete() throws Exception {
		sm.delete(101);
		
	}
	//--------------------------search---------------
	public static void testSearch() throws Exception {
		ScholarshipBean bean = new ScholarshipBean();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//		bean.setLastDate(sdf.parse("2026-09-25"));
			List<ScholarshipBean> list = sm.search(bean, 1, 5);

			Iterator<ScholarshipBean> it = list.iterator();

			while (it.hasNext()) {
				bean = it.next();
				System.out.print(bean.getScholarshipId());
				System.out.print("\t" + bean.getScholarshipName());
				System.out.print("\t" + bean.getAmount());
				System.out.print("\t" + bean.getEligibility());
				System.out.println("\t" + bean.getLastDate());
				
			}
	}
		

}
