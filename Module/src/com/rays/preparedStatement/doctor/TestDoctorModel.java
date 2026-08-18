package com.rays.preparedStatement.doctor;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestDoctorModel {
	public static DoctorModel dm = new DoctorModel();

	public static void main(String[] args) throws SQLException {
		//testCreate();
		//testInsert();
		//testUpdate();
		//testDelete();
		testSearch();
	}

	public static void testCreate() throws SQLException {
		dm.create();

	}
	
	public static void testInsert() throws SQLException {
		DoctorBean bean =new DoctorBean();
		bean.setDoctorId(1002);
		bean.setDoctorName("Dr. Devendra Singh Shekhawat");
		bean.setSpecialization("Cardiologist");
		bean.setExperience(3);
		bean.setContactNo("9876543210");
		dm.insert(bean);
	}
	
	
	public static void testUpdate() throws SQLException {
		DoctorBean bean =new DoctorBean();
		bean.setDoctorId(1002);
		bean.setDoctorName("Dr. Devendra Singh Shekhawat");
		bean.setSpecialization("Cardiologist");
		bean.setExperience(3);
		bean.setContactNo("9876543210");
		dm.update(bean);
	}
	
	
	public static void testDelete() throws SQLException {
		dm.delete(1001);
	}
	
	public static void testSearch() throws SQLException {
		DoctorBean bean =new DoctorBean();
		List<DoctorBean> list =dm.search(bean,1,5);
		Iterator<DoctorBean> it=list.iterator();
		while (it.hasNext()) {
			bean = it.next();
			System.out.print(bean.getDoctorId());
			System.out.print("\t" + bean.getDoctorName());
			System.out.print("\t" + bean.getSpecialization());
			System.out.print("\t" + bean.getExperience());
			System.out.println("\t" + bean.getContactNo());
			
		}
		
	}
}
