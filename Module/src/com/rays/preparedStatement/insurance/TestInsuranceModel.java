package com.rays.preparedStatement.insurance;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TestInsuranceModel {
public static InsuranceModel bm=new InsuranceModel();
	
	public static void main(String[] args) throws Exception {
		//testCreate();
		testInsert();
		//testUpdate();
		//testDelete();
		//testSearch();
	}
	
	public static void testCreate() throws SQLException {
		bm.create();
	}
	
	public static void testInsert() throws ParseException, SQLException {
		InsuranceBean bean = new InsuranceBean();
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		bean.setPolicyId(103);
		bean.setPolicyHolderName("DreamLand");
		bean.setPolicyType("Mhow");
		bean.setPremiumAmount(100000);
		bean.setExpiryDate(sdf.parse("20-04-2030"));
		bm.insert(bean);
	}
	
	

}
