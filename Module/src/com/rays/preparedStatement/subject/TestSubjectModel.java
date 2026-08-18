package com.rays.preparedStatement.subject;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

public class TestSubjectModel {
	public static SubjectModel sm = new SubjectModel();

	public static void main(String[] args) throws Exception {
		// testCreate();
		//testInsert();
		//testUpdate();
		//testDelete();
		//testFindByPk();
		testSearch();
	}

	// ------------------create table-------------------
	public static void testCreate() throws SQLException {
		sm.create();
	}

	// ------------------insert values into table-------------------
	public static void testInsert() throws SQLException {
		SubjectBean bean = new SubjectBean();
		bean.setSubjectId(105);
		bean.setSubjectName("Operating System");
		bean.setSubjectCode("OS302");
		bean.setCredits(4);
		bean.setSemester(5);


		sm.insert(bean);
	}

	// ------------------update values into table-------------------
	public static void testUpdate() throws SQLException {
		SubjectBean bean = new SubjectBean();

		bean.setSubjectId(108);
		bean.setSubjectName("Java Programming");
		bean.setSubjectCode("JAVA305");
		bean.setCredits(4);
		bean.setSemester(8);

		sm.update(bean);
	}

	// ------------------delete values from table-------------------
	public static void testDelete() throws Exception {
		SubjectBean bean = new SubjectBean();

		bean.setSubjectId(1);

		sm.delete(1);
	}

	// ------------------findbypk-------------------
	public static void testFindByPk() {
		SubjectBean bean = new SubjectBean();
		bean = sm.findByPk(101);
		if (bean != null) {
			System.out.print(bean.getSubjectId());
			System.out.print("\t" + bean.getSubjectName());
			System.out.print("\t" + bean.getSubjectCode());
			System.out.print("\t" + bean.getCredits());
			System.out.println("\t" + bean.getSemester());
			
		} else {
			throw new RuntimeException("record not found");
		}

	}
	
	//---------------------search----------------------
	public static void testSearch() throws SQLException {

		SubjectBean bean = new SubjectBean();
//	bean.setSubjectName("D");
		List<SubjectBean> list = sm.search(bean, 1, 10);

		Iterator<SubjectBean> it = list.iterator();

		while (it.hasNext()) {
			bean = it.next();
			System.out.print(bean.getSubjectId());
			System.out.print("\t" + bean.getSubjectName());
			System.out.print("\t" + bean.getSubjectCode());
			System.out.print("\t" + bean.getCredits());
			System.out.println("\t" + bean.getSemester());
			
		}

	}

}
