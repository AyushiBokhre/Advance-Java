package com.rays.preparedStatement.vehicle;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

public class TestVehicleModel {
	public static VehicleModel vm = new VehicleModel();

	public static void main(String[] args) throws SQLException {
		// testCreate();
		// testInsert();
		// testUpdate();
		// testDelete();
		testSearch();
	}

	public static void testCreate() throws SQLException {
		vm.create();

	}

	public static void testInsert() throws SQLException {
		VehicleBean bean = new VehicleBean();

		bean.setVehicleId(1001);
		bean.setVehicleName("BMW");
		bean.setModel("M5");
		bean.setColor("black");
		bean.setPrice(2000000);
		vm.insert(bean);

		bean = new VehicleBean();
		bean.setVehicleId(1002);
		bean.setVehicleName("Audi");
		bean.setModel("A4");
		bean.setColor("white");
		bean.setPrice(3500000);
		vm.insert(bean);

		bean = new VehicleBean();
		bean.setVehicleId(1003);
		bean.setVehicleName("Toyota");
		bean.setModel("Fortuner");
		bean.setColor("black");
		bean.setPrice(4200000);
		vm.insert(bean);

		bean = new VehicleBean();
		bean.setVehicleId(1004);
		bean.setVehicleName("Mercedes");
		bean.setModel("C-Class");
		bean.setColor("blue");
		bean.setPrice(5500000);
		vm.insert(bean);

		bean = new VehicleBean();
		bean.setVehicleId(1005);
		bean.setVehicleName("Honda");
		bean.setModel("City");
		bean.setColor("silver");
		bean.setPrice(1500000);
		bean.setVehicleId(1005);
		vm.insert(bean);
	}

	public static void testUpdate() throws SQLException {
		VehicleBean bean = new VehicleBean();
		bean.setVehicleId(1001);
		bean.setVehicleName("BMW");
		bean.setModel("M5");
		bean.setColor("black");
		bean.setPrice(10000000);
		vm.update(bean);
	}

	public static void testDelete() throws SQLException {
		vm.delete(1001);
	}

	// ---------------------search----------------------
	public static void testSearch() throws SQLException {

		VehicleBean bean = new VehicleBean();
//		bean.setVehicleName("D");
		List<VehicleBean> list = vm.search(bean, 1, 10);

		Iterator<VehicleBean> it = list.iterator();

		while (it.hasNext()) {
			bean = it.next();
			System.out.print(bean.getVehicleId());
			System.out.print("\t" + bean.getVehicleName());
			System.out.print("\t" + bean.getModel());
			System.out.print("\t" + bean.getColor());
			System.out.println("\t" + bean.getPrice());

		}

	}
}
