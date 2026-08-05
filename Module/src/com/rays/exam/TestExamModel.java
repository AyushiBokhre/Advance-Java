package com.rays.exam;

import java.text.SimpleDateFormat;

public class TestExamModel {
	public static void main(String[] args) throws Exception {
		// testCreate();
		// testInsert();
		// testUpdate();
		testDelete();
	}

	// ----------------------create table-------------------

	public static void testCreate() throws Exception {
		ExamModel model = new ExamModel();
		model.create();
	}

	// ----------------------insert into table------------------

	public static void testInsert() throws Exception {
		ExamModel model = new ExamModel();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		model.insert(101, "Java Programming", sdf.parse("2026-08-10"), 100, 40);
		model.insert(102, "Database Management", sdf.parse("2026-08-15"), 100, 35);
		model.insert(103, "Operating System", sdf.parse("2026-08-20"), 100, 40);
		model.insert(104, "Computer Networks", sdf.parse("2026-08-25"), 100, 40);
		model.insert(105, "Software Engineering", sdf.parse("2026-08-30"), 100, 35);

	}

	// ----------------------update table------------------

	public static void testUpdate() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		ExamModel model = new ExamModel();

		model.update(105, "Operating System", sdf.parse("2026-09-20"), 100, 40);

	}

	// ----------------------delete table------------------

	public static void testDelete() throws Exception {

		ExamModel model = new ExamModel();

		model.delete(8);

	}

}
