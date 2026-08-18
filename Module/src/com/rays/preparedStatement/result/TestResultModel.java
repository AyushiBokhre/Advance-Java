package com.rays.preparedStatement.result;

public class TestResultModel {
	public static void main(String[] args) throws Exception {
		//testCreate();
		testInsert();
		//testUpdate();
		//testDelete();
		
	}
	// ----------------------create table-------------------

	public static void testCreate() throws Exception {
		ResultModel model = new ResultModel();
		model.create();
		}

	// ----------------------insert into table------------------

	public static void testInsert() throws Exception {
		 ResultModel model=new ResultModel();
		 
		 ResultBean bean =new ResultBean();
			 
		 bean.setResultId(5);
		 bean.setStudentId(105);
		 bean.setPercentage(69);
		 bean.setGrade("B");
		 bean.setResultStatus("pass");
			 
		 model.insert(bean);
			 

		 }
		 
		// ----------------------update table------------------

			public static void testUpdate() throws Exception {

				ResultModel model = new ResultModel();
				
				ResultBean bean=new ResultBean();
				 bean.setResultId(1);
				 bean.setStudentId(101);
				 bean.setPercentage(89);
				 bean.setGrade("A");
				 bean.setResultStatus("pass");

				model.update(bean);

			}

			// ----------------------delete table------------------

			public static void testDelete() throws Exception {

				ResultModel model = new ResultModel();

				model.delete(8);

			}

			 

}
