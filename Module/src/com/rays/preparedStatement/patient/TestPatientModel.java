package com.rays.preparedStatement.patient;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

public class TestPatientModel {
	public static PatientModel pm = new PatientModel();

	public static void main(String[] args) throws Exception {
//		testCreate();
//		testInsert();
//		testUpdate();
//		testDelete();
		testSearch();
	}

	public static void testCreate() throws Exception {
		pm.create();

	}

	public static void testInsert() throws Exception {
		PatientBean bean = new PatientBean();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		bean.setPatientId(1001);
		bean.setPatientName("Rahul Sharma");
		bean.setDisease("Fever");
		bean.setDoctorName("Dr. Amit");
		bean.setAdmissionDate(sdf.parse("10-08-2026"));
		pm.insert(bean);

	}

	public static void testUpdate() throws Exception {
		PatientBean bean = new PatientBean();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		bean.setPatientId(1001);
		bean.setPatientName("Rahul Sharma");
		bean.setDisease("Fever");
		bean.setDoctorName("Dr. Amit");
		bean.setAdmissionDate(sdf.parse("10-08-2026"));
		pm.update(bean);

	}

	public static void testDelete() throws SQLException {
		pm.delete(1001);
	}

	// ---------------------search----------------------
	public static void testSearch() throws SQLException {

		PatientBean bean = new PatientBean();
//		bean.setPatientName("D");
		List<PatientBean> list = pm.search(bean, 1, 10);

		Iterator<PatientBean> it = list.iterator();

		while (it.hasNext()) {
			bean = it.next();
			System.out.print(bean.getPatientId());
			System.out.print("\t" + bean.getPatientName());
			System.out.print("\t" + bean.getDisease());
			System.out.print("\t" + bean.getDoctorName());
			System.out.println("\t" + bean.getAdmissionDate());

		}
	}

}
