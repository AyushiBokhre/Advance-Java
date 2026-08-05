package com.rays.jdbc.preparedstatement;

public class TestMarksheetModel {
	public static void main(String[] args) throws Exception {
		testInsert();
	}
	
		 public static void testInsert() throws Exception {
			 MarksheetModel model=new MarksheetModel();
			 
			 MarksheetBean bean =new MarksheetBean();
			 
			 bean.setId(32);
			 bean.setRollno(132);
			 bean.setName("Aryan");
			 bean.setPhy(90);
			 bean.setChem(79);
			 bean.setMath(89);
			 
			 model.insert(bean);
			 

		 }
			 
		 
	}


